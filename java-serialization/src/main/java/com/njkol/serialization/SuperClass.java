package com.njkol.serialization;

import java.io.ObjectStreamException;

public class SuperClass {

	private int id;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	
	
	private void readObjectNoData() throws ObjectStreamException {
		setId(34);
		setValue("rere");
	}
}