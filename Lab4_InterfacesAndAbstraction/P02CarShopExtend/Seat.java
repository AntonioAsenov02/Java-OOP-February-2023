package Lab4_InterfacesAndAbstraction.P02CarShopExtend;

public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model,color,horsePower,countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("%s sells for %f",getModel(),price));

        return builder.toString();
    }


}
