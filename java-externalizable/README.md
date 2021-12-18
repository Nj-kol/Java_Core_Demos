
# Java Externizable

* To do customs serialization, you have to implement the **java.io.Externalizable** interface. It consist of two methods which we have to override to write/read object into/from stream which are :

  1. void readExternal(ObjectInput in) 
  2. void writeExternal(ObjectOutput out) 

* We just need to implement the read/write methods for every super-class of the inheritance hierarchy

* It’s mandatory to read all the field states ***in the exact order as they were written***, otherwise, we’ll get an exception

# Key differences between Serializable and Externalizable

## Implementation 

* Unlike Serializable interface which will serialize  the variables in object with just by implementing interface, here we have to explicitly mention whatfields or variables you want to serialize

## Methods 

* Serializable is marker interface without any methods. 
* Externalizable interface contains two methods: writeExternal() and readExternal()

## Process

* Default Serialization process will take place for classes implementing Serializable interface.
* Programmer defined Serialization process for classes implementing Externalizable interface

## Backward Compatibility and Control

* If you have to support multiple versions, you can have full control with Externalizable interface.
* You can support different versions of your object. 
* If you implement Externalizable, it’s your responsibilityto serialize super class

## public No-arg constructor

* Serializable uses reflection to construct object and does not require no arg constructor
* But Externalizable requires public no-arg constructor.
* When an object implements Serializable interface,is serialized or deserialized the constructor of object not is called and hence **any initialization which is implemented in constructor can’t be done**

## Performance

* The java.io.Serializable interface uses reflection and metadata which causes relatively slow performance
* By comparison, the Externalizable interface gives you full control over the serialization process.

## Reading Order

* While using Externalizable, it’s mandatory to readall the field states in the exact order as they were  written. Otherwise, a java.io.EOFException will be thrown
* Meanwhile, the Serializable interface doesn’t have that requirement.

## Use Case

* If we need to serialize the entire object, the Serializable interface is a better fit.
* On the other hand, for custom serialization,we can control the process using Externalizable.

References
==========
https://www.geeksforgeeks.org/externalizable-interface-java
https://www.baeldung.com/java-externalizable