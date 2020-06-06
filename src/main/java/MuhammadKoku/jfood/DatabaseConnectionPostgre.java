package MuhammadKoku.jfood;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionPostgre {
    protected static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://ec2-34-197-141-7.compute-1.amazonaws.com:5432/d7op1ucac22oin", "lcfimrcbqkmbyv", "10985f701fde797b3f3522d2eebf289444e0c79f71f450fed5290febf1a3e6c7");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
