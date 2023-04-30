package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double ENERGY_UNITS = 60;
    private static final int ENERGY_DECREASE = 7;
    public NaturalExplorer(String name) {
        super(name,ENERGY_UNITS);
    }
    @Override
    public void search() {
        if (this.getEnergy() - ENERGY_DECREASE < 0){
            this.setEnergy(0);
        }else {
            this.setEnergy(this.getEnergy() - ENERGY_DECREASE);
        }
    }
}
