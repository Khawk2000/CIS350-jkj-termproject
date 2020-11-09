package Hoevejo;

import java.util.Comparator;

public class ClassNameSort implements Comparator<Task>
{
    @Override
    public int compare(Task o1, Task o2) {
        return o1.getClassName().compareToIgnoreCase(o2.getClassName());
    }
}
