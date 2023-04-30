package Lab1_WorkingWithAbstraction.P04HotelReservation;

public enum Season {
    AUTUMN("Autumn",1),
    SPRING("Spring",2),
    WINTER("Winter",3),
    SUMMER("Summer",4);
    private String season;
    private int discountCoefficient;

    Season(String season, int discountCoefficient) {
        this.season = season;
        this.discountCoefficient = discountCoefficient;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getDiscountCoefficient() {
        return discountCoefficient;
    }

    public void setDiscountCoefficient(int discountCoefficient) {
        this.discountCoefficient = discountCoefficient;
    }
}
