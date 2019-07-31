package Second_Inning;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

	int rollNo;
	int age;
	String name;

	public Student(String name, int rollNo, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
	}

	@Override
	public int compareTo(Student st) {
		// TODO Auto-generated method stub
		if (age > st.age)
			return 1;
		else if (age < st.age)
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return this.name + "   " + this.age + "   " + this.rollNo+"\n" ;
	}
}

class ComparableExampleStudentClass {

	public static void main(String[] args) {

		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("chandan", 11, 21));
		al.add(new Student("kanchan", 20, 3));
		al.add(new Student("kunadan", 3, 19));

		Collections.sort(al);
		System.out.println( "name     " + " age  " + "rollNo") ;
		System.out.println(al);
	}

}
