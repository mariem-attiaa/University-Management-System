/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ums;

/**
 *
 * @author original store
 */
import java.util.Scanner;
import java.util.Stack;
//ENROLLL!! linked list but to enrollment to use in the function
    class enrolledcourseNode {
    int courseID;
    enrolledcourseNode next;
    enrolledcourseNode(int id) {
        courseID = id;
        next = null;
    }
    enrolledcourseNode(int id, enrolledcourseNode n) {
        courseID = id;
        next = n;
    }
}

class EnrolledCourseList {
    private enrolledcourseNode head;
    private enrolledcourseNode tail;
    EnrolledCourseList() {
        head = tail = null;
    }
    public void addToTail(int courseID) {
        if (head == null) {
            head = tail = new enrolledcourseNode(courseID);
        } else {
            tail.next = new enrolledcourseNode(courseID);
            tail = tail.next;
        }
    }
   
    //This to use in remove enrllment of course!!
   public void removeCourse(int courseID) {
    if (head == null) return;
    if (head.courseID == courseID) {
        head = head.next;
        if (head == null) tail = null;
        return;
    }
    enrolledcourseNode current = head;
    while (current.next != null) {
        if (current.next.courseID == courseID) {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
            return;
        }
        current = current.next;
    }
}
   public void sortByID() {
        if (head == null || head.next == null) return;
        for (enrolledcourseNode i = head; i != null; i = i.next) {
            for (enrolledcourseNode j = i.next; j != null; j = j.next) {
                if (i.courseID > j.courseID) {
                    int temp = i.courseID;
                    i.courseID = j.courseID;
                    j.courseID = temp;
                }
            }
        }
    }
    public enrolledcourseNode  //to get head and display
    getHead(){
    return head;    
    }
}

 class enrolledstudentnode {
    int studentID;
    enrolledstudentnode next;
    enrolledstudentnode(int id) {
        studentID = id;
        next = null;
    }
    enrolledstudentnode(int id, enrolledstudentnode n) {
        studentID = id;
        next = n;
    }
}
class EnrolledStudentList {
    private enrolledstudentnode head;
    private enrolledstudentnode tail;
    EnrolledStudentList() {
        head = tail = null;
    }
    public void addToTail(int studentID) {
        if (head == null) {
            head = tail = new enrolledstudentnode(studentID);
        } else {
            tail.next = new enrolledstudentnode(studentID);
            tail = tail.next;
        }
    }

    public void removeStudent(int studentID) {
        if (head == null) return;
        if (head.studentID == studentID) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }
        enrolledstudentnode current = head;
        while (current.next != null) {
            if (current.next.studentID == studentID) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public void sortByID() {
        if (head == null || head.next == null) return;
        for (enrolledstudentnode i = head; i != null; i = i.next) {
            for (enrolledstudentnode j = i.next; j != null; j = j.next) {
                if (i.studentID > j.studentID) {
                    int temp = i.studentID;
                    i.studentID = j.studentID;
                    j.studentID = temp;
                }
            }
        }
    }
    public enrolledstudentnode //to get head and display 
    getHead(){
        return head;
    }
}


class studentNode {
    int studentID;
    studentNode next;
    EnrolledCourseList coursat; 
    
    studentNode(int id) {
        studentID = id;
        next = null;
        coursat = new EnrolledCourseList(); 
    }
    studentNode(int id, studentNode n) {
        studentID = id;
        next = n;
        coursat = new EnrolledCourseList();
    }
}
 class studentlist {
    private studentNode head;
    private studentNode tail;
    private int Scount = 0;
    studentlist(){
        head=tail=null;
    }
    public studentNode findStudentNode(int id) {
    studentNode temp = head;
    while (temp != null) {
        if (temp.studentID == id)
            return temp;
        temp = temp.next;
    }
    return null;
}
    public boolean is_empty_student(){
        if (head == null && tail == null )
            return true;
        else
            return false;
    }
    public boolean is_Student_found(int id) {
    studentNode temp = head;
    while (temp != null) {
        if (temp.studentID == id)
            return true;
        temp = temp.next;
    }
    return false;
}
     public void addStudent(int id) {
    if (is_Student_found(id)) {
        System.out.println("Student with ID " + id + " already exists.");
        return;
    }
    if (head == null) {
        head = tail = new studentNode(id);
    } else {
        tail.next = new studentNode(id);
        tail = tail.next;
    }
    System.out.println("Student " + id + " added.");
    Scount++;
}
    public void removeStudent(int id) {
    if (head == null) {
        System.out.println("Student list is empty.");
        return;
    }
    if (head.studentID == id) {
        head = head.next;
        if (head == null) tail = null; 
        Scount--;
        System.out.println("Student " + id + " removed.");
        return;
    }
    studentNode x = head;
    studentNode i = head.next;
    while (i != null) {
        if (i.studentID == id) {
            x.next = i.next;
            if (i == tail) tail = x;
            Scount--;
            System.out.println("Student " + id + " removed.");
            return;
        }
        x = i;
        i = i.next;
    }
    System.out.println("Student " + id + " not found.");
}
    public int getLastStudent() {
        if (tail != null)
            return tail.studentID;
        return -1;
    }
    public studentNode getHead() {
    return head;
}
   
}

class courseNode {
    int courseID;
    courseNode next;
    EnrolledStudentList studentat; 
    courseNode(int id) {
        courseID = id;
        next = null;
        studentat = new EnrolledStudentList();
    }
    courseNode(int id, courseNode n) {
        courseID = id;
        next = n;
        studentat = new EnrolledStudentList();
    }
}
     class courselist {
    private courseNode head;
    private courseNode tail;
    private int ccount = 0;
    courselist() {
        head = tail = null;
    }
   
public courseNode findCourseNode(int id) {
    courseNode temp = head;
    while (temp != null) {
        if (temp.courseID == id)
            return temp;
        temp = temp.next;
    }
    return null;
}
    public boolean is_empty_course(){
        if (head == null && tail == null )
            return true;
        else
            return false;
    }
    public boolean is_Course_found(int id) {
    courseNode temp = head;
    while (temp != null) {
        if (temp.courseID == id)
            return true;
        temp = temp.next;
    }
    return false;
}
    public void addCourse(int id) {
    if (is_Course_found(id)) {
        System.out.println("Course with ID " + id + " already exists.");
        return;
    }
    if (head == null) {
        head = tail = new courseNode(id);
    } else {
        tail.next = new courseNode(id);
        tail = tail.next;
    }
    System.out.println("Course " + id + " added.");
    ccount++;
}
    public void removeCourse(int id) {
    if (head == null) {
        System.out.println("Course list is empty.");
        return;
    }
    if (head.courseID == id) {
        head = head.next;
        if (head == null) tail = null; 
        ccount--;
        System.out.println("Course " + id + " removed.");
        return;
    }
    courseNode x = head;
    courseNode i = head.next;
    while (i != null) {
        if (i.courseID == id) {
            x.next = i.next;
            if (i == tail) tail = x;
            ccount--;
            System.out.println("Course " + id + " removed.");
            return;
        }
        x = i;
        i = i.next;
    }
    System.out.println("Course " + id + " not found.");
}
    public int getLastCourse() {
        if (tail != null)
            return tail.courseID;
        return -1;
    }
    
}

class UniversitySystem {
      class Action{
        String type; //enroll or remove
        int studentID;
        int courseID;
              Action(String type, int studentID, int courseID) { //constructor
            this.type = type;
            this.studentID = studentID;
            this.courseID= courseID;
        }
        
    }
     //stack of type action (enroll or remove)
    Stack <Action >undostack = new Stack<>(); //stack that keeps all the actions you did, so you can undo them later
    Stack<Action> redoStack = new Stack<>(); // stack that keeps the actions you undid, so you can redo them if you want
 studentlist students;   
courselist courses;
    UniversitySystem() {
        // i make lists so iwill attach!!
         students = new studentlist();
       courses= new courselist();
    } 
 public void enrollStudent(int studentID, int courseID,boolean recordAction) {
     // find  to get each snode and attach courses to it!!
    studentNode student = students.findStudentNode(studentID);
    courseNode course = courses.findCourseNode(courseID);
        if (student == null) {
            System.out.println("Student " + studentID + " not found.");
            return;
        }
        if (course == null) {
            System.out.println("Course " + courseID + " not found.");
            return;
        }
 //student refers to each node  .courses refers to linked list attached to it !!
    student.coursat.addToTail(courseID);
    course.studentat.addToTail(studentID);
    System.out.println("Student " + studentID + " enrolled in course " + courseID);
    
    if (recordAction) {
        Action action = new Action("ENROLL", studentID, courseID);
        undostack.push(action);
        redoStack.clear();
    }


    }
    public void removeEnroll(int studentID, int courseID,boolean recordAction) {
    // نجيب الطالب والكورس
    studentNode student = students.findStudentNode(studentID);
    courseNode course = courses.findCourseNode(courseID);
    if (student == null) {
        System.out.println("Student " + studentID + " not found.");
        return;
    }
    if (course == null) {
        System.out.println("Course " + courseID + " not found.");
        return;
    }
    // نشيل الكورس من عند الطالب
    student.coursat.removeCourse(courseID); // coursat of type EnrolledCourseList
    // نشيل الطالب من عند الكورس
    course.studentat.removeStudent(studentID); 
    System.out.println("Enrollment removed: Student " + studentID + " from course " + courseID);
   if (recordAction) {
        Action action = new Action("REMOVE", studentID, courseID);
        undostack.push(action);
        redoStack.clear();
    }

}
     public void undo() { // تراجع عن اخر خطوه
    if (!undostack.isEmpty()) {
     
        Action lastAction = undostack.pop(); //Store the operation (in this variable)
        //بناخد اخر عمليه من  stack  و بنشيلها من
 
        if (lastAction.type.equals("ENROLL")) {  //الطالب اتسجل
            System.out.println("Undo: Removing enrollment of Student " + lastAction.studentID + " from Course " + lastAction.courseID);
            //ببعت رساله للمستخدم ان انا هعمل تراجع عن التسجيل
          removeEnroll(lastAction.studentID, lastAction.courseID, false);  //remove
        } else if (lastAction.type.equals("REMOVE")) {
            System.out.println("Undo: Re-enrolling Student " + lastAction.studentID + " in Course " + lastAction.courseID);
            // رجع الطالب تاني
             enrollStudent(lastAction.studentID, lastAction.courseID,false);
        }

        redoStack.push(lastAction); //بعد ما عملنا تراجع، بنخزن العملية دي في redoStack علشان لو المستخدم حب يعمل "إعادة"
    } else {
        System.out.println("No actions to undo.");
    }
}
public void redo() {
    if (!redoStack.isEmpty()) {
       Action lastundoneAction =redoStack.pop();    // Get the last action that was undone
    
    if (lastundoneAction.type.equals("ENROLL")){
          System.out.println("Redo: Re-enrolling Student " + lastundoneAction.studentID + " in Course " + lastundoneAction.courseID); 
          
         enrollStudent(lastundoneAction.studentID, lastundoneAction.courseID,false);// Enroll the student again
         
    }else if (lastundoneAction.type.equals("REMOVE")){
            System.out.println("Redo: Removing enrollment of Student " + lastundoneAction.studentID + " from Course " + lastundoneAction.courseID);
            removeEnroll(lastundoneAction.studentID, lastundoneAction.courseID,false );            // Remove the student from the course again

    }
   
      undostack.push(lastundoneAction);  // Put this action back in the undo stack
    } else {
        System.out.println("No actions to redo.");
    }
        
    }

    public void sortCoursesByID(int studentID) {
        studentNode student = students.findStudentNode(studentID);
        if (student != null) {
            student.coursat.sortByID();
            System.out.println("Courses for student " + studentID + " sorted.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public void sortStudentsByID(int courseID) {
        courseNode course = courses.findCourseNode(courseID);
        if (course != null) {
            course.studentat.sortByID();
            System.out.println("Students in course " + courseID + " sorted.");
        } else {
            System.out.println("Course not found.");
        }
    }
    public void listCoursesByStudent(int studentID){
        //find the student in list
        studentNode student = students.findStudentNode(studentID); 
        if (student == null){
            System.out.println("Student "+studentID+" not found");
            return;
        }
        student.coursat.sortByID(); // sort courses first
        System.out.println("Student's courses "+studentID+":");
        enrolledcourseNode tmp = student.coursat.getHead(); //start with the first course 
        if (tmp == null){
            System.out.println(" no courses enrolled");
            return;
        } //move on list and print each course
        while (tmp != null){
            System.out.println("Course ID:"+ tmp.courseID);
            tmp = tmp.next;
        }
    }
    public void listStudentsByCourse(int courseID){
        courseNode course = courses.findCourseNode(courseID); //find course in list
        if (course == null){
            System.out.println("Course "+courseID+" not found");
            return;
        }
        course.studentat.sortByID(); // sort students first
        System.out.println("Students in course "+courseID+":");
        enrolledstudentnode tmp2 = course.studentat.getHead(); //start with first student in list 
        if (tmp2 == null){
            System.out.println(" no students enrolled");
            return;
        } //move on list and print each student
        while (tmp2 != null){
            System.out.println("Student ID:"+ tmp2.studentID);
            tmp2 = tmp2.next;
        }
    }
    public void isfullcourse(int courseID){
        int count=0;
        courseNode course = courses.findCourseNode(courseID); // Find the course first
    if (course == null) {
        System.out.println("Course " + courseID + " not found.");
        return;
    }
        enrolledstudentnode tmp = course.studentat.getHead();;
        while (tmp!=null){
            count ++;
        tmp= tmp.next;
        }
        if (count < 20){
            System.out.println("Course " + courseID + " is not valid. students=(" + count + "). Minimum is 20.");
        }
        else if(count<30){
            System.out.println("Course " + courseID + " is valid and can accept more students. student count: " + count);  
        }
        else if(count==30){
            System.out.println("Course " + courseID + " is full. No more students can be added.");
    
        }else{
                System.out.println("Error: Course " + courseID + " has more than 30 students count: " + count+"maximum is 30.");
        }
    }  
    public void isnormalstudent(int courseID) {
        courseNode course = courses.findCourseNode(courseID);
    if (course == null) {
        System.out.println("Course " + courseID + " not found.");
        return;
    }
    int enrolledStudentsCount = 0;
    studentNode currentStudent = students.getHead();
    
    while (currentStudent != null) {enrolledcourseNode currentCourse = currentStudent.coursat.getHead();
        while (currentCourse != null) {
            if (currentCourse.courseID == courseID) {
                enrolledStudentsCount++;
                break;
            }
            currentCourse = currentCourse.next;
        }
        currentStudent = currentStudent.next;
    }
     if (enrolledStudentsCount >= 2 && enrolledStudentsCount <= 7) {
        System.out.println("Course " + courseID + " has a normal number of enrolled students: " + enrolledStudentsCount);
    } else {
        System.out.println("Course " + courseID + " does not have a normal number of enrolled students. Currently: " + enrolledStudentsCount);
    }
}
    }


public class UMS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UniversitySystem system = new UniversitySystem();
 System.out.println("Welcome to University Management System");
System.out.println("1. Add Student");
 System.out.println("2. Remove Student");
  System.out.println("3. Add Course");
  System.out.println("4. Remove Course");
   System.out.println("5. get last student added");
   System.out.println("6. get last course added");
  System.out.println("7. Enroll student in course");
System.out.println("8. Display student's courses");
  System.out.println("9. Display course's students");
  System.out.println("10. Undo last action");
  System.out.println("11. Redo last undone action ");
  System.out.println("12. Check if course is full");
  System.out.println("13. Check if course has a normal number of enrolled students");
  System.out.println("14. Exit");
        while (true) {
   System.out.print("Choose an option: ");
  int choice = input.nextInt();
switch (choice) {
    case 1:
      System.out.print("Enter student ID: ");
      int studentID = input.nextInt();
      system.students.addStudent(studentID);
                    break;
   case 2:
     System.out.print("Enter student ID: ");
     studentID = input.nextInt();
     system.students.removeStudent(studentID);
                    break;    
    case 3:
     System.out.print("Enter course ID: ");
     int courseID = input.nextInt();
    system.courses.addCourse(courseID);
                    break;       
     case 4:
     System.out.print("Enter course ID: ");
     courseID = input.nextInt();
     system.courses.removeCourse(courseID);
              break; 
     case 5:
         int lastStudentID = system.students.getLastStudent();
         if (lastStudentID != -1)
              System.out.println("Last student ID added: "+ lastStudentID);
        else 
             System.out.println("no students in the system");
          break;   
     case 6:
         int lastCourseID = system.courses.getLastCourse();
         if (lastCourseID != -1)
             System.out.println("Last courseID added: "+ lastCourseID);
         else
            System.out.println("no courses in the system");
           break;
      case 7:
       System.out.print("Enter student ID: ");
       studentID = input.nextInt();
       System.out.print("Enter course ID: ");
       courseID = input.nextInt();
       system.enrollStudent(studentID, courseID,true);
                    break;
      case 8:
        System.out.println("Enter student ID:");
        studentID = input.nextInt();
        system.listCoursesByStudent(studentID);
           break;
      case 9:
        System.out.println("Enter course ID:");
        courseID = input.nextInt();
        system.listStudentsByCourse(courseID);
          break;
            case 10 :
           system.undo();
        break;
      case 11:
            system.redo();
        break;
      case 12:
        System.out.print("Enter course ID: ");
        courseID = input.nextInt();
        system.isfullcourse(courseID);
        break;
      case 13:
        System.out.print("Enter course ID: ");
        courseID = input.nextInt();
        system.isnormalstudent(courseID);  
        break;
    case 14:
         System.out.println("Exiting...");
        return;
         default:
           System.out.println("Invalid option. Try again.");
           }
        }
    }
}
