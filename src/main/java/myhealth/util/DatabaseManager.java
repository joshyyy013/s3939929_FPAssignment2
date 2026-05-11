package myhealth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;
    private static final String URL = "jdbc:sqlite:myhealth.db";

    private DatabaseManager() {
        connect();
        createTables();
    }

    public static DatabaseManager getInstance(){
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Database connected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        String usersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE,
                    password TEXT,
                    first_name TEXT,
                    last_name TEXT
                    );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(usersTable);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
