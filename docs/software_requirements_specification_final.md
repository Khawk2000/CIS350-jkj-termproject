# Overview
The purpose of this document is to outline our baseline requirements for this project. The requirements are sorted by features of the app design to better handle the working aspect of our project and to designate tasks to specific group members easier. In this document, we have oultined functional and non functional requirements for our entire project and will  be adding and modifying this document later on as the project progresses

# Software Requirements

* Describe the structure of this section

## Functional Requirements

### Notification System

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | The user shall be notified by the app using the notification system at preset times by the user. | TC1 |
| FR2 | The notification system shall continue to notify the user until the task is complete/deadline passed. | TC2 |
| FR3 | The notification system shall use haptics to notify user. | TC1,TC2 |
| FR4 | The notification system shall use sounds to alert user of notification. | TC1 |
| FR5 | The notification system shall produce an on screen display that the user can click on to access. | TC2 |

### Agenda

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR6 | A task that is checked off by the user shall be removed from the agenda. | TC1 |
| FR7 | A task that is added by the user shall correspond to the date that was inputed on the agenda. | TC2 |
| FR8 | The agenda shall display correct tasks based on the date. | TC1,TC2 |
| FR9 | A class that is added by the user shall appear in list of classes. | TC6, TC17 |
| FR10 | Descriptions that a user adds with a class shall correspond correctly with the right classes. | TC6, TC17 |

### Tasks

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR11 | The app shall be able to take a user inputted name of assignment. | TC1, TC8, TC19 |
| FR12 | The app shall take a user inputted due date of assignment. | TC4, TC8, TC19 |
| FR13 | The user shall be able to add an importance level to each assignment. | TC3, TC8 , TC19|
| FR14 | The tasks shall be sorted correctly based on importance level.  | TC1 |
| FR15 | The app shall remove a task/class from the list when user deletes it. | TC2, TC9, TC20 |

## Non-Functional Requirements

### Notification System

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR1 | The notification system shall have a unique sound to notify the user. | TC4 |
| NFR2 | The notification system shall have an on screen notification visible. | TBD |
| NFR3 | The notification system shall be turned off once user exits. | TC6 |
| NFR4 | The notification system shall take up most of the screen for the notification. | TC4 |
| NFR5 | The notification system shall have a drop down notification visible. | TC5 |

### Agenda

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR6 | The agenda shall allow the input of multiple events on a date without slowing down the app. | TC4 |
| NFR7 | The agenda shall be able to process back to back removes or adds of tasks at a reliable speed. | TC8, TC9 |
| NFR8 | Text boxes asking for task information shall pop up in a timely manner from the agenda. | TC6 |
| NFR9 | A date on the agenda shall be highlighted to signify the current date. | TC4 |
| NFR10 | The agenda shall display a monthly calendar | TC5 |

### Tasks

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR11 | The interface for creating tasks shall be user friendly and easy to use. | TC4, TC18, TC19 |
| NFR12 | Tasks shall be created in a timely manner upon inputs. | TC8, TC19 |
| NFR13 | Tasks shall be easy to find once created. | TC6, TC18, TC19 |
| NFR14 | Tasks shall be removed in a timely manner when user deletes it. | TC4, TC9|
| NFR15 | Tasks shall be highlighted based on importance level. | TC5 |
i
# Test Specification
* Description of what this section is

## Unit test
| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC1 | Tests to make sure the class name corresponds correctly to user input | 1. Create a task with all inputs needed including assignment name, class name, class description, due date, and priority level. 2. Test to see if the class name from the task is equal to what was inputted. | "CIS350" and task1.getClassName() | CIS350 | CIS350 | Passed | FR11 |
| TC2 | Tests to make sure the assignment name corresponds correctly to user input| 1. Create a  task with all inputs needed for a task. 2. Test to see if the assignment name assigned to the task is the same as the assignment inputted. | "Homework5" and task1.getAssignmentName() | Homework5 | Homework5 | Passed | None |
| TC3 | Tests to make sure the priority level corresponds correctly to the user input | 1. Create a task with all inputs needed for a task. 2. Test to see if the priority level assigned to the task is the same as the priority level inputted. | 6 and task1.getPriority() | 6 | 6 | Passed | FR13 |
| TC4 | Tests to make sure the due date corresponds correctly to user input | 1. Create a task with all inputs needed for a task. 2. Test to see if the due date assigned to the task is the same as the due date inputted. | "12/25/2020" and task1.getDueDate() | 12/25/2020 | 12/25/2020 | Passed | FR12 |
| TC5 | Tests to make sure the priority level color corresponds to the correct priority level | 1. Push Add Task Button 2. Create a task with inputs of name, priority of either (HIGH, MEDIUM, LOW, or N/A). 3. Test to see if inputted priority has correct color assigned | "HW 7", "HIGH", "12/25/20" and add Task Button |"HW 7", "HIGH" (Red color) , "12/25/20" | "HW 7", "HIGH" (Red color) , "12/25/20" | Passed | NFR15 |
| TC6 | Tests to see if a class is added correctly to their class list when the add button is pressed. | 1. Create a class with name and description. 2. Add the class to list. 3. Check if class is correctly added to the list | "CIS350", "Software Engineering", list.get(0).getClassName(), and list.get(0).getClassDescription | "CIS350" and "Software Engineering" | "CIS350" and "Software Engineering" | Passed | FR9, FR10 |
| TC7 | Tests to see if a class is removed correctly from the class list when the remove button is pressed | 1. Create a class 2. Add class to the list 3. Remove the class from the list. 4. Check if class is removed from the list | "CIS350", list.get(0).getClassName(), 0, list.getSize() | "CIS350" and 0 | "CIS350" and 0 | Passed | None |
| TC8 | Tests to see if a task is added correctly to their task list when add button is pressed |1.Click Add Task button on screen. 2. Input chosen data. 3. Test to see if displayed correctly | ""HW 7", "HIGH", "12/25/20" | "HW 7", "HIGH", "12/25/20" | "HW 7", "HIGH", "12/25/20" | Passed | FR11, NFR12, FR13|
| TC9 | Tests to see if a task is removed correctly from their task list when remove button is pressed | 1. Click View button to view task list for a specific class. 2. Click Delete Button to tets if task is dleeted from view | CIS 350 View Button -> Delete Task Button | no view of task | no view of task | Passed | <requirement IDs this test case is linked to> |
| TC10 | Tests to see if class description corresponds correctly with the user input | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |


## Integration Tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC11 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC12 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC13 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC14 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC15 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |


## System tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC16 | Testing to see if phone is turned will layout display correctly | 1. open app. 2. Turn phone 90 degrees | none | Values show correclty | Values showed correctly | Passeed | None |
| TC17 | Testing if adding a class will show picture, Name, Description and new View and Delete buttons | 1. Click Add Class button 2. Input Data needed | "CIS 343", "Structures of Programming Languages", View button, Delete button | Blackboard Image, "CIS 343", "Structures of Programming Languages", View button, Delete button | Blackboard Image, "CIS 343", "Structures of Programming Languages", View button, Delete button | Passed | FR9, FR10 |
| TC18 | Testing if clicking the view button shows correct task list | 1. Open app. 2. Click on classes view button | none | List of Classes Specific Tasks | List of Classes Specific Tasks | Passed | NFR11 |
| TC19 | Testing to see if Adding Task shows dialog boxes and input lines correctly | 1. Open app. 2. Click View button for a class. 3. Click Add Task Button | none | dialog boxes appears in order Name, Priority, Due Date, Notifcation Choice | dialog boxes appeared in correct order | Passed | FR11, FR12, FR13, NFR11, NFR12, NFR13 |
| TC20 | Testing to see if deleting a class no longer shows said class | 1. Open app. 2. Click delete button for a class  | none | Class view is no longer seen | Class view is no longer seen | Passed | FR15 |


# Software Artifacts

< Describe the purpose of this section>

* I am a link to some file.pdf


