package business.model.productBuilder;

public class Director {
    protected ProductBuilder prodBuilder;

    public Director(ProductBuilder prodBuilder){
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
