package Wallmart;

public class OverloadingDemo {
    public void meth(int value) {
        System.out.println("int value : " + value);
    }
    public void meth(String name) {
        System.out.println("String value : " + name);
    }
    public String meth(int value, String name) {
    	
        System.out.println("Name with value : " + value+" "+name);
        return "Hello";
    }
    public static void main(String[] args) {
        OverloadingDemo demo = new OverloadingDemo();
        demo.meth(10);
        demo.meth("online tutorials point");
        System.out.println(demo.meth(20, "Overloading Demo"));
    }
}