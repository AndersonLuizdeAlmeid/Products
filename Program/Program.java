package Program;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {
    
    public static void main(String []args) throws ParseException{

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Product> products = new ArrayList<>();
        Integer n;

        do{
            System.out.println("Enter  the number of products: ");
            n = sc.nextInt();
        }while (n <= 0);

        for(Integer i = 1; i <= n; i++ ){
            System.out.println("Product #" + i +":");
            sc.nextLine();
            System.out.print("Common, used or imported (c/u/i)?");
            String type = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            String c = "c";
            String u = "u";
            String l_i = "i";
            if (type.toLowerCase().equals(c)){
                Product product = new Product(name, price);
                products.add(product);
            } else if (type.toLowerCase().equals(u)){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.next();
                LocalDate dateFormated = LocalDate.parse(date, sdf); 
                Product product = new UsedProduct(name, price, dateFormated);
                products.add(product);
            } else if (type.toLowerCase().equals(l_i)){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFee);
                products.add(product);
            }
        }

        System.out.println("PRICE TAGS:");

        for (Product product : products) {
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}