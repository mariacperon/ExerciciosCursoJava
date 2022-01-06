package entities;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a cotação do dólar? ");
        double cotacao = sc.nextDouble();

        System.out.print("Quantos dólares serão convertidos? ");
        double dolares = sc.nextDouble();

        System.out.println("Valor a ser pagado em reais: R$"+ Conversor.conversorDolar(dolares, cotacao));
    }
}
