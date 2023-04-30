package Exercise2_Encapsulation.P03ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] peopleArr = scanner.nextLine().split(";");
        String[] productsArr = scanner.nextLine().split(";");

        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();
        for (String personString : peopleArr) {
            String[] personData = personString.split("=");
            String personName = personData[0];
            double money = Double.parseDouble(personData[1]);


            try {
                Person person = new Person(personName, money);
                personMap.put(personName, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        for (String productString : productsArr) {
            String[] productData = productString.split("=");
            String productName = productData[0];
            double cost = Double.parseDouble(productData[1]);


            try {
                Product product = new Product(productName, cost);
                productMap.put(productName, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] inputArr = input.split("\\s+");

            String personName = inputArr[0];
            String productName = inputArr[1];

            Person buyer = personMap.get(personName);
            Product product = productMap.get(productName);

            try {
                buyer.buyProduct(product);
                System.out.printf("%s bought %s%n", buyer.getName(), product.getName());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }

        personMap.values().forEach(System.out::println);
    }
}