package com.njkol.java13;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import java.util.Arrays;
import java.util.List;

enum Fruit {
	PEAR, APPLE, ORANGE, MANGO, GRAPE, PAPAYA;
}

public class Misc {

	public void textBlocks() {

		String textBlock = """
				Hi
				Hello
				Yes""";

		String textBlockHTML = """
				<html>
				<head>
					<link href='/css/style.css' rel='stylesheet' />
				</head>
				<body>
				                      <h1>Hello World</h1>
				              </body>
				              </html>""";

		String textBlockJSON = """
				{
					"name":"Pankaj",
					"website":"JournalDev"
				}""";

	}

	public void newStringMethods() {

		String output = """
				Name: %s
				Phone: %d
				Salary: $%.2f
				""".formatted("Pankaj", 123456789, 2000.5555);

		String htmlTextBlock = "<html>   \n" + "\t<body>\t\t \n" + "\t\t<p>Hello</p>  \t \n" + "\t</body> \n"
				+ "</html>";

		System.out.println(htmlTextBlock.replace(" ", "*"));
		System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));

		String str1 = "Hi\t\nHello' \" /u0022 Pankaj\r";
		System.out.println(str1);
		System.out.println(str1.translateEscapes());
	}

	public void newYieldKeyword(int me) throws IOException {

		var operation = "squareMe";
		var result = switch (operation) {
		case "doubleMe" -> {
			yield me * 2;
		}
		case "squareMe" -> {
			yield me * me;
		}
		default -> me;
		};
	}
}
