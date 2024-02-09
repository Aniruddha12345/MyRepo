package controller;

public class Employee {
	
	public Employee(String name,Integer salary) {
		this.name = name;
		this.salary = salary;
	}

	private String name;
	private Integer salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer add (Integer a, Integer b) {
		return a+b;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
}
