package CIS350TermProject;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Agenda{
    private static JLabel lblMonth, lblYear;
    private static JButton btnPrev, btnNext, btnAdd, btnRmv;
    private static JTable tblCalendar;
    private static JComboBox cmbYear, cmbSort;
    private static JFrame frmMain;
    private static Container pane;
    private static DefaultTableModel mtblCalendar; //Table model
    private static JScrollPane stblCalendar; //The scrollpane
    private static JPanel pnlCalendar;
    private static int realYear, realMonth, realDay, currentYear, currentMonth;
    private static TaskList list;
    private static JTable taskTable;
    private static JScrollPane taskScroll;
    private static JPanel pnlTaskList;

    protected static int sorting = 0;

    public static void main (String args[]){
        //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}

        //Prepare frame
        frmMain = new JFrame ("HomeworkHelp Agenda"); //Create frame
        frmMain.setSize(1200, 900); //Set size to 400x400 pixels
        pane = frmMain.getContentPane(); //Get content pane
        pane.setLayout(null); //Apply null layout
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked

        //Create controls
        lblMonth = new JLabel ("January");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        cmbSort = new JComboBox();
        btnPrev = new JButton ("<-");
        btnNext = new JButton ("->");
        btnAdd = new JButton ("Add Task");
        btnRmv = new JButton ("Checkoff Task");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        list = new TaskList();
        taskTable = new JTable(list);
        taskScroll = new JScrollPane(taskTable);
        taskScroll.setSize(new Dimension(800, 300));
        pnlTaskList = new JPanel();


        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        pnlTaskList.setBorder(BorderFactory.createTitledBorder("Task List"));
        pnlTaskList.setLayout(new GridLayout(4, 2));




        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        btnAdd.addActionListener(new btnAdd_Action());
        btnRmv.addActionListener(new btnRmv_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        cmbSort.addActionListener(new cmbSort_Action());

        //Add controls to pane
        pane.add(pnlCalendar);
        pane.add(pnlTaskList);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(cmbSort);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        pnlTaskList.add(taskScroll);
        pnlCalendar.add(btnAdd);
        pnlCalendar.add(btnRmv);

        //Set bounds
        pnlCalendar.setBounds(300, 0, 600, 335);
        pnlTaskList.setBounds(200, 335, 800, 800);
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
        lblYear.setBounds(10, 305, 80, 20);
        cmbYear.setBounds(230, 305, 80, 20);
        cmbSort.setBounds(360, 250, 80, 20);
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(260, 25, 50, 25);
        btnAdd.setBounds(350, 100, 100, 50);
        btnRmv.setBounds(350, 180, 100, 50);
        stblCalendar.setBounds(10, 50, 300, 250);

        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);

        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;

        //Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }



        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background


        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        //Set row/column count
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);


        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }

        cmbSort.addItem("Class Name");
        cmbSort.addItem("Due Date");
        cmbSort.addItem("Priority");


        //Refresh calendar
        refreshCalendar (realMonth, realYear); //Refresh calendar
    }

    public static void refreshCalendar(int month, int year){
        //Variables
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; //Number Of Days, Start Of Month

        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        btnAdd.setEnabled(true);
        btnRmv.setEnabled(true);
        if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblMonth.setText(months[month]); //Refresh the month label (at the top)
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        cmbSort.setSelectedItem("Sort");

        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }

        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        //Draw calendar
        for (int i=1; i<=nod; i++){
            int row = (i + som - 2) / 7;
            int column  =  (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }

        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }



    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }

    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 0){ //Back one year
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 11){ //Foward one year
                currentMonth = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnAdd_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String assignName = JOptionPane.showInputDialog("Enter the name of this assignment", "Name");
            String className = JOptionPane.showInputDialog("Enter the name of the class this assignment is for","CIS350");
            String dueDate = JOptionPane.showInputDialog("Enter the date this assignment is due (MM/DD/YYYY)", "01/01/2020");
            String priorNUM = JOptionPane.showInputDialog("Enter the priority of this assignment(1-10)", 1);
            int priority = Integer.parseInt(priorNUM);
            list.addTask(new Task(assignName, className, dueDate, priority));
            list.Update();
        }
    }
    static class btnRmv_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(btnRmv == e.getSource()){
                int index = taskTable.getSelectedRow();
                if(index == -1){
                    JOptionPane.showMessageDialog(null, "You must select a task to delete");
                }else{
                    Task t = list.get(index);
                    list.removeTask(t);
                }
            }
        }
    }

    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }

    static class cmbSort_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbSort.getSelectedItem() == "Class Name"){
                list.setSorting(1);
            }
            if (cmbSort.getSelectedItem() == "Due Date"){
                list.setSorting(2);
            }
            if (cmbSort.getSelectedItem() == "Priority") {
                list.setSorting(3);
            }
        }
    }

}
