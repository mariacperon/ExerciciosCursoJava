package entities;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Retangulo retangulo = new Retangulo();

        System.out.print("Digite a altura do retângulo: ");
        retangulo.altura = sc.nextDouble();
        System.out.println();
        System.out.print("Digite a largura do retângulo: ");
        retangulo.largura = sc.nextDouble();

        System.out.println("ÁREA = "+ retangulo.area());
        System.out.println("PERÍMETRO = "+ retangulo.perimetro());
        System.out.println("DIAGONAL = "+ retangulo.diagonal());
    }
}
