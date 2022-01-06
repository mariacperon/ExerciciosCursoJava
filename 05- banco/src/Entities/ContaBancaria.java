package Entities;

public class ContaBancaria {

    public static double taxaSaque = 5.00;

    private int numeroConta;
    private String nomeTitular;
    private double valorConta;

    public ContaBancaria(int numeroConta, String nomeTitular){
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public ContaBancaria(int numeroConta, String nomeTitular, double depositoInicial){
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        deposito(depositoInicial);
    }

    public void deposito(double valorDeposito){
        this.valorConta += valorDeposito;
    }

    public void saque(double valorSaque){
        valorSaque += taxaSaque;
        this.valorConta -= valorSaque;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getValorConta() {
        return valorConta;
    }

    @Override
    public String toString() {
        return "Número da conta: "+ getNumeroConta() +", Nome do titular: "+ getNomeTitular()+
                ", Valor na conta: R$"+ getValorConta();
    }
}
