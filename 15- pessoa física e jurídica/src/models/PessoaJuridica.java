package models;

public class PessoaJuridica extends Pessoa {

    protected Integer numFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
        super(nome, rendaAnual);
        this.numFuncionarios = numFuncionarios;
    }

    @Override
    public double impostosAPagar() {
        double impostos = 0;
        if(numFuncionarios > 10){
            impostos = rendaAnual * 0.14;
        }else{
            impostos = rendaAnual * 0.16;
        }
        return impostos;
    }

    public Integer getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(Integer numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }
}
