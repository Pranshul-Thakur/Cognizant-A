public class MVCPatternExample {

    class Student {
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    class StudentView {
        public void displayStudentDetails(String name, String id, String grade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    class StudentController {
        private Student student;
        private StudentView view;

        public StudentController(Student student, StudentView view) {
            this.student = student;
            this.view = view;
        }

        public void setStudentName(String name) {
            student.setName(name);
        }

        public void setStudentGrade(String grade) {
            student.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
        }
    }

    public static void main(String[] args) {
        MVCPatternExample app = new MVCPatternExample();

        Student student = app.new Student("Rahul", "S101", "B+");
        StudentView view = app.new StudentView();
        StudentController controller = app.new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Rahul Verma");
        controller.setStudentGrade("A");

        controller.updateView();
    }
}