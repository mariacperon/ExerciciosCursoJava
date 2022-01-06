package models;

import exceptions.DomainException;

public class Conta {

    protected Integer numero;
    protected String proprietario;
    protected Double valor;
    protected Double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String proprietario, Double valor, Double limiteSaque) {
        this.numero = numero;
        this.proprietario = proprietario;
        this.valor = valor;
        this.limiteSaque = limiteSaque;
    }

    public void deposito(Double valorDeposito){
        valor += valorDeposito;
    }

    public void saque(Double valorSaque) throws DomainException {
        if(valor < valorSaque){
            throw new DomainException("Não existe saldo suficiente.");
        }else if(valorSaque > limiteSaque){
            throw new DomainException("Valor de saque excede limite");
        }
        valor -= valorSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
}
