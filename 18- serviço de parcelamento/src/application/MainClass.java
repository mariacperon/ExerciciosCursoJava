package application;

import entities.Contrato;
import entities.Parcela;
import services.PayPalService;
import services.ServicoContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("DIGITE OS DADOS DO CONTRATO:");
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        Date data = sdf.parse(sc.nextLine());
        System.out.print("Valor do contrato: R$");
        double valor = sc.nextDouble();
        System.out.print("Número de parcelas: ");
        int n = sc.nextInt();
        Contrato contrato = new Contrato(numero, data, valor);

        ServicoContrato servicoContrato = new ServicoContrato(new PayPalService());

        servicoContrato.processarContrato(contrato, n);

        for (Parcela parcela : contrato.getParcelas()){
            System.out.println(parcela);
        }


    }

}
