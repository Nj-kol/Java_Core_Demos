package com.njkol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CloneUsingSerialization implements Cloneable, Serializable {

	int num;
	Thing thing;

	public CloneUsingSerialization clone() {
		try {
			return (CloneUsingSerialization) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Deep copy using serialization
	 */
	public CloneUsingSerialization deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (CloneUsingSerialization) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Thing getThing() {
		return thing;
	}

	public void setThing(Thing thing) {
		this.thing = thing;
	}

	public String toString() {
		return "num:" + num + ", thing:" + thing;
	}
}