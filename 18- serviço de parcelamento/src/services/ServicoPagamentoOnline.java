package services;

public interface ServicoPagamentoOnline {

    public double taxaPagamento(double quantidade);

    public double juros(double amount, int meses);

}
