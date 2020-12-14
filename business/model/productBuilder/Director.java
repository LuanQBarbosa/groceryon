package business.model.productBuilder;

public class Director {
    protected ProdcutBuilder prodBuilder;

    public Director(ProdcutBuilder prodBuilder){
        this.prodBuilder = prodBuilder;
    }

    public void build(){
        prodBuilder.buildName();
        prodBuilder.buildDescription();
        prodBuilder.buildImgLink();
        prodBuilder.buildQuantity();
    }

    public Product getProduct(){
        return prodBuilder.getProduto();
    }
}
