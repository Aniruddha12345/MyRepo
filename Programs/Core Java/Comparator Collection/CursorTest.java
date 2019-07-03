package controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;

public class CursorTest {

	public static void main(String[] args) {
		List s1 = new ArrayList();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s1.add(62);
		s1.add(74);
		s1.add(8);
		s1.add(9);
		s1.add(10);

		for (Object o : s1) {
			if ((Integer) o % 2 == 0) {
				System.out.println(o);
			}
		}

	}

}

class CompareTest implements Comparator {

	public int compare(Object o1, Object o2) {
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;
		if (i1 > i2)
			return -1;
		else if (i1 < i2)
			return +1;
		else
			return 0;
	}

	public static void main(String[] args) {
		Set treeSet = new TreeSet(new CompareTest());
		treeSet.add(40);
		treeSet.add(20);
		treeSet.add(50);
		treeSet.add(10);
		treeSet.add(50);
		treeSet.add(30);

		for (Object o : treeSet) {
			System.out.println(o);
		}

	}

}

class CompareTestEmp implements Comparator{

	//implementation for descending order ascending order 
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee) o1;
		Employee e2 =(Employee) o2;
		Integer i1 = e1.getSalary();
		Integer i2 = e2.getSalary();
		if (i1 > i2)
			return -1;
		else if (i1 < i2)
			return +1;
		else
			return 0;

	}
	
	public static void main(String[] args) {
		Set<Employee> treeset = new TreeSet<Employee>(new CompareTestEmp());
		treeset.add(new Employee("Aniruddha", 300));
		treeset.add(new Employee("Tushar", 500));
		treeset.add(new Employee("Shalini", 900));
		treeset.add(new Employee("Siddarth", 200));
		treeset.add(new Employee("Gaurav", 700));
		treeset.add(new Employee("Siddarth", 200));
		
		for(Employee e:treeset){
			System.out.println(e);
			
		}
	}
}

