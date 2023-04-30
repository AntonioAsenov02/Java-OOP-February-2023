package petStore;

import org.junit.Assert;
import org.junit.Test;

public class PetStoreTests {

    @Test
    public void testCreatePetStore() {
        PetStore petStore = new PetStore();

        Assert.assertEquals(0,petStore.getCount());
        Assert.assertEquals(0,petStore.getAnimals().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalNullThrowsEx() {
        PetStore petStore = new PetStore();

        Animal animal1 = null;
        petStore.addAnimal(animal1);
    }

    @Test
    public void testAddAnimalCorrectly() {
        PetStore petStore = new PetStore();

        Animal animal1 = new Animal("Dog1",10,100);
        Animal animal2 = new Animal("Dog2",20,200);
        Animal animal3 = new Animal("Dog3",30,300);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        Assert.assertEquals(2,petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKG() {
        PetStore petStore = new PetStore();

        Animal animal1 = new Animal("Dog1",10,100);
        Animal animal2 = new Animal("Dog2",20,200);
        Animal animal3 = new Animal("Dog3",30,300);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(2,petStore.findAllAnimalsWithMaxKilograms(19).size());
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        PetStore petStore = new PetStore();

        Animal animal1 = new Animal("Dog1",10,100);
        Animal animal2 = new Animal("Dog2",20,200);
        Animal animal3 = new Animal("Dog3",30,300);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        animal3.setAge(10);

        Assert.assertEquals("Dog3",petStore.getTheMostExpensiveAnimal().getSpecie());
        Assert.assertEquals(30,petStore.getTheMostExpensiveAnimal().getMaxKilograms());
        Assert.assertEquals(300,petStore.getTheMostExpensiveAnimal().getPrice(),0.01);
        Assert.assertEquals(10,petStore.getTheMostExpensiveAnimal().getAge());
    }

    @Test
    public void testFindAllAnimalFromSpecie() {
        PetStore petStore = new PetStore();

        Animal animal1 = new Animal("Dog",10,100);
        Animal animal2 = new Animal("Dog",20,200);
        Animal animal3 = new Animal("Dog3",30,300);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(2,petStore.findAllAnimalBySpecie("Dog").size());
    }
 }

