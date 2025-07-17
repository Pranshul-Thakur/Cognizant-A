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
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    public static void main(String[] args) {
        MVCPatternExample app = new MVCPatternExample();

        Student student = app.new Student("Alice", "101", "A");
        StudentView view = app.new StudentView();
        StudentController controller = app.new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Alice Sharma");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}