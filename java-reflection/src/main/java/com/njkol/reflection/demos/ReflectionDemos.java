package com.njkol.reflection.demos;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemos {

	private static String className = "com.njkol.reflection.demos.Employee";

	public static void main(String... args) throws Exception {

		// instantiateClass(className);
		// populateFields(className);
		printGettersSetters(className);
	}

	public static void instantiateClass(String className) throws Exception {

		Class<?> cls;
		try {
			cls = Class.forName(className);
			Object obj = cls.newInstance();
			ClassLoader d = cls.getClassLoader();
			System.out.println("The ClassLoader is : " + d);

			if (obj instanceof Employee) {
				Employee e = (Employee) obj;
				System.out.println(e.toString());
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException e1) {
			throw new Exception(e1);
		}
	}

	public static void populateFields(String className) throws Exception {

		Class<?> cls;
		try {
			cls = Class.forName(className);
			Object obj = cls.newInstance();
			Employee e = (Employee) obj;

			// Populate a private field
			Field field = cls.getDeclaredField("name");
			field.setAccessible(true);
			field.set(e, "Nilanjan Sarkar");

			// Populate a static field
			Field staticField = cls.getField("company");
			staticField.set(null, "Emirates");

			System.out.println(e.toString());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException
				| SecurityException e1) {
			throw new Exception(e1);
		}
	}

	/**
	 * Inspects the getter and setter methods of a Class
	 * 
	 * @param className
	 * @throws Exception
	 */
	public static void printGettersSetters(String className) throws Exception {

		Class<?> aClass;
		try {
			aClass = Class.forName(className);
			Method[] methods = aClass.getMethods();

			for (Method method : methods) {
				if (isGetter(method))
					System.out.println("getter: " + method);
				if (isSetter(method))
					System.out.println("setter: " + method);
			}
		} catch (ClassNotFoundException | SecurityException e1) {
			throw new Exception(e1);
		}
	}

	/**
	 * Checks whether the method is a getter method
	 * 
	 * @param method
	 * @return
	 */
	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;
	}

	/**
	 * Checks whether the method is a setter method
	 * 
	 * @param method
	 * @return
	 */
	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}
}