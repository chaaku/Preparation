package Wallmart;

class A {}
class B extends A {}
class C extends A {}
 
public class InstanceofDemo
{
  public static void main(String args[])
  {
    A a = new A();
    B b = new B();
    C c = new C();
 
    System.out.println("a instanceof A: " + (a instanceof A)); //true
    System.out.println("b instanceof A: " + (b instanceof A)); //true
    System.out.println("c instanceof A: " + (c instanceof A)); //true
    System.out.println("a instanceof B: " + (a instanceof B)); //false
    System.out.println("null instanceof A: " + (null instanceof A)); //false
    System.out.println("null isinstance A: " + a.getClass().isInstance(b)); //false
    System.out.println("a.getClass().isInstance(a): " + a.getClass().isInstance(a)); //true
    System.out.println("b.getClass().isInstance(c): " + b.getClass().isInstance(c)); //false
  }
}