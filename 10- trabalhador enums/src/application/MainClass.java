package application;

import com.sun.security.jgss.GSSUtil;
import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import enums.Nivel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class MainClass {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Departamento: ");
        String departamento = sc.nextLine();

        System.out.println("DADOS DO FUNCIONÁRIO:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nível: ");
        String nivel = sc.nextLine();
        System.out.print("Salário base: ");
        double salarioBase = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nome, Nivel.valueOf(nivel), salarioBase, new Departamento(departamento));

        System.out.print("Quantidade de contratos: ");
        int qtd = sc.nextInt();

        for(int i=0; i<qtd; i++){
            System.out.println("DADOS DO CONTRATO:");
            System.out.print("Data (dd/mm/yyyy): ");
            Date data = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Hora(s): ");
            int hora = sc.nextInt();

            ContratoHora contrato = new ContratoHora(data, valorPorHora, hora);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.print("Digite o mês e o ano para fazer a pesquisa (mm/yyyy): ");
        String mesEano = sc.next();
        int mes = Integer.parseInt(mesEano.substring(0,2));
        int ano = Integer.parseInt(mesEano.substring(3));

        System.out.println("Nome: "+ trabalhador.getNome());
        System.out.println("Departamento: "+ trabalhador.getDepartamento());
        System.out.println("Recebimento na data "+ mesEano +": R$"+ String.format("%.2f", trabalhador.recebimento(ano, mes)));
    }
}
