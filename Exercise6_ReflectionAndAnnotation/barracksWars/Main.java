package Exercise6_ReflectionAndAnnotation.barracksWars;

import Exercise6_ReflectionAndAnnotation.barracksWars.interfaces.Repository;
import Exercise6_ReflectionAndAnnotation.barracksWars.interfaces.Runnable;
import Exercise6_ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;
import Exercise6_ReflectionAndAnnotation.barracksWars.core.Engine;
import Exercise6_ReflectionAndAnnotation.barracksWars.core.factories.UnitFactoryImpl;
import Exercise6_ReflectionAndAnnotation.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
