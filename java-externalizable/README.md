
# Java Externizable

* To do customs serialization, you have to implement the **java.io.Externalizable** interface. It consist of two methods which we have to override to write/read object into/from stream which are :

  1. void readExternal(ObjectInput in) 
  2. void writeExternal(ObjectOutput out) 

* We just need to implement the read/write methods for every super-class of the inheritance hierarchy

* It’s mandatory to read all the field states ***in the exact order as they were written***, otherwise, we’ll get an exception
  
Reference
=========
https://www.baeldung.com/java-externalizable