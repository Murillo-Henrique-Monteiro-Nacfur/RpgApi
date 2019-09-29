package rpgtcc.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private    String name;

    @Column(unique=true, nullable=false)
    private    String password;

    @Column(unique=true, nullable=false)
    private    String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Match> matchs;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Sheet> sheets;

    public User() {
    }

    public User(String name, String password, String email, List<Match> matchs, List<Sheet> sheets) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.matchs = matchs;
        this.sheets = sheets;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }
}
