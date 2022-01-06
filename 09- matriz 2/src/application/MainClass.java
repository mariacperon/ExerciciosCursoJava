package application;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o número de linhas: ");
        int linhas = sc.nextInt();
        System.out.print("Informe o número de colunas: ");
        int colunas = sc.nextInt();

        Integer[][] matriz = new Integer[linhas][colunas];

        for(int m=0; m<linhas; m++){
            for(int n=0; n<colunas; n++){
                matriz[m][n] = sc.nextInt();
            }
        }

        System.out.print("Digite o número a ser pesquisado: ");
        int num = sc.nextInt();

        int ocorrencia = 0;

        for(int m=0; m<linhas; m++){
            for(int n=0; n<colunas; n++){
                if(matriz[m][n] == num){
                    ocorrencia++;
                    System.out.println("==================");
                    System.out.println("OCORRÊNCIA N°"+ ocorrencia);
                    if(m>0){
                        System.out.println("Acima de "+ num +": "+ matriz[m-1][n]);
                    }
                    if(n>0){
                        System.out.println("A esquerda de "+ num +": "+ matriz[m][n-1]);
                    }
                    if(n<matriz[m].length-1){ //matriz[5][6]
                        System.out.println("A direita de "+ num +": "+ matriz[m][n+1]);
                    }
                    if(m<matriz.length-1) {
                        System.out.println("Abaixo de "+ num +": "+ matriz[m+1][n]);
                    }
                    System.out.println("==================");
                }
            }
        }

    }
}
