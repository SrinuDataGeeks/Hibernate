class Parent
	{
private String location = "Hyderabad";

public Parent()
{
System.out.println(" Parent Object is created : ");
}

public void printLocation()
{
System.out.println(" Location is : "+location);
}
	}

class Child extends Parent
	{
public Child()
{
super();
System.out.println(" Child Object is created : ");
}
	}

public class ProxyObservation
	{
public static void main(String args[])
{
Child c = new Child();

c.printLocation();
}
	}