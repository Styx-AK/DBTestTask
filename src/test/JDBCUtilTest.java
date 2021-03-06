import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilTest {
    private static final String URL = "jdbc:postgresql://localhost:5432/testtask_db";
    private static final String USERNAME = "postgres"; //"test_user"; --for mac || "postgres" --for win
    private static final String PASSWORD = "postgres"; //"testpass"; --for mac || "postgres" --for win

    public static void main(String[] args) {


        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to database successfully");

            connection.close();
            System.out.println("Connected to database have been closed successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
