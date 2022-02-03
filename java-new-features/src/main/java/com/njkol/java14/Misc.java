package com.njkol.java14;

import java.io.IOException;

public class Misc {

	public void textBlocks() {
		
		String obj = "Hey";
		
		// Before
		if (obj instanceof String) {
		    String str = (String) obj;
		    int len = str.length();
		    // ...
		}
		
		// Now
		if (obj instanceof String str) {
		    int len = str.length();
		    // ...
		}


	}

	public void switchExpression(int me) throws IOException {

		String sport = "Football";
		String bestPlayer = switch (sport) {
		case "Football" -> {
			System.out.println("Switch Case for Football");
			yield "XXX";
		}
		case "Tennis" -> "YYY";
		case "Cricket" -> "ZZZ";
		case "F1" -> "AAA";
		default -> "Unknown";
		};

		System.out.println(bestPlayer);
	}
}
