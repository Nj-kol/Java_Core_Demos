# Enumerations (Enum) in Java

## Introduction

* In its simplest form, **an enumeration is a  list of named constants that define a new data type and its legal values**. Thus, an enumeration object can hold only a value that was declared in the list. Other values are not allowed. 

* Enumerations are commonly used to define a set of  values that represent a collection of items

## Java Enumerations Are Class Types

* In Java, an enumeration defines a class type. Although you don’t instantiate an enum using new,  it otherwise has much the same capabilities  as other classes
* You can do the following : 
  - Give them constructors
  - Add instance variables and methods
  - Implement interfaces

* Also, **each enumeration constant has its own copy of any instance variables** defined by the enumeration.

## Limitations

* There are two restrictions that apply to enumerations :

  1. An enumeration can’t inherit another class
  2. An enum cannot be a superclass

   This means that **an enum can’t be extended**
   
* It is important to understand that **each  enumeration constant is an object of its enumeration type**. Thus, when you define a constructor for an enum,  the constructor is called when each enumeration  constant is created

# Enum Inheritance

* Although you can’t inherit a superclass when declaring an enum, **all enumerations  automatically inherit one: java.lang.Enum**. This class defines several methods that are available for use by all enumerations

* You can obtain a value that indicates an enumeration constant’s position in the list of constants. This is called its *ordinal value*, and it  is retrieved by calling the `ordinal()` method. Ordinal values begin at zero

* You can compare the ordinal value of two constants of the same enumeration by using the `compareTo()` method.
 - If the invoking constant has an ordinal value less than the other, then itreturns a negative value. 
 - If the two ordinal values are the same, then zero is returned
 - If the invoking constant has an ordinal value greater than e’s, then a positive value is returned
 
## Enumeration Declaration

* An enumeration is created using the *enum* keyword

```java
enum Apple {
	Jonathan, GoldenDel, RedDel,Winesap,Cortland;
}
```

* The identifiers Jonathan, GoldenDel, and so on, are  called *enumeration constants*
* Each is implicitly declared as a **public, static final** member of Apple. 
* Furthermore, **their type is the type of the enumeration in which they are declared**, which is Apple in this case. 
* Thus, in the language of Java, these **constants are called self-typed**, in which “self” refers to the enclosing enumeration
* Once you have defined an enumeration, you can  create  a variable of that type. However, even though enumerations define a class type,  **you do not instantiate an enum using new**. Instead, you declare and use an enumeration variable  in much the same way as you do one of the primitive types. 

```java
Apple ap = Apple.RedDel;
```

## Usage in Switch case

* An enumeration value can also be used to control a switch statement.


```java
// Use an enum to control a switch statement.
  switch(ap) {
  case Jonathan:
  // ...
  case Winesap:
  // ...
```

Notice that in the case statements, the names  of the enumeration constants are used without being qualified by their enumeration type name. That is, `Winesap` and not `Apple.Winesap`, is used. 


## values() and valueOf()

* All enumerations automatically contain two predefined methods: `values()` and `valueOf()`
* Their general forms are shown here :

```java
public static enum-type[ ] values( )
public static enum-type valueOf(String str)
```

* The `values()` method returns an array that  contains a list of the enumeration constants.
* The `valueOf()` method returns the enumeration constant whose value corresponds to the string value passed 
* In both cases, enum-type is the type of the enumeration.  For example, in the case of the Apple enumeration   shown earlier, the return type of 

```java
// is Winesap
Apple.valueOf("Winesap") 
```
