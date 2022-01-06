package entities;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario pessoa = new Funcionario();

        System.out.print("Nome: ");
        pessoa.nome = sc.nextLine();


        System.out.print("Salário Bruto: ");
        pessoa.salarioBruto = sc.nextDouble();

        System.out.print("Imposto: ");
        pessoa.imposto = sc.nextDouble();
        System.out.println();

        System.out.println("Funcionário: "+pessoa.nome+", $"+pessoa.salarioLiquido());

        System.out.print("Qual a porcentagem de aumento de salário? ");
        pessoa.aumentoSalario(sc.nextDouble());

        System.out.println("-DADOS ATUALIZADOS- Funcionário: "+pessoa.nome+", $"+pessoa.salarioLiquido());
    }

}
