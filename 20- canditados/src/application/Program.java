package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> lista = new LinkedHashMap<>();

        System.out.print("File path: ");
        String arquivo = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            String linha = br.readLine();
            while(linha != null){
                String[] dados = linha.split(",");
                String nome = dados[0];
                int votos = Integer.parseInt(dados[1]);

                if(lista.containsKey(nome)){
                    int votosAnt = lista.get(nome);
                    lista.put(nome, votos + votosAnt);
                }else{
                    lista.put(nome, votos);
                }

                linha = br.readLine();
            }

            for (String chave : lista.keySet()) {
                System.out.println(chave + ": " + lista.get(chave));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
