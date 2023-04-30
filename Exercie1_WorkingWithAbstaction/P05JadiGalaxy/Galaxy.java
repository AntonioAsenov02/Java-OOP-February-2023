package Exercie1_WorkingWithAbstaction.P05JadiGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public int moveJedi(int jediRows, int jediCols) {
        int starsCollected = 0;
        while (jediRows >= 0 && jediCols < field.getColLength()) {
            if (field.isINBounds(jediCols,jediRows)){
                starsCollected += field.getValue(jediRows,jediCols);
            }
            jediCols++;
            jediRows--;
        }
        return starsCollected;
    }

    public void moveEvil(int evilRows, int evilCols) {
        while (evilRows >= 0 && evilCols >= 0) {
            if (field.isINBounds(evilRows,evilCols)){
                field.setValue(evilRows,evilCols,0);
            }
            evilRows--;
            evilCols--;
        }
    }
}
