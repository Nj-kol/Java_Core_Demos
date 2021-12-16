package com.njkol;

import java.io.IOException;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.njkol.serialization.*;
import com.njkol.serialization.SubClass;
import com.njkol.serialization.inheritance.*;
import com.njkol.serialization.utils.SerializationUtils;

public class SerializationTest {

	private static void testBasicSerDe() {

		String fileName = "employee.ser";

		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Pankaj");
		emp.setSalary(5000);

		// serialize to file
		try {
			SerializationUtils.serialize(emp, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Employee empNew = null;
		try {
			empNew = (Employee) SerializationUtils.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("emp Object::" + emp);
		System.out.println("empNew Object::" + empNew);
	}

	private static void testSerializationWithInheritance() {

		String fileName = "subclass.ser";

		SubClass subClass = new SubClass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Pankaj");

		try {
			SerializationUtils.serialize(subClass, fileName);
			System.out.println("SubClass Object serialized successfully !");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			SubClass subNew = (SubClass) SerializationUtils.deserialize(fileName);
			System.out.println("SubClass read = " + subNew);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void testExSer() {

		String fileName = "subclassAlter.ser";

		SubClassAlter subClass = new SubClassAlter();
		subClass.setName("Nilanjan");

		try {
			SerializationUtils.serialize(subClass, fileName);
			System.out.println("SubClassAlter Object serialized successfully !");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	private static void testExDeSer() {

		String fileName = "subclassAlter.ser";
		try {
			SubClassAlter subNew = (SubClassAlter) SerializationUtils.deserialize(fileName);
			System.out.println("SubClassAlter read = " + subNew);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	// If a superclass is not serializable then subclass can still be serialized
	@Test
	@Ignore
	public void testSuperCaseOne() throws IOException, ClassNotFoundException {

		SubclassB b1 = new SubclassB(10, 20);

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		// Serializing B's(subclass) object

		// Saving of object in a file
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Method for serialization of B's class object
		oos.writeObject(b1);

		// closing streams
		oos.close();
		fos.close();

		System.out.println("Object has been serialized");

		// De-Serializing B's(subclass) object

		// Reading the object from a file
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Method for de-serialization of B's class object
		SubclassB b2 = (SubclassB) ois.readObject();

		// closing streams
		ois.close();
		fis.close();

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);
	}
	
	// Superclass is serializable but we don’t want the subclass to be serialized
	@Test(expected = NotSerializableException.class)
	public void testSuperCaseTwo() throws IOException, ClassNotFoundException {
		
		SubclassBNoSerDe b1 = new SubclassBNoSerDe(10, 20); 
        
        System.out.println("i = " + b1.i); 
        System.out.println("j = " + b1.j); 
          
        // Serializing B's(subclass) object  
          
        //Saving of object in a file 
        FileOutputStream fos = new FileOutputStream("abc.ser"); 
        ObjectOutputStream oos = new ObjectOutputStream(fos); 
              
        // Method for serialization of B's class object 
        oos.writeObject(b1); 
              
        // closing streams 
        oos.close(); 
        fos.close(); 
              
        System.out.println("Object has been serialized"); 
          
        // De-Serializing B's(subclass) object  
          
        // Reading the object from a file 
        FileInputStream fis = new FileInputStream("abc.ser"); 
        ObjectInputStream ois = new ObjectInputStream(fis); 
              
        // Method for de-serialization of B's class object 
        SubclassBNoSerDe b2 = (SubclassBNoSerDe)ois.readObject(); 
              
        // closing streams 
        ois.close(); 
        fis.close(); 
              
        System.out.println("Object has been deserialized"); 
          
        System.out.println("i = " + b2.i); 
        System.out.println("j = " + b2.j); 
	}
}