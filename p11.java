import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class p11 {
    static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String username = "root";
    static final String password = "root";

    public static void main(String args[]) {

        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement()) {
            int deleteId = 1;
            String sql = "delete from employee where eno=" + deleteId + "";
            int rowsaffected = statement.executeUpdate(sql);
            if (rowsaffected >= 1) {
                System.out.println("record with id " + (deleteId) + " deleted succefully");
            } else {
                System.out.println("failed to delete record");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
