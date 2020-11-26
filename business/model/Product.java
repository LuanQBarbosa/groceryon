package business.model;

import java.io.Serializable;

public class Product implements Serializable {
  
  private static final long serialVersionUID = 8822797079972186921L;
  
  private String name;
  private String description;
  private String imgLink;
  private int quantity;

  public Product(String name, String description, String imgLink) {
    this.name = name;
    this.description = description;
    this.imgLink = imgLink;
    this.quantity = 0;
  }

  public Product() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImgLink() {
    return imgLink;
  }

  public void setImgLink(String imgLink) {
    this.imgLink = imgLink;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
