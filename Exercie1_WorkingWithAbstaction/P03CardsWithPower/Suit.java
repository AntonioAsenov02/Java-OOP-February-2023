package Exercie1_WorkingWithAbstaction.P03CardsWithPower;

public enum Suit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private int suitPower;

    Suit(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }

    public void setSuitPower(int suitPower) {
        this.suitPower = suitPower;
    }
}
