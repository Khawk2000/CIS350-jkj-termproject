package CIS350TermProject;

import javax.swing.*;
import java.util.*;

public class Task {
    private String assignmentName;
    private String className;
    private int priority;
    private String dueDate;

    public Task(){
        assignmentName = " ";
        className = " ";
        priority = 0;
        dueDate = " ";

    }

    public Task(String name, String clss, String date, int num){
        assignmentName = name;
        className = clss;
        priority = num;
        dueDate = date;

    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String toString(){
        return ("Assignment: " + assignmentName + " Class name: " + className + " Due date: " + dueDate);
    }
}

