package application;

import entities.Quartos;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Quartos[] quartos = new Quartos[9];

        System.out.print("Quantos estudantes alugarão quartos? ");
        int qtd = sc.nextInt();

        sc.nextLine();
        System.out.print("Informe o aluguel desses quartos: R$");
        double aluguel = sc.nextDouble();

        for(int i=0; i<qtd; i++){
            sc.nextLine();
            System.out.print("Número do quarto: ");
            int numeroQuarto = sc.nextInt();

            sc.nextLine();
            System.out.print("Nome do aluno: ");
            String nomeAluno = sc.nextLine();

            System.out.print("Email do aluno: ");
            String emailAluno = sc.nextLine();

            quartos[numeroQuarto] = new Quartos(aluguel, numeroQuarto, nomeAluno, emailAluno);
        }


        for (int i=0; i<9; i++){
            if(quartos[i] != null){
                System.out.println(quartos[i].toString());
            }
        }


    }

}
