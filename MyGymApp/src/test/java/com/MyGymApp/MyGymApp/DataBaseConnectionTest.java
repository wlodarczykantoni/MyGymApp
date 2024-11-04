package com.MyGymApp.MyGymApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//sprawdzenie czy baza danych jest polaczona z serwerem
public class DataBaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection, "Połączenie z bazą danych nie może być null");
            System.out.println("Połączenie z bazą danych zostało nawiązane pomyślnie.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AssertionError("Błąd podczas próby połączenia z bazą danych", e);
        }
    }
}
