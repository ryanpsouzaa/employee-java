package application;
import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.*;

public class Empregado {
    public static void main(String[]args){
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int contador = resp.nextInt();
        List<Employee> listaEmpregados = new ArrayList<>();

        for (int k = 1; k <= contador; k++){
            System.out.printf("Employee #%d data: \n", k);
            System.out.print("Outsourced (y/n)? ");
            char terceirizado = resp.next().charAt(0);
            resp.nextLine();

            System.out.print("Name: ");
            String nome = resp.nextLine();

            System.out.print("Hours: ");
            int horas = resp.nextInt();

            System.out.print("Value per hour: ");
            double valorPorHora = resp.nextDouble();

            if(terceirizado == 'y'){
                System.out.print("Additional charge: ");
                double despesa = resp.nextDouble();
                Employee empregado = new OutsourcedEmployee(nome,horas, valorPorHora, despesa);
                listaEmpregados.add(empregado);

            }else{
                Employee empregado = new Employee(nome,horas,valorPorHora);
                listaEmpregados.add(empregado);
            }//fim do for
        }//fim do for
        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee emp : listaEmpregados){
            System.out.print(emp.getName() + " - $" + String.format("%.2f",emp.payment()) + "\n");
        }//fim do for each

        resp.close();
    }
}
