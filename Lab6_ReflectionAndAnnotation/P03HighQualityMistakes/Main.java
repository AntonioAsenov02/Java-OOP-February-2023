package Lab6_ReflectionAndAnnotation.P03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();

         Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n",field.getName()));


        Method [] methods = clazz.getDeclaredMethods();
        Method [] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(method -> Modifier.isPrivate(method.getModifiers())).toArray(Method []::new);
        Arrays.stream(getters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n",method.getName()));

        Method [] setters =  Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .filter(method -> !Modifier.isPrivate(method.getModifiers())).toArray(Method[]::new);
        Arrays.stream(setters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n",method.getName()));
    }
}
