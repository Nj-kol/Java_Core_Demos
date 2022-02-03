package com.njkol.java12;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import java.util.Arrays;
import java.util.List;

enum Fruit {
	PEAR, APPLE, ORANGE, MANGO, GRAPE, PAPAYA;
}

public class Misc {

	public void newStringMethods() {

		String str = "*****\n  Hi\n  \tHello Pankaj\rHow are you?\n*****";

		System.out.println(str.indent(0));
		System.out.println(str.indent(3));
		System.out.println(str.indent(-3));

		String s = "Hi,Hello,Howdy";
		List<String> strList = s.transform(s1 -> {
			return Arrays.asList(s1.split(","));
		});

		System.out.println(strList);
	}

	public void newFileMethods(String day) throws IOException {

		Fruit fruit = Fruit.PEAR;
		
		int numberOfLetters = switch (fruit) {
		case PEAR -> 4;
		case APPLE, MANGO, GRAPE -> 5;
		case ORANGE, PAPAYA -> 6;
		};
	}
}
