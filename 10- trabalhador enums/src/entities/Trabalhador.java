package entities;

import enums.Nivel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private Nivel nivel;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoHora> contratos = new ArrayList<>();

    @Override
    public String toString() {
        return "Nome: "+ nome +". Nível: "+ nivel +". Salário Base: "+ salarioBase +".";
    }

    public Trabalhador(){
    }

    public Trabalhador(String nome, Nivel nivel, double salarioBase, Departamento departamento){
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public void adicionarContrato(ContratoHora contrato){
        contratos.add(contrato);
    }

    public void removerContrato(ContratoHora contrato){
        contratos.remove(contrato);
    }

    public double recebimento(int ano, int mes){
        double salarioFinal = salarioBase;
        Calendar cal = Calendar.getInstance();

        for (ContratoHora contrato : contratos) {
            cal.setTime(contrato.getData());
            int contratoAno = cal.get(Calendar.YEAR);
            int contratoMes = 1 + cal.get(Calendar.MONTH);

            if(ano == contratoAno && mes == contratoMes){
                salarioFinal += contrato.valorTotal();
            }
        }

        return salarioFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
