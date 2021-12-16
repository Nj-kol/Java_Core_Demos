package com.njkol.serialization;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SubClassAlter extends SuperClass implements Serializable {

	private static final long serialVersionUID = -1322322139926390328L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubClass{id=" + getId() + ",value=" + getValue() + ",name=" + getName() + "}";
	}

	private void readObjectNoData() throws ObjectStreamException {
		setId(34);
		setValue("rere");
	}
}
