package Exercise4_InterfacesAndAbstraction.P04FoodShortage;


public class Citizen implements Person,Identifiable,Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        setFood(getFood() + 10);
    }

    @Override
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
