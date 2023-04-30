package Lab4_InterfacesAndAbstraction.P02CarShopExtend;

import java.io.Serializable;

public interface Car extends Serializable {

    int Tires = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
