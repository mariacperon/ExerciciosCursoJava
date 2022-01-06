package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    protected Date dataVencimento;
    protected Double valor;

    public Parcela(Date dataVencimento, Double valor) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return sdf.format(dataVencimento) + " - " + String.format("%.2f", valor);
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
