import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;

public class p9 {
    static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String username = "root";
    static final String password = "root";

    public static void main(String args[]) {

        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter eno to change");
            int idToChange = scanner.nextInt();
            String sql = "select ename from employee where eno=" + idToChange + "";
            ResultSet res = statement.executeQuery(sql);
            String oldName = "";
            while (res.next()) {
                oldName = res.getString(1);
                System.out.println("current name is " + oldName + "");
            }

            System.out.println("enter new name");
            String newName = scanner.next();
            sql = "update employee set ename='" + newName + "' where eno=" + idToChange + "";
            int res1 = statement.executeUpdate(sql);
            if (res1 > 0) {
                System.out.println("updated ename from " + oldName + " to " + newName + "");
            } else {
                System.out.println("failed to update");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
