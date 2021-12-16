package com.njkol.serialization.inheritance;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SubclassBNoSerDe extends SuperASer {
	
	public int j;

	// parameterized constructor
	public SubclassBNoSerDe(int i, int j) {
		super(i);
		this.j = j;
	}

	// By implementing writeObject method,
	// we can prevent
	// subclass from serialization
	private void writeObject(ObjectOutputStream out) throws IOException {
		throw new NotSerializableException();
	}

	// By implementing readObject method,
	// we can prevent
	// subclass from de-serialization
	private void readObject(ObjectInputStream in) throws IOException {
		throw new NotSerializableException();
	}
}