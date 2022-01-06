package models;

public class PessoaFisica extends Pessoa {

    protected Double gastoSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double impostosAPagar() {
        double impostos = 0;
        if(rendaAnual < 20000){
            impostos = (rendaAnual*0.15) - (gastoSaude*0.5);
        }else{
            impostos = (rendaAnual*0.25) - (gastoSaude*0.5);
        }
        return impostos;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }
}
