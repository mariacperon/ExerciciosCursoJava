package Application;

import Entities.ContaBancaria;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria conta;

        System.out.print("Número da conta: ");
        int numeroConta = sc.nextInt();

        sc.nextLine();
        System.out.print("Nome do titular: ");
        String nomeTitular = sc.nextLine();

        System.out.print("Deseja fazer um despósito incial?(s/n) ");
        char resp = sc.next().charAt(0);

        if(resp == 's'){
            System.out.print("Depósito incial: ");
            double depositoInicial = sc.nextDouble();
            conta = new ContaBancaria(numeroConta, nomeTitular, depositoInicial);
        }else{
            conta = new ContaBancaria(numeroConta, nomeTitular);
        }

        System.out.println("DADOS BANCÁRIOS:");
        System.out.println(conta.toString());


        System.out.print("Valor do depósito: ");
        double valorDeposito = sc.nextDouble();
        conta.deposito(valorDeposito);

        System.out.println("DADOS BANCÁRIOS ATUALIZADOS:");
        System.out.println(conta.toString());

        System.out.print("Valor do saque: ");
        double valorSaque = sc.nextDouble();
        conta.saque(valorSaque);

        System.out.println("DADOS BANCÁRIOS ATUALIZADOS:");
        System.out.println(conta.toString());
    }
}
