package Exercise6_ReflectionAndAnnotation.barracksWars.core.factories;

import Exercise6_ReflectionAndAnnotation.barracksWars.interfaces.Unit;
import Exercise6_ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"Exercise6_ReflectionAndAnnotation.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = clazz.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
				 IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
