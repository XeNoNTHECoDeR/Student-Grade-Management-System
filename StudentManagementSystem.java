import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();

        JFrame frame = new JFrame("Student Grade Management");

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(20, 30, 120, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(140, 30, 150, 25);

        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(20, 70, 120, 25);
        JTextField marksField = new JTextField();
        marksField.setBounds(140, 70, 150, 25);

        JButton calcBtn = new JButton("Save and Calculate Grade");
        calcBtn.setBounds(70, 110, 200, 30);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 160, 280, 150);
        resultArea.setEditable(false);

        calcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int marks = Integer.parseInt(marksField.getText());

                Student student = new Student(name, marks);
                db.saveStudent(student);
                resultArea.setText("Student Saved!\nName: " + name +
                    "\nMarks: " + marks + "\nGrade: " + student.getGrade());

                // Show all students
                try {
                    ResultSet rs = db.getAllStudents();
                    resultArea.append("\n\n--- All Records ---\n");
                    while (rs.next()) {
                        resultArea.append("Name: " + rs.getString("name") +
                                ", Marks: " + rs.getInt("marks") +
                                ", Grade: " + rs.getString("grade") + "\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.add(nameLabel); frame.add(nameField);
        frame.add(marksLabel); frame.add(marksField);
        frame.add(calcBtn); frame.add(resultArea);

        frame.setSize(350, 380);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
