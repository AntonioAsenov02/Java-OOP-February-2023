package Exercise6_ReflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Class clazz = RichSoilLand.class;

		Field[] fields = clazz.getDeclaredFields();
		String command = scanner.nextLine();
		while (!command.equals("HARVEST")){

			if (command.equals("private")){
				Arrays.stream(fields)
						.filter(field -> Modifier.isPrivate(field.getModifiers()))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
			}else if (command.equals("protected")){
				Arrays.stream(fields)
						.filter(field -> Modifier.isProtected(field.getModifiers()))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
			}else if (command.equals("public")){
				Arrays.stream(fields)
						.filter(field -> Modifier.isPublic(field.getModifiers()))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
			}else if (command.equals("all")){
				Arrays.stream(fields)
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
			}

			command = scanner.nextLine();
		}
	}
}
