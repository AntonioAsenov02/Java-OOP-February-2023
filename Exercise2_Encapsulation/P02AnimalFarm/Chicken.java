package Exercise2_Encapsulation.P02AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name == null || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay(){
      return calculateProductPerDay();
    }
    @Override
    public String toString(){
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",getName(),getAge(),productPerDay());
    }

    private double calculateProductPerDay(){
        if (getAge() > 0 && getAge() <= 5){
            return 2;
        }else if (getAge() > 5 && getAge() <= 11){
            return 1;
        }else {
            return 0.75;
        }
    }
}
