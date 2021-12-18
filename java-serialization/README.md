
# Serializable in Java

* If you want a class object to be serializable, all you need to do it implement the java.io.Serializable interface
* Serializable in java is a marker interface and has no fields or methods to implement.  It’s like an Opt-In process through which we  make our classes serializable
* Serialization in java is implemented by ObjectInputStream and ObjectOutputStream, so all we need is a wrapper over them to either save it to file or send it over the network. 
* If you want an object property to be not serialized to stream, you can use the transient keyword. 
* The access type ( public, private, protected ) does not matter
* Another way to do this is to override the writeObject method
* static variable values are also not serialized since they belongs to class and not object
* Inner classes should not implement Serializable. They use compiler generated synthetic fields to store references to enclosing instances and to store values of local variables from enclosing scope. Therefore, the serialized version form of an inner class is ill-defined.
* A static member class can, however, implement Serializable

## serialVersionUID

* Every serializable class has a unique number associated with it. These numbers are called stream unique identifiers or more commonly known as serial version UID.
* serialVersionUID  is a number of type long used  for the version control of Class. This is to ensure that the class that was used for serialization is also used for deserialization.
* If version is not used, JVM will throws java.io.InvaliadClassException
* It is always static and final
* If the class doesn’t define serialVersionUID, it gets calculated automatically and assigned to the class. * It is an expensive computation that is required to generate one at runtime. Java uses class variables, methods, class name,  package etc to generate this unique long number

## Pitfalls of Serialization

* The class structure can’t be changed a lot without breaking the java serialization process. So even  though we don’t need some variables later on,  we need to keep them just for backward compatibility
* Serialization causes huge security risks, an attacker can change the stream sequence and cause harm to the system.  For example, user role is serialized and an attacker   change the stream value to make it admin and run malicious code

# Notes

* Classes designed for inheritance should avoid implementing Serializable
* In deserialization, the JVM doesn’t use any constructor to create the object. However, during deserialization the accessible default constructor is called for the first class in the inheritance hierarchy that does not implement Serializable  So, if you have a subclass that implements Serializable but its parent does not, then when you deserialized your object, its constructors doesn't called, but default constructor of its parent will be called
* You should consider providing a parameterless constructor on non serializable classes designed for inheritance
* ***Serialization Proxy*** is a great design pattern that can be used as an alternative to the usual way.
