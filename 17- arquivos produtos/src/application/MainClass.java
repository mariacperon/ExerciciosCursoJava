package application;

import entities.Produto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();

        System.out.println("Path do arquivo .cvs:");
        String path = sc.nextLine();

        File arquivo = new File(path);
        String pastaArquivo = arquivo.getParent();

        boolean novaPasta = new File(pastaArquivo + "\\out").mkdir();
        String novoArquivo = pastaArquivo + "\\out\\summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String itemCVS = br.readLine();
            while(itemCVS != null){
                String[] item = itemCVS.split(",");
                String nome = item[0];
                Double preco = Double.parseDouble(item[1]);
                Integer qtd = Integer.parseInt(item[2]);

                produtos.add(new Produto(nome, preco, qtd));
                itemCVS = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(novoArquivo))){
                for (Produto produto : produtos) {
                    bw.write(produto.getNome() + "," + String.format("%.2f", produto.precoTotal()));
                    bw.newLine();
                }

                System.out.println(novoArquivo + " CRIADO!");

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();

    }
}
