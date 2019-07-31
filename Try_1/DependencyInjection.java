package Try_1;
/*
Let's try simple example with Car and Engine classes, any car need an engine to go anywhere, at least for now. So below how code will look without dependency injection.
*/

/*

public class Car
{
    public Car()
    {
        GasEngine engine = new GasEngine();
        engine.Start();
    }
}

public class GasEngine
{
    public void Start()
    {
        Console.WriteLine("I use gas as my fuel!");
    }
}

*/

/*
And to instantiate the Car class we will use next code:

Car car = new Car();
The issue with this code that we tightly coupled to GasEngine and if we decide to change it to ElectricityEngine then we will need to rewrite Car class. And the bigger the application the more issues and headache we will have to add and use new type of engine.

In other words with this approach is that our high level Car class is dependent on the lower level GasEngine class which violate Dependency Inversion Principle(DIP) from SOLID. DIP suggests that we should depend on abstractions, not concrete classes. So to satisfy this we introduce IEngine interface and rewrite code like below:
*/

interface Engine {
	void Start();
}

class GasEngine implements Engine {
	@Override
	public void Start() {
		System.out.println("I use gas as my fuel!");
	}
}

class ElectricityEngine implements Engine {
	@Override
	public void Start() {
		System.out.println("I am electrocar");
	}
}

/*
 * Below our Car class is dependent on only the IEngine interface, not a specific
 * implementation of engine. Now, the only trick is how do we create an instance
 * of the Car and give it an actual concrete Engine class like GasEngine or
 * ElectricityEngine. That's where Dependency Injection comes in.
 */

public class DependencyInjection {
	private Engine engine;

	public DependencyInjection(Engine engine) {
		this.engine = engine;
	}

	public void Run() {
		engine.Start();
	}

	public static void main(String[] args) {

		DependencyInjection gasCar = new DependencyInjection(new GasEngine());
		gasCar.Run();
		DependencyInjection electroCar = new DependencyInjection(new ElectricityEngine());
		electroCar.Run();
	}
}

/*
 * Here we basically inject(pass) our dependency(Engine instance) to Car
 * constructor. So now our classes have loose coupling between objects and their
 * dependencies, and we can easily add new types of engines without changing the
 * Car class.
 * 
 * The main benefit of the Dependency Injection that classes are more loosely
 * coupled, because they do not have hard-coded dependencies. This follows the
 * Dependency Inversion Principle, which was mentioned above. Instead of
 * referencing specific implementations, classes request abstractions (usually
 * interfaces) which are provided to them when the class is constructed.
 * 
 * So in the end Dependency injection is just a technique for achieving loose
 * coupling between objects and their dependencies. Rather than directly
 * instantiating dependencies that class needs in order to perform its actions,
 * dependencies are provided to the class (most often) via constructor
 * injection.
 * 
 * Also when we have many dependencies it is very good practice to use Inversion
 * of Control(IoC) containers which we can tell which interfaces should be
 * mapped to which concrete implementations for all our dependencies and we can
 * have it resolve those dependencies for us when it constructs our object. For
 * example, we could specify in the mapping for the IoC container that the
 * IEngine dependency should be mapped to the GasEngine class and when we ask
 * the IoC container for an instance of our Car class, it will automatically
 * construct our Car class with a GasEngine dependency passed in.
 */

/*
 * 
 * Without Dependency Injection
 * 
 * Application needs Foo (e.g. a controller), so: Application creates Foo
 * Application calls Foo Foo needs Bar (e.g. a service), so: Foo creates Bar Foo
 * calls Bar
 * 
 * Bar needs Bim (a service, a repository, …), so: Bar creates Bim Bar does
 * something
 * 
 * With Dependency Injection
 * 
 * Application needs Foo, which needs Bar, which needs Bim, so:
 * 
 * Application creates Bim Application creates Bar and gives it Bim
 * 
 * Application creates Foo and gives it Bar Application calls Foo Foo calls Bar
 * Bar does something
 * 
 */