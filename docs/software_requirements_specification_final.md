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
| FR9 | A class that is added by the user shall appear in list of classes. | TC1 |
| FR10 | Descriptions that a user adds with a class shall correspond correctly with the right classes. | TC2 |

### Tasks

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| FR11 | The app shall be able to take a user inputted name of assignment. | TC1 |
| FR12 | The app shall take a user inputted due date of assignment. | TC2 |
| FR13 | The user shall be able to add an importance level to each assignment. | TC3 |
| FR14 | The tasks shall be sorted correctly based on importance level.  | TC1 |
| FR15 | The app shall remove a task from the list when user deletes it. | TC2 |

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
| NFR7 | The agenda shall be able to process back to back removes or adds of tasks at a reliable speed. | TBD |
| NFR8 | Text boxes asking for task information shall pop up in a timely manner from the agenda. | TC6 |
| NFR9 | A date on the agenda shall be highlighted to signify the current date. | TC4 |
| NFR10 | The agenda shall display a monthly calendar | TC5 |

### Tasks

| ID  | Requirement     | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR11 | The interface for creating tasks shall be user friendly and easy to use. | TC4 |
| NFR12 | Tasks shall be created in a timely manner upon inputs. | TBD |
| NFR13 | Tasks shall be easy to find once created. | TC6 |
| NFR14 | Tasks shall be removed in a timely manner when user deletes it. | TC4 |
| NFR15 | Tasks shall be highlighted based on importance level. | TC5 |
i
# Test Specification
* Description of what this section is

## Unit test
| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC1 | Tests to make sure the class name corresponds correctly to user input | 1. Create a task with all inputs needed including assignment name, class name, class description, due date, and priority level. 2. Test to see if the class name from the task is equal to what was inputted. | "CIS350" and task1.getClassName() | CIS350 | CIS350 | Passed | FR11 |
| TC2 | Tests to make sure the assignment name corresponds correctly to user input| 1. Create a  task with all inputs needed for a task. 2. Test to see if the assignment name assigned to the task is the same as the assignment inputted. | "Homework5" and task1.getAssignmentName() | Homework5 | Homework5 | Passed ||
| TC3 | Tests to make sure the priority level corresponds correctly to the user input | 1. Create a task with all inputs needed for a task. 2. Test to see if the priority level assigned to the task is the same as the priority level inputted. | 6 and task1.getPriority() | 6 | 6 | Passed | FR13 |
| TC4 | Tests to make sure the due date corresponds correctly to user input | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC5 | Tests to make sure the priority level color corresponds to the correct priority level | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC6 | Tests to see if a class is added correctly to their class list when the add class button is pressed| <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC7 | Tests to see if a class is removed correctly from the class list when the remove class button is pressed | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC8 | Tests to see if a task is added correctly to their task list when add button is pressed | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC9 | Tests to see if a task is removed correctly from their task list when remove button is pressed | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
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
| TC16 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC17 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC18 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC19 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
| TC20 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |


# Software Artifacts

< Describe the purpose of this section>

* I am a link to some file.pdf


