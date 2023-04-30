package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {

    @Test
    public void testCreateHeroRepository() {
        HeroRepository heroRepository = new HeroRepository();

        Assert.assertEquals(0,heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroInvalidNameThrowsEx() {
        HeroRepository heroRepository = new HeroRepository();

        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroHeroAlreadyExistsThrowsEx() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);

        heroRepository.create(hero1);
        heroRepository.create(hero1);
    }

    @Test
    public void testCreateHeroCorrectly() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);
        Hero hero2 = new Hero("Hero2",80);

        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Assert.assertEquals(2,heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroInvalidNameThrowsEx() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);

        heroRepository.create(hero1);

        heroRepository.remove("      ");
    }

    @Test
    public void testRemoveHeroCorrectly() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);
        Hero hero2 = new Hero("Hero2",80);

        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Assert.assertTrue(heroRepository.remove("Hero1"));
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);
        Hero hero2 = new Hero("Hero2",80);

        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Assert.assertEquals(hero2,heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroByName() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);
        Hero hero2 = new Hero("Hero2",80);

        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Assert.assertEquals("Hero2",heroRepository.getHero("Hero2").getName());
    }

    @Test
    public void testGetHeroes() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Hero1",50);
        Hero hero2 = new Hero("Hero2",80);

        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Assert.assertEquals(2,heroRepository.getHeroes().size());
    }
}
