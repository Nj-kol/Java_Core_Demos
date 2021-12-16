
package com.njkol;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Animal {
	
}

class Dog extends Animal {
	
}

class Altitian extends Dog {
	
}

/**
 * @author s752349
 *
 */
public class GenericsDemos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Dog> listA = new ArrayList<Dog>();
		List<Altitian> listB = new ArrayList<Altitian>();
		
		//listA = listB;
		//listB = listA;
		
		List<? extends Animal> la = null;
		
		List<? super Animal> laq = null;
		
		
	}

	// Consumer Super-  You can add to super
	public static void insertElements(List<? super Animal> list){
	    list.add(new  Animal());
	    list.add(new Dog());
	    list.add(new Altitian());
	    SoftReference<StringBuilder> reference = new SoftReference<StringBuilder>(new StringBuilder());
	}
	
	
	
	// generic method which accepts a generic parameter and  return generic type
	public static <T> T addAndReturn(T element, Collection<T> collection){
	    collection.add(element);
	    return element;
	}
	
	
}
