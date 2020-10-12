package Hoevejo;

import java.util.ArrayList;


public class TaskList {
    private ArrayList<Task> list;
    private int size;

    public TaskList(){
        this.list  = new ArrayList<Task>();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void setList(ArrayList<Task> list) {
        this.list = list;
    }

    public void addTask(Task task){
        list.add(task);
        size++;
    }

    public void removeTask(Task h){ 
        int index = list.indexOf(h);

        list.remove(index);
        size--;
    }

    public static void main(String[] arg){
        TaskList list = new TaskList();

        Task x = new Task("HW5", "Cis263", 1, "20201510");
        Task y = new Task("HW3", "Cis350", 5, "20201510");
        Task z = new Task("Test", "Cis241", 10, "20201510");
        Task a = new Task("Quiz", "Mth325", 6, "20201510");

        list.addTask(x);
        list.addTask(y);
        list.addTask(z);
        list.addTask(a);

        for(int i = 0; i < list.size; i++){
            System.out.println(list.getList().get(i).toString());
        }

        list.removeTask(z);

        for(int i = 0; i < list.size; i++){
            System.out.println(list.getList().get(i).toString());
        }

    }

}
