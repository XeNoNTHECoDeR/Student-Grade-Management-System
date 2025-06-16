public class Student {
    private String name;
    private int marks;
    private String grade;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }

    private String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "D";
    }
}
