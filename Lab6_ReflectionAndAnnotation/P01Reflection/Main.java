package Lab6_ReflectionAndAnnotation.P01Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass().toString());
        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Constructor reflectionConstructor = clazz.getDeclaredConstructor();

        Reflection reflection = (Reflection) reflectionConstructor.newInstance();
        System.out.println(reflection);
    }
}