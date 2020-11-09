package Hoevejo;

import java.util.Comparator;

public class DueDateSorter implements Comparator<Task>
{
    @Override
    public int compare(Task o1, Task o2) {
        return o1.getDueDate().compareTo(o2.getDueDate());
    }
}