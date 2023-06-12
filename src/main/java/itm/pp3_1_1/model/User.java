package itm.pp3_1_1.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;

    @Column(name = "first_name")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]+$", message = "Введите только буквы")
    @Size(min = 2, max = 30, message = "Имя должно быть в переделах от 2 до 30")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Email неверный")
    private String email;

    @NotEmpty(message = "Пароль не должен быть пустым")
    @Size(min = 6, max = 30, message = "Пароль должен быть в переделах от 6 до 30")
    private String password;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User [id = %d; firstName = %s; lastName = %s; email = %s; password = %s]",
                id, firstName, lastName, email, password);
    }
}
