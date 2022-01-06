package entities;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.print("Nome: ");
        aluno.nome = sc.nextLine();

        System.out.print("Nota 1: ");
        aluno.nota1 = sc.nextDouble();

        System.out.print("Nota 2: ");
        aluno.nota2 = sc.nextDouble();

        System.out.print("Nota 3: ");
        aluno.nota3 = sc.nextDouble();

        System.out.println("Nota final = "+ aluno.notaFinal());

        if(aluno.notaFinal()>=60){
            System.out.println("APROVADO");
        }else{
            System.out.println("REPROVADO");
            System.out.println("Faltaram "+ (60-aluno.notaFinal()) +" pontos para aprovação.");
        }

    }
}
