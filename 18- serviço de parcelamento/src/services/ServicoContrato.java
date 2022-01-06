package services;

import entities.Contrato;
import entities.Parcela;

import java.util.Calendar;
import java.util.Date;

public class ServicoContrato {

    protected ServicoPagamentoOnline servicoPgtoOn;

    public ServicoContrato(ServicoPagamentoOnline servicoPgtoOn) {
        this.servicoPgtoOn = servicoPgtoOn;
    }

    public void processarContrato(Contrato contrato, int meses){
        double parcela = contrato.getValorTotal() / meses;
        for(int i=0; i<meses; i++){
            Date data = addMonths(contrato.getData(), i+1);
            double parcelaJuros = parcela + servicoPgtoOn.juros(parcela, i+1);
            double parcelafinal = parcelaJuros + servicoPgtoOn.taxaPagamento(parcelaJuros);
            contrato.adicionarParcela(new Parcela(data, parcelafinal));
        }
    }

    private Date addMonths(Date data, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

}
