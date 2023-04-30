package Lab3_Inheritance.P03RandomArrayList;

public class Main {

    public static void main(String[] args) {

        RandomArrayList<Integer> list = new RandomArrayList<>();

        list.add(10);
        list.add(100);
        list.add(1000000);
        list.add(5005);

        System.out.println(list.getRandomElement());
    }
}
