package business.payment;

public class PagamentoPresencialAdapter extends PagamentoPresencial implements PagamentoAdapter {
    @Override
    public void confirmarPagamento() {
        ppConfirmarPagamento();
    }
}