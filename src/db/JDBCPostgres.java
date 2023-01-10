package db;
import java.sql.*;
import java.util.ArrayList;

public class JDBCPostgres {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5432/main";
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] argv) {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
    //TODO Write select method and implement singleton pattern for connection. Search for params in query
    public static ArrayList select(String query)
    {
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            ArrayList out = new ArrayList<>();
            while (rs.next()) {
                out.add(rs.getString(2));
                }
            return out;
            }
            catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            }
        return null;
    }
}
