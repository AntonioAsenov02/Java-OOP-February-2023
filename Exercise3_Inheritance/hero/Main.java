package Exercise3_Inheritance.hero;

public class Main {

    public static void main(String[] args) {

        Hero hero = new Hero("SuperMan",100);
        Elf elf = new Elf("Elf",22);
        Hero hero1 = new Knight("The Knight",12);

        System.out.println(hero);
        System.out.println(hero1);
        System.out.println(elf);
    }
}
