package services;

public class PayPalService implements ServicoPagamentoOnline{

    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public double taxaPagamento(double quantidade) {
        return quantidade * FEE_PERCENTAGE;
    }

    @Override
    public double juros(double quantidade, int meses) {
        return quantidade * MONTHLY_INTEREST * meses;
    }
}
