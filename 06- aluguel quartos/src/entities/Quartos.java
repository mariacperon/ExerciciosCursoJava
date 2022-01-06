package entities;

public class Quartos {

    public double aluguel;
    public int numeroQuarto;
    public String nomeAluno;
    public String emailAluno;

    public Quartos(double aluguel, int numeroQuarto, String nomeAluno, String emailAluno){
        this.aluguel = aluguel;
        this.numeroQuarto = numeroQuarto;
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
    }

    @Override
    public String toString() {
        return "Quarto: "+ this.numeroQuarto +". Aluguel: R$"+ this.aluguel +". Nome: "+ this.nomeAluno +". Email: "+ this.emailAluno;
    }
}
