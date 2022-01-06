package application;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //pede o tamanho da matriz
        System.out.print("Tamanho da matriz: ");
        int tam = sc.nextInt();

        //cria a matriz
        Integer[][] matriz = new Integer[tam][tam];

        //loop para adicionar itens a matriz
        for(int i=0; i< matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print("Digite o valor da posição ["+ i +"]["+ j +"]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        //loop para coletar a matriz diagonal
        Integer[] diagonal = new Integer[tam];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if(i == j){
                    diagonal[i] = matriz[i][j];
                }
            }
        }

        //loop para encontrar a qtd de números negativos
        int cont = 0;
        for(int i=0; i< matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if(matriz[i][j] < 0){
                    cont++;
                }
            }
        }

        //mostra os dados coletados na tela
        System.out.println("DIAGONAL PRINCIPAL:");
        for(int i=0; i< matriz.length; i++){
            System.out.print(" "+ diagonal[i] +" ");
        }
        System.out.println();
        System.out.println("Existem "+ cont +" números negativos.");

    }
}
