# Overview
The purpose of this document is to outline our baseline requirements for this project. The requirements are sorted by features of the app design to better handle the working aspect of our project and to designate tasks to specific group members easier. In this document, we have oultined functional and non functional requirements for our entire project and will  be adding and modifying this document later on as the project progresses

# Software Requirements

* Describe the structure of this section

## Functional Requirements

### Notification System

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | The user shall be notified by the app using the notification system at preset times | TC24 |
| FR2 | The notification system shall continue to notify the user until the task is complete/deadline passed. | TC24 |
| FR3 | The notification system shall use haptics to notify user. | TC22 |
| FR4 | The notification system shall use sounds to alert user of notification. | TC22 |
| FR5 | The notification system shall produce an on screen display. | TC22 |

### Agenda

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR6 | A task that is checked off by the user shall be removed from the agenda. | TC7 |
| FR7 | A task that is added by the user shall correspond to the date that was inputed on the agenda. | TC2, TC3, TC4 |
| FR8 | The agenda shall display correct tasks based on the class. | TC19 |
| FR9 | A class that is added by the user shall appear in list of classes. | TC1, TC6, TC18 |
| FR10 | Descriptions that a user adds with a class shall correspond correctly with the right classes. | TC6, TC10, TC18 |

### Tasks

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR11 | The app shall be able to take a user inputted name of assignment. | TC2, TC8, TC20 |
| FR12 | The app shall take a user inputted due date of assignment. | TC4, TC8, TC20 |
| FR13 | The user shall be able to add an importance level to each assignment. | TC3, TC8 , TC20|
| FR14 | The tasks shall be sorted based on importance level.  | TC11 |
| FR15 | The app shall remove a task/class from the list when user deletes it. | TC9, TC21 |

## Non-Functional Requirements

### Notification System

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR1 | The notification system shall have a unique sound to notify the user. | TC22 |
| NFR2 | The notification system shall have an on screen notification visible. | TC22 |
| NFR3 | The notification system shall be turned off once user exits. | TC22 |
| NFR4 | The notification system shall take up most of the screen for the notification. | TC22 |
| NFR5 | The notification system shall have a drop down notification visible. | TC22 |

### Agenda

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR6 | The agenda shall allow the input of multiple events on a date without slowing down the app. | TC23 |
| NFR7 | The agenda shall be able to process back to back removes or adds of tasks at a reliable speed. | TC23 |
| NFR8 | Text boxes asking for task information shall pop up in a timely manner from the agenda. | TC23 |
| NFR9 | A date on the agenda shall be highlighted to signify the current date. | TC4 |
| NFR10 | The agenda shall display a monthly calendar | TC5 |

### Tasks

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR11 | The interface for creating tasks shall be user friendly and easy to use. | TC4, TC13, TC14, TC15, TC16, TC19, TC20, TC23 |
| NFR12 | Tasks shall be created in a timely manner upon inputs. | TC8, TC20, TC23 |
| NFR13 | Tasks shall be easy to find once created. | TC6, TC19, TC20 |
| NFR14 | Tasks shall be removed in a timely manner when user deletes it. | TC4, TC9|
| NFR15 | Tasks shall be highlighted based on importance level. | TC5 |

# Test Specification
* Description of what this section is

## Unit test
| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC1 | Tests to make sure the class name corresponds correctly to user input | 1. Create a task with all inputs needed including assignment name, class name, class description, due date, and priority level. 2. Test to see if the class name from the task is equal to what was inputted. | "CIS350" and task1.getClassName() | CIS350 | CIS350 | Passed | FR9 |
| TC2 | Tests to make sure the assignment name corresponds correctly to user input| 1. Create a  task with all inputs needed for a task. 2. Test to see if the assignment name assigned to the task is the same as the assignment inputted. | "Homework5" and task1.getAssignmentName() | Homework5 | Homework5 | Passed | FR7, FR11 |
| TC3 | Tests to make sure the priority level corresponds correctly to the user input | 1. Create a task with all inputs needed for a task. 2. Test to see if the priority level assigned to the task is the same as the priority level inputted. | 6 and task1.getPriority() | 6 | 6 | Passed | FR7, FR13 |
| TC4 | Tests to make sure the due date corresponds correctly to user input | 1. Create a task with all inputs needed for a task. 2. Test to see if the due date assigned to the task is the same as the due date inputted. | "12/25/2020" and task1.getDueDate() | 12/25/2020 | 12/25/2020 | Passed | FR7, FR12 |
| TC5 | Tests to make sure the priority level color corresponds to the correct priority level | 1. Push Add Task Button 2. Create a task with inputs of name, priority of either (HIGH, MEDIUM, LOW, or N/A). 3. Test to see if inputted priority has correct color assigned | "HW 7", "HIGH", "12/25/20" and add Task Button |"HW 7", "HIGH" (Red color) , "12/25/20" | "HW 7", "HIGH" (Red color) , "12/25/20" | Passed | NFR15 |
| TC6 | Tests to see if a class is added correctly to their class list when the add button is pressed. | 1. Create a class with name and description. 2. Add the class to list. 3. Check if class is correctly added to the list | "CIS350", "Software Engineering", list.get(0).getClassName(), and list.get(0).getClassDescription | "CIS350" and "Software Engineering" | "CIS350" and "Software Engineering" | Passed | FR9, FR10 |
| TC7 | Tests to see if a class is removed correctly from the class list when the remove button is pressed | 1. Create a class 2. Add class to the list 3. Remove the class from the list. 4. Check if class is removed from the list | "CIS350", list.get(0).getClassName(), 0, list.getSize() | "CIS350" and 0 | "CIS350" and 0 | Passed | FR6 |
| TC8 | Tests to see if a task is added correctly to their task list when add button is pressed | 1. Click Add Task button on screen. 2. Input chosen data. 3. Test to see if displayed correctly | ""HW 7", "HIGH", "12/25/20" | "HW 7", "HIGH", "12/25/20" | "HW 7", "HIGH", "12/25/20" | Passed | FR11, FR12, FR13, NFR12, FR13|
| TC9 | Tests to see if a task is removed correctly from their task list when remove button is pressed | 1. Click View button to view task list for a specific class. 2. Click Delete Button to test if task is deleted from view | Task test = new Task(); test = list.get(0); list.removeTask(0); assert(!test, list.get(0));| no view of task | no view of task | Passed | FR15 |
| TC10 | Tests to see if class description corresponds correctly with the user input | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | FR10 |
| TC11 | Tests to see if tasks are sorted by priority level | 1. Click View Button on Class. 2. Click Add Task Button. 3. Add Data. 4. Test output. | "MEDIUM"; setSorting(PRIORITY); Update(); notifyDataSetChanged(); | list.get(2).getPriority().equals("MEDIUM"); | list.get(2).getPriority().equals("MEDIUM"); | Passed | FR14 |


## Integration Tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC12 | Tests to see if context of app is correct | 1. instantiate a context | none | "com.example.myappy" | "com.example.myappy" | Passed | none |
| TC13 | Tests to see if button displays correct message for Task List Row  | 1. instantiate button. 2. set button to layout id | none | "NAME:" | "NAME:" | Passed | NFR11 |
| TC14 | Tests to see if button displays correct message for Deleting Class | 1. instantiate button. 2. set button to layout id | none | "Delete" | "Delete" | Passed | NFR11 |
| TC15 | Tests to see if button displays correct message for Adding Class  | 1. instantiate button. 2. set button to layout id | none | "Add Class" | "Add Class" | Passed | NFR11 |
| TC16 | Tests to see if button displays correct message for Adding Task  | 1. instantiate button. 2. set button to layout id | none | "Add Task" | "Add Task" | Passed | NFR11 |

## System tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC17 | Testing to see if phone is turned will layout display correctly | 1. Open app. 2. Turn phone 90 degrees | none | Values show correclty | Values showed correctly | Passed | None |
| TC18 | Testing if adding a class will show picture, name, description and new view and delete buttons | 1. Click add class button 2. Input data needed | "CIS 343", "Structures of Programming Languages", "View" button, "Delete" button | Blackboard image, "CIS 343", "Structures of Programming Languages", "View" button, "Delete" button | Blackboard Image, "CIS 343", "Structures of Programming Languages", "View" button, "Delete" button | Passed | FR9, FR10 |
| TC19 | Testing if clicking the view button shows correct task list | 1. Open app. 2. Click on classes view button | none | List of classes specific tasks | List of classes specific tasks | Passed | FR8, NFR11 |
| TC20 | Testing to see if adding task shows dialog boxes and input lines correctly | 1. Open app. 2. Click view button for a class. 3. Click add task button | none | dialog boxes appears in order Name, Priority, Due Date, Notifcation choice | Dialog boxes appeared in correct order | Passed | FR11, FR12, FR13, NFR11, NFR12, NFR13 |
| TC21 | Testing to see if deleting a class no longer shows said class | 1. Open app. 2. Click delete button for a class  | none | Class view is no longer seen | Class view is no longer seen | Passed | FR15 |
| TC22 | Testing to see if notifying user will produce sound and vibrate | 1. Open app. 2. Click add button for a task list. 3. Click yes to being notified by system for task | "Test", "HIGH", "12/20/20" | sound is produced, vibration produced| FIX ME!!!!! | Passed | FR3, FR4, FR5, NFR1, NFR2, NFR3, NFR4, NFR5 |
| TC23 | Testing to add multiple events without slowdown | 1. Open app. 2. Add Classes. Click on a made class' view button. 3. Add Tasks | Multiple Classes and Tasks Being Made | App running smoothly | App ran smoothly | Passed | NFR6, NFR7, NFR8, NFR11, NFR12 |
| TC24 | Testing to see if notification system will display message at set time until user finishes task. | 1. Open app. 2. Add task. 3. Click yes to being notified. | Task entered | App should display notifcation everyday at noon until task is done with | App displayed correctly | Passed | FR1, FR2 |


# Software Artifacts

These are all of our software artifacts that we created along with our progression of this project. Each of them having their own unique addition to our overall documentation. 

* [Agenda use case diagram](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/use_case_diagrams/Agenda_use_case_diagram.jpg)
* [Notification use case diagram](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/use_case_diagrams/Notification%20System%20Use%20case.jpg)
* [Task List use case diagram](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/use_case_diagrams/Use%20case%20diagram%20editing%20task%20list.JPG)
* [Task List use case diagram extended syntax](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/use_case_diagrams/editing_task_use_case_extended.md)
* [Project timeline Gantt Chart](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/gantt%20Chart.pdf)
* [Midterm Presentation](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/MidtermPresentation-JKJ.pdf)
* [Final Presentation](https://github.com/Khawk2000/GVSU-CIS350-jkj/blob/master/artifacts/Final%20Presentation.pdf)

