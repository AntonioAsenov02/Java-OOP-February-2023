package Exercise6_ReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String command = scanner.nextLine();

        while (!command.equals("END")){

            String [] commandArr = command.split("_");

            String method = commandArr[0];
            int number = Integer.parseInt(commandArr[1]);

            switch (method){
                case "add" :
                case "rightShift" :
                case "leftShift" :
                case "multiply" :
                case "divide" :
                case "subtract" :
                    executeCommand(clazz, blackBoxInt, innerValue, number, method);
                    break;
            }
            command = scanner.nextLine();
        }
    }
    private static void executeCommand(Class<BlackBoxInt> clazz, BlackBoxInt blackBoxInt, Field innerValue, int number,String command) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = clazz.getDeclaredMethod(command,int.class);
        method.setAccessible(true);
        method.invoke(blackBoxInt, number);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
