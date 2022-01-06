package application;

import exceptions.DomainException;
import models.Conta;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("DADOS DA CONTA:");
            System.out.print("Número: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.print("Proprietário: ");
            String proprietario = sc.nextLine();
            System.out.print("Valor inicial: ");
            double valor = sc.nextDouble();
            System.out.print("Limite de saque: ");
            double limiteSaque = sc.nextDouble();
            Conta conta = new Conta(numero, proprietario, valor, limiteSaque);

            System.out.println();
            System.out.print("Saque: ");
            double saque = sc.nextDouble();
            conta.saque(saque);

            System.out.println("Novo valor: R$"+ conta.getValor());
        }catch (DomainException e){
            System.out.println("Erro: "+ e.getMessage());
        }

    }
}
