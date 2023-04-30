package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    protected void setPower(int power) {
        if (power < 0){
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public void use() {
        this.power = Math.max(power - 10,0);
    }

    @Override
    public boolean isBroken() {
        return power == 0;
    }
}
