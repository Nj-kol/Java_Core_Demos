package com.njkol.exter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Region extends Country implements Externalizable {

	private static final long serialVersionUID = 1L;

	private String climate;
	private Double population;

	// getters, setters
	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public Double getPopulation() {
		return population;
	}

	public void setPopulation(Double population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Region [climate=" + climate + ", population=" + population + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		//save/restore the parent class fields
		super.writeExternal(out);
		out.writeUTF(climate);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		//save/restore the parent class fields
		super.readExternal(in);
		this.climate = in.readUTF();
	}
}