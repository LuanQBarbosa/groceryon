package business.model.productBuilder;

public abstract class ProductBuilder {
    protected Product prod = new Product();
    public abstract void buildName();
	public abstract void buildDescription();
	public abstract void buildImgLink();
	public abstract void buildQuantity();
	public Product getProduto(){
		return prod;
	};
}
