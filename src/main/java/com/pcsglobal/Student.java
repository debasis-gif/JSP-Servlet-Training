// Student object to be used in JstlServlet
// Whenever an object is to be used in JSP it needs to be used as BEANS (getters & setters)

package com.pcsglobal;

public class Student 
{
	int rollno;
	String name;
	
	public Student(int rollno, String name) 
	{
		super();
		this.rollno = rollno;
		this.name = name;
	}

	// Creating the Beans of the object to be used in JSP
	// Getters & Setters
	/**
	 * @return the rollno
	 */
	public int getRollno() {
		return rollno;
	}

	/**
	 * @param rollno the rollno to set
	 */
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	// To implement display of all the properties in an object we use toString
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}

	
}
