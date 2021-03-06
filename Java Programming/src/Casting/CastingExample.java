package Casting;

public class CastingExample 
{
	int[] arraynums = {0,1,2,3};
	public static void main(String...strings) 
	{
		//virtual method invocation
		//java always looks for the lowest class with virtual invocation
		Dog d = new Dog("red");
		Animal a = (Animal)d;
		a.speak();
		//you cant change an objects type once its in the heap
		//this will still call the dog speak method even if we cast it
		((Animal)d).speak();
	}
	
	
}

class Animal extends java.lang.Object
{
	//always always provide a no argument constructor even if you have constructors that take in data
	public Animal()
	{
		System.out.println("something");
	}
	public void speak() 
	{
		System.out.println("make a sound");
	}
	
}

class Dog extends Animal
{
	private String name;
	
	public Dog(String name)
	{
		//even though we cant see it 
		//super() is always being called first because it inherits from animal
		this.name = name;
	}
	
	public void speak()
	{
		System.out.println("Im a dog");
	}
	
	public void speakAnimal() 
	{
		//super always references the parent class method and variables
		super.speak();
	}

}