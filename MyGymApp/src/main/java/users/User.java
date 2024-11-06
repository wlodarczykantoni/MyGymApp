package users;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private LocalDate signupDate;
    private boolean isAdmin;


    public User() {}


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    }


    public User(String username, String password, LocalDate signupDate) {
        this.username = username;
        this.password = password;
        this.signupDate = signupDate;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getSignupDate() {
        return signupDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSignupDate(LocalDate signupDate) {
        this.signupDate = signupDate;
    }
    public void setAdmin(boolean isAdmin) { // Setter dla isAdmin
        this.isAdmin = isAdmin;
    }
    public boolean isAdmin() { // Getter dla isAdmin
        return isAdmin;
    }

    @Override
    public String toString() {
        return "Użytkownik [" + id + "] ma login: " + username;
    }
}
