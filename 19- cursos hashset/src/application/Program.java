package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> cursoA = new HashSet<>();
        Set<Integer> cursoB = new HashSet<>();
        Set<Integer> cursoC = new HashSet<>();

        System.out.print("Qtd alunos curso A: ");
        int qtd = sc.nextInt();
        for (int i=0; i<qtd; i++){
            int id = sc.nextInt();
            cursoA.add(id);
        }

        System.out.print("Qtd alunos curso B: ");
        qtd = sc.nextInt();
        for (int i=0; i<qtd; i++){
            int id = sc.nextInt();
            cursoB.add(id);
        }

        System.out.print("Qtd alunos curso C: ");
        qtd = sc.nextInt();
        for (int i=0; i<qtd; i++){
            int id = sc.nextInt();
            cursoC.add(id);
        }

        Set<Integer> totalAlunos = new HashSet<>(cursoA);
        totalAlunos.addAll(cursoB);
        totalAlunos.addAll(cursoC);

        System.out.println("Total de alunos: "+ totalAlunos.size());

    }
}
