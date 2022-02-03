package com.njkol.java16;

import jdk.incubator.vector.IntVector;

public class VectorAPIDemo {

	// traditionally multiply two arrays: This example of a scalar computation will, for an array of length 4, execute in 4 cycles. 
	public void demoVectorAPI() {
		
		int[] a = {1, 2, 3, 4};
		int[] b = {5, 6, 7, 8};

		var c = new int[a.length];

		for (int i = 0; i < a.length; i++) {
		    c[i] = a[i] * b[i];
		}
		
		// equivalent vector-based computation:
		var vectorA = IntVector.fromArray(IntVector.SPECIES_128, a, 0);
		var vectorB = IntVector.fromArray(IntVector.SPECIES_128, b, 0);
		var vectorC = vectorA.mul(vectorB);
		vectorC.intoArray(c, 0);
	}
}
