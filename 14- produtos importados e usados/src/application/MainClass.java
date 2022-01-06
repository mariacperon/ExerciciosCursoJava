package application;

import model.ImportedProduct;
import model.Product;
import model.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Number of products: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            sc.nextLine();
            System.out.println("PRODUCT #"+ (i+1) +" DATA:");
            System.out.print("Common, used or imported? (c/u/i) ");
            Character resp = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: R$");
            double price = sc.nextDouble();
            sc.nextLine();
            if(resp == 'u'){
                System.out.print("Manufacture date: ");
                String manufacturedDate = sc.nextLine();
                products.add(new UsedProduct(name, price, sdf.parse(manufacturedDate)));
            }else if(resp == 'i'){
                System.out.print("Customs fee: R$");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }else{
                products.add(new Product(name, price));
            }
        }

        System.out.println("PRICE TAGS:");
        for(Product product : products){
            System.out.println(product.priceTag());
        }

    }
}
