package application;

import entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {

        List<Funcionario> funcionarios = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("File path: ");
        String arquivo = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            String linha = br.readLine();

            while (linha != null){
                String[] dados = linha.split(",");
                String nome = dados[0];
                String email = dados[1];
                Double salario = Double.parseDouble(dados[2]);

                funcionarios.add(new Funcionario(nome, email, salario));
                linha = br.readLine();
            }

            System.out.print("Base salário: ");
            double salario = sc.nextDouble();

            List<String> emails = funcionarios.stream().filter(x -> x.getSalario() > salario)
                    .map(x -> x.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            double sumSalarios = funcionarios.stream()
                    .filter(x -> x.getNome().charAt(0) == 'M').map(x -> x.getSalario())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("LISTA DOS FUNCIONÁRIOS COM SALÁRIO MAIOR QUE R$"+ salario +":");
            emails.forEach(System.out::println);

            System.out.println("A soma dos salários dos nomes de funcionários que começam com M: R$"+ sumSalarios);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
