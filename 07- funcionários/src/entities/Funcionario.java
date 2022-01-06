package entities;

public class Funcionario {

    private Integer id;
    private String nome;
    private Double salario;

    @Override
    public String toString() {
        return "Id: "+ id +". Nome: "+ nome +". Salário: R$"+ String.format("%.2f", salario);
    }

    public Funcionario(){
    }

    public Funcionario(Integer id, String nome, Double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentaSalario(double aumento){
        salario += salario*(aumento/100);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }
}
