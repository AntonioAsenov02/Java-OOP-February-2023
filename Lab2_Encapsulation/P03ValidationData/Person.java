package Lab2_Encapsulation.P03ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(this.firstName = firstName);
        setLastName(this.lastName = lastName);
        setAge(this.age = age);
        setSalary(this.salary = salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double bonus){

        if(this.age >= 30){
            double currentSalary = getSalary();

            double newSalary = currentSalary + (currentSalary * (bonus / 100));
            setSalary(newSalary);
        }else {
            double currentSalary = getSalary();

            double newSalary = currentSalary + (currentSalary * (bonus / 2 / 100));
            setSalary(newSalary);
        }
    }
    @Override
    public String toString(){
        return String.format("%s %s gets %.1f leva",this.firstName,this.lastName,this.salary);
    }
}
