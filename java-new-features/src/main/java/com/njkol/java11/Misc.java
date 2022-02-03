package com.njkol.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Misc {

	public void newStringMethods() {

		System.out.println(" ".isBlank()); // true
		String s = "Anupam";
		System.out.println(s.isBlank()); // false
		String s1 = "";
		System.out.println(s1.isBlank()); // true

		String str = "JD\nJD\nJD";
		System.out.println(str);
		// This method returns a stream of strings, which is a collection of all
		// substrings split by lines.
		System.out.println(str.lines().collect(Collectors.toList()));

		String strStrip = " JD ";
		System.out.print("Start");
		System.out.print(strStrip.strip());
		System.out.println("End");

		System.out.print("Start");
		System.out.print(strStrip.stripLeading());
		System.out.println("End");

		System.out.print("Start");
		System.out.print(strStrip.stripTrailing());
		System.out.println("End");

		String strRepeat = "=".repeat(2);
		System.out.println(strRepeat); // prints ==
	}

	public void newFileMethods() throws IOException {

		Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
		System.out.println(path);
		String s = Files.readString(path);
		System.out.println(s); //This was posted on JD
	}
}
