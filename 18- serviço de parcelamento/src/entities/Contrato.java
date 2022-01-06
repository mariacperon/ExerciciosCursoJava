package entities;

import services.ServicoPagamentoOnline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

    protected Integer numero;
    protected Date data;
    protected Double valorTotal;

    List<Parcela> parcelas = new ArrayList<>();
    protected ServicoPagamentoOnline servicoPagtoOn;

    public Contrato(Integer numero, Date data, Double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public void adicionarParcela(Parcela parcela){
        parcelas.add(parcela);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public ServicoPagamentoOnline getServicoPagtoOn() {
        return servicoPagtoOn;
    }

    public void setServicoPagtoOn(ServicoPagamentoOnline servicoPagtoOn) {
        this.servicoPagtoOn = servicoPagtoOn;
    }
}
