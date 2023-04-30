package Lab1_WorkingWithAbstraction.P04HotelReservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] inputArr = input.split("\\s+");

        double pricePerDay = Double.parseDouble(inputArr[0]);
        int numberOfDays = Integer.parseInt(inputArr[1]);
        String season = inputArr[2].toUpperCase();
        String discountType = inputArr[3].toUpperCase();

        double totalHolidayPrice = PriceCalculator.calculateHolidayPrice(pricePerDay,numberOfDays,
                Season.valueOf(season),DiscountType.valueOf(discountType));

        System.out.printf("%.2f",totalHolidayPrice);
    }
}
