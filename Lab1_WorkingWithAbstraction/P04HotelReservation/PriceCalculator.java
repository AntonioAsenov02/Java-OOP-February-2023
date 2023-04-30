package Lab1_WorkingWithAbstraction.P04HotelReservation;

public class PriceCalculator {

    public static double calculateHolidayPrice(double pricePerDay,int days,Season season,DiscountType discountType){

        double priceForAllDays = pricePerDay * days;
        priceForAllDays *= season.getDiscountCoefficient();

        priceForAllDays = priceForAllDays - priceForAllDays * (discountType.getPercent() / 100);

        return priceForAllDays;
    }
}
