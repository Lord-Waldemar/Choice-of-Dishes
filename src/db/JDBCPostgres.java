package db;

import java.sql.*;



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

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM dishes");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
    //TODO Write select method and implement singleton pattern for connection. Search for params in query
    public static ResultSet select(String query)
    {
        Statement statement = connection.createStatement();

        statement.execute(query);
    }
}
