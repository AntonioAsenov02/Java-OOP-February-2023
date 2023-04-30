package Lab4_InterfacesAndAbstraction.P01CarShop;

import java.io.Serializable;

public interface Car extends Serializable {

    int Tires = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
