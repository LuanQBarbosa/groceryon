package infra;

import business.model.Product;
import util.InfraException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class ProductFileDao implements ProductDao {

  private final String fileName;

  public ProductFileDao(String fileName) {
    this.fileName = fileName;
  }

	@Override
	public Map<String, Product> loadProducts() throws InfraException {
    Map<String, Product> products = null;

      try {
          File saveFile = getFile();
          if(saveFile.length() == 0) // se o arquivo for vazio
              return new TreeMap<>();
          FileInputStream fileIn = new FileInputStream(saveFile);
          ObjectInputStream in = new ObjectInputStream(fileIn);
          products = (Map<String, Product>) in.readObject();
          in.close();
          fileIn.close();
      } catch (IOException | ClassNotFoundException e) {
          throw new InfraException("**Product's file error**");
      }

      return products;
	}

	@Override
	public void saveProducts(Map<String, Product> products) throws InfraException {
		try {
          FileOutputStream fileOut = new FileOutputStream(getFile());
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(products);
          out.close();
          fileOut.close();
      } catch (IOException i) {
          throw new InfraException("**Product's file error**");

      }
		
  }
  
  private File getFile() throws IOException {
      File file = new File(this.fileName);
      file.createNewFile();
      return file;
  }
  
}
