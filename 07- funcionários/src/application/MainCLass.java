package application;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCLass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Funcionario> funcionario = new ArrayList<>();

        System.out.print("Digite o número de funcionários a serem cadastrados: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            System.out.print("ID: ");
            int id = sc.nextInt();

            while(hasId(funcionario, id)) {
                System.out.print("ID já existente, digite novamente: ");
                id = sc.nextInt();
            }

            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Salário: ");
            Double salario = sc.nextDouble();

            Funcionario novo = new Funcionario(id, nome, salario);
            funcionario.add(novo);
        }

        System.out.println("======================");
        System.out.println("Lista de funcionários cadastrados: ");
        for (Funcionario func :  funcionario) {
            System.out.println(func);
        }
        System.out.println("======================");

        System.out.print("ID do funcionário a receber o aumento: ");
        int id = sc.nextInt();

        Funcionario result = funcionario.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if(result != null){
            System.out.print("Porcentagem de aumento: ");
            double aumento = sc.nextDouble();
            result.aumentaSalario(aumento);
        }else{
            System.out.println("Este ID não existe.");
        }

        System.out.println("======================");
        System.out.println("Lista de funcionários atualizados: ");
        for (Funcionario func :  funcionario) {
            System.out.println(func);
        }
        System.out.println("======================");

    }

    public static boolean hasId(List<Funcionario> lista, int id) {
        Funcionario resp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return resp != null;
    }
}
