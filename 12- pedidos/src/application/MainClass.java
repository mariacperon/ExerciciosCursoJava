package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String bithDate = sc.nextLine();
        Client client = new Client(name, email, sdf.parse(bithDate));

        Date data = new Date();
        System.out.println("Enter order item:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        Order order = new Order(data, OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            sc.nextLine();
            System.out.println("Enter #"+ n+1 +" item data:");
            System.out.print("Product name: ");
            name = sc.nextLine();
            System.out.print("Price: R$");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(name, price);
            OrderItem item = new OrderItem(quantity, price, product);
            order.addItens(item);
        }

        System.out.println(order.toString());
    }
}
