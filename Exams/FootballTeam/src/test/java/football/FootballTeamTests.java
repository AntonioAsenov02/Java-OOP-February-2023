package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFootballTeamInvalidPositionThrowsEx() {
        FootballTeam team1 = new FootballTeam("Team1",-2);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFootballTeamInvalidNaeThrowsEx() {
        FootballTeam team1 = new FootballTeam("      ",4);
    }

    @Test
    public void testCreateFootballTeamCorrectly() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Assert.assertEquals(0,team1.getCount());
        Assert.assertEquals(5,team1.getVacantPositions());
        Assert.assertEquals("Team1",team1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerOutOfCapacityThrowsEx() {
        FootballTeam team1 = new FootballTeam("Team1",1);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);
    }

    @Test
    public void testAddPlayerCorrectly() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);

        Assert.assertEquals(2,team1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerNotExistThrowsEx() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);

        team1.removeFootballer("John");
    }

    @Test
    public void testRemovePlayerExist() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);

        team1.removeFootballer("Antonio");

        Assert.assertEquals(1,team1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleThrowsEx() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);

        team1.footballerForSale("John");
    }

    @Test
    public void testFootballerCorrectly() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);

        team1.footballerForSale("Antonio");
        Assert.assertFalse(footballer2.isActive());
    }

    @Test
    public void testGetStatistics() {
        FootballTeam team1 = new FootballTeam("Team1",5);

        Footballer footballer1 = new Footballer("Atanas");
        Footballer footballer2 = new Footballer("Antonio");

        team1.addFootballer(footballer1);
        team1.addFootballer(footballer2);

        Assert.assertEquals("The footballer Atanas, Antonio is in the team Team1.", team1.getStatistics());
    }
}
