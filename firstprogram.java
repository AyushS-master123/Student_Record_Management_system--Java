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
    public Student getStudentInfoById(int id){
        return students.get(id);
    }
    public void updateStudentInfo(Student s){
        students.put(s.getId(),s);
    }
    public void deleteStudentInfo(int id){
        students.remove(id);
    }
    public List<Student> getAllStudentInfo(){
        return new ArrayList<>(students.values());
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
            System.out.println("Hit the key 'q' to exit");
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
                case "2":
                    System.out.println("Provide the student id");
                    int num=sc.nextInt();
                    Student existingStudent=db.getStudentInfoById(num);
                    if(existingStudent!=null){
                        System.out.println("Enter student name");
                        String updatedname=sc.next();
                        System.out.println("Enter student age");
                        int updatedage=sc.nextInt();
                        System.out.println("Enter student grade");
                        int updatedgrade=sc.nextInt();
                        Student updatedStudent=new Student(num, updatedname, updatedage, updatedgrade);
                        db.updateStudentInfo(updatedStudent);
                        System.out.println("Student details updated sucessfully!");
                    }
                    else{
                        System.out.println("Student details not found");
                    }
                    break;
                case "3":
                    System.out.println("Provide the student id");
                    int num1=sc.nextInt();
                    db.deleteStudentInfo(num1);
                    System.out.println("Student info has been deleted.");
                    break;
                case "4":
                    System.out.println("Provide the student id");
                    int num2=sc.nextInt();
                    Student existingStudent1=db.getStudentInfoById(num2);
                    if(existingStudent1!=null){
                        existingStudent1.displayStudentDetails();
                    }
                    else{
                        System.out.println("We cant display student info");
                    }
                    break;
                case "5":
                    List<Student> allStudents=db.getAllStudentInfo();
                    for(Student s:allStudents){
                        s.displayStudentDetails();
                        System.out.println();
                    }
                    break;
                case "q":
                    System.out.println("Exit the program");
                    System.exit(0);
                    break;
            }
        }
    }
}