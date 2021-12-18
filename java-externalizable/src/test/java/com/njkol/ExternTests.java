package com.njkol;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.njkol.exter.Country;
import com.njkol.exter.Region;

public class ExternTests {

	@Test
	public void whenSerializing_thenUseExternalizable() throws IOException, ClassNotFoundException {

		String OUTPUT_FILE = "country.ser";
		Country c = new Country();
		c.setCode(374);
		c.setName("Armenia");

		FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		c.writeExternal(objectOutputStream);

		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream(OUTPUT_FILE);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		Country c2 = new Country();
		c2.readExternal(objectInputStream);

		objectInputStream.close();
		fileInputStream.close();

		assertTrue(c2.getCode() == c.getCode());
		assertTrue(c2.getName().equals(c.getName()));
		
		System.out.println(c2);
	}
	
	@Test
	public void showExternizaionWithInheritance() throws IOException, ClassNotFoundException {

		String OUTPUT_FILE = "region.ser";
		
		Region r = new Region();
		r.setCode(374);
		r.setName("Armenia");
		r.setClimate("Mediterranean");
		r.setPopulation(120.000);

		FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		r.writeExternal(objectOutputStream);

		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream(OUTPUT_FILE);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		Region r2 = new Region();
        r2.readExternal(objectInputStream);

		objectInputStream.close();
		fileInputStream.close();

		assertTrue(r2.getCode() == r.getCode());
		assertTrue(r2.getName().equals(r.getName()));
		assertTrue(r2.getClimate().equals(r.getClimate()));
		assertNull(r2.getPopulation());
		
		System.out.println(r2);
	}
}