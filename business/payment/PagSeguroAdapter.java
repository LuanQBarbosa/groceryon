package business.payment;

public class PagSeguroAdapter extends PagSeguro implements PagamentoAdapter {
    @Override
    public void confirmarPagamento() {
        psConfirmarPagamento();
    }

}