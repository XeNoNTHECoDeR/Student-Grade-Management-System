import java.sql.*;

public class DatabaseManager {
    private Connection conn;

    public DatabaseManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "your_password_here");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveStudent(Student student) {
        try {
            String query = "INSERT INTO students (name, marks, grade) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, student.getName());
            pst.setInt(2, student.getMarks());
            pst.setString(3, student.getGrade());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllStudents() {
        try {
            String query = "SELECT * FROM students";
            Statement st = conn.createStatement();
            return st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
