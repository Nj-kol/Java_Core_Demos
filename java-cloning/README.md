# Cloning

* A clone is an object copy 
* The the Object class has a *clone()* method which  is used to create a clone of the object
* However, to use java object clone() method, we have to implement the marker interface **java.lang.Cloneable** so that it won’t throw **CloneNotSupportedException** at runtime

* Classes designed for inheritance should not implement cloneable

#### Shallow Copy

* Shallow clone is “default implementation” in Java It creates a new instance of the same class and copies all the fields to the new instance and returns it
* A shallow copy of an object copies the ‘main’ object, but doesn’t copy the inner objects. The ‘inner objects’ are shared between the original object and its copy.

#### Deep Copy

In deep cloning, we have to copy fields one by one, We can override the clone method like below for deep cloning

## Case for inheritance

* If you override the clone method in a non final class,  you should return an object obtained by invoking super.clone()
* If all of a class's super classes obey this rule, then super.clone will eventually invoke Object's clone method, creating an instance of the right class
* Classes designed for inheritance should not implement *Cloneable*

## Cloning using Serialization

* A simple way of performing a deep clone is for all of the classes that make up a class to implement the  Serializable interface.

## Copy Constructor

* We can also define a copy constructor and get a copy of the object and don’t depend on the cloning at all
* Copy Constructor is a special type of constructor that takes the same class as argument. Copy constructor is used to provide a copy of the specified object
* However writing copy constructor can be a tedious job if your class has a lot of variables, especially primitive and immutables
