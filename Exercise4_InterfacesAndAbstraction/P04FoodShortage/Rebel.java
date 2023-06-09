package Exercise4_InterfacesAndAbstraction.P04FoodShortage;

public class Rebel implements Person,Buyer{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        setFood(getFood() + 5);
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
