package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Number of employees: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            sc.nextLine();
            System.out.println("EMPLOYEE #"+ (n+1) +" DATA:");
            System.out.print("Outsourced? (y/n) ");
            Character resp = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hour: ");
            int hour = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if(resp == 'y'){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                Employee outsourced = new OutsourcedEmployee(name, hour, valuePerHour, additionalCharge);
                employees.add(outsourced);
            }else{
                Employee employee = new Employee(name, hour, valuePerHour);
                employees.add(employee);
            }

        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() +" - R$"+ employee.payment());
        }

    }

}
