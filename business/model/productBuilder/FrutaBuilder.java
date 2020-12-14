package business.model.productBuilder;

public class FrutaBuilder extends ProdcutBuilder {

    @Override
    public void buildName() {
        // Operação Complexa
        prod.name = "Maçã";
    }

    @Override
    public void buildDescription() {
        // Operação Complexa
        prod.description = "Maçã fuji";
    }

    @Override
    public void buildImgLink() {
        // Operação Complexa
        prod.imgLink = "link";
    }

    @Override
    public void buildQuantity() {
        // Operação Complexa
        prod.quantity = 7;
    }
}
