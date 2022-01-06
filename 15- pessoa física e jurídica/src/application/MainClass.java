package application;

import models.Pessoa;
import models.PessoaFisica;
import models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Quantidade de pessoas a pagar: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            System.out.print("Pessoa jurídica ou física? (j/f) ");
            char resp = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Renda anual: ");
            Double rendaAnual = sc.nextDouble();

            sc.nextLine();
            if(resp == 'j'){
                System.out.print("Número de funcionários: ");
                Integer numFuncionarios = sc.nextInt();
                pessoas.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
            }else{
                System.out.print("Gasto com saúde: R$");
                Double gastoSaude = sc.nextDouble();
                pessoas.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
            }
        }

        double totalImpostos = 0;
        System.out.println("IMPOSTOS A PAGAR:");
        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa.getNome() +": R$"+ String.format("%.2f",pessoa.impostosAPagar()));
            totalImpostos += pessoa.impostosAPagar();
        }
        System.out.println("TOTAL DE IMPOSTOS: R$"+ String.format("%.2f", totalImpostos));

    }
}
