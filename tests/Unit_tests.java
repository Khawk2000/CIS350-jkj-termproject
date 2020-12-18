package jkj;

import static org.junit.Assert.*;

import org.junit.Test;

public class Unit_tests {

	@Test
	public void ClassName() {
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		assertEquals("CIS350", task1.getClassName());
	}
	
	@Test
	public void AssignmentName() {
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		assertEquals("Homework5", task1.getAssignmentName());	
	}
	
	@Test
	public void Priority() {
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		assertEquals(6, task1.getPriority());
	}
	
	@Test
	public void DueDate() {
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		assertEquals("12/25/2020", task1.getDueDate());
	}
	
	@Test
	public void ClassDescription() {
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		assertEquals("Software Engineering", task1.getClassDescription());
	}
	
	@Test
	public void AddTask() {
		TaskList list = new TaskList();
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		Task task2 = new Task("Homework6", "CIS350", "Software Engineering", "12/25/2020", 8);
		list.addTask(task1);
		list.addTask(task2);
		assertEquals(task1, list.get(0));
		assertEquals(task2, list.get(1));
	}
	
	@Test
	public void RemoveTask() {
		TaskList list = new TaskList();
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		Task task2 = new Task("Homework6", "CIS350", "Software Engineering", "12/25/2020", 8);
		list.addTask(task1);
		list.addTask(task2);
		assertEquals(2, list.getSize());
		list.removeTask(task1);
		assertNotEquals(task1, list.get(0));
		assertEquals(1, list.getSize());
		list.removeTask(task2);
		assertEquals(0, list.getSize());
	}
	
	@Test
	public void AddClass() {
		TaskList list = new TaskList();
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		list.addTask(task1);
		assertEquals("CIS350", list.get(0).getClassName());
		assertEquals("Software Engineering", list.get(0).getClassDescription());
	}
	
	@Test 
	public void RemoveClass() {
		TaskList list = new TaskList();
		Task task1 = new Task("Homework5", "CIS350", "Software Engineering", "12/25/2020", 6);
		Task task2 = new Task("Homework2", "CIS343", "Structure of Programming Languages", "12/25/2020", 8);
		list.addTask(task1);
		list.addTask(task2);
		assertEquals("CIS350", list.get(0).getClassName());
		list.removeTask(task1);
		assertEquals("CIS343", list.get(0).getClassName());
		list.removeTask(task2);
		assertEquals(0, list.getSize());
	}
}

