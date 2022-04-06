package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userid", unique = true)
    private int id;

    @Column(name = "user", nullable = false, unique = true)
    private String user;

    @Column(name = "password", nullable = false)
    private String pass;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "type", nullable = false)
    private Integer type;



    public User() {
    }


    public User(String user, String pass, String email, Integer type)
    {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
