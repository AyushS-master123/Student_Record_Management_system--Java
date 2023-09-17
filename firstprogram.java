import java.util.*;
class Student{
    private int id;
    private String name;
    private int age;
    private int grade;
    public Student(int id, String name, int age, int grade){
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getGrade(){
        return grade;
    }
    public void displayStudentDetails(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

}

class StudentDataBase{
    //Integer represents id.
    //Student represent Id,name,age,grade.
    //Integer contains id because it is used to match the id in the database to get the students info.
    //students is the name of the map. You can name the map anything.
    private Map<Integer,Student>students;
    //This is a constructor
    //Constructor is declaring an empty map.
    public StudentDataBase(){
        students=new HashMap<>();//<> is a syntax. The () are empty because we are making a empty map.We are using it because 
        
    }
    public void addStudent(Student s){
        students.put(s.getId(),s);

    }
}


class world{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentDataBase db=new StudentDataBase();
        while(true){
            System.out.println("Welcome student!");
            System.out.println("1: Add a new student");
            System.out.println("2: Update student info");
            System.out.println("3: Delete student info");
            System.out.println("4: Show a particular student info");
            System.out.println("5: Display all of students info");
            System.out.println("Hit the key 'Q' or 'q' to exit");
            String choice=sc.nextLine();
            
            switch(choice){
                case "1":
                System.out.println("Enter student id");
                int id=sc.nextInt();
                System.out.println("Enter student name");
                String name=sc.next();
                System.out.println("Enter student age");
                int age=sc.nextInt();
                System.out.println("Enter student grade");
                int grade=sc.nextInt();
                Student S1=new Student(id, name, age, grade);
                db.addStudent(S1);
                System.out.println("Student details added succesfully");
                break;
            }
        }
    }
}