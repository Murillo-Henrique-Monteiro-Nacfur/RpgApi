package rpgtcc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name="match_table")
public class Match{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private  String name;
    private Integer pin;
    private Boolean chatAvailable;
    private String secret;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "match",cascade = CascadeType.PERSIST)
    private List<Sheet> sheets;

    public Match() {
    }

    public Match(String name, Integer pin, Boolean chatAvailable, User user, List<Sheet> sheets) {
        this.name = name;
        this.pin = pin;
        this.chatAvailable = chatAvailable;
        this.user = user;
        this.sheets = sheets;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPin() { return pin; }

    public void setPin(Integer pin) { this.pin = pin; }

    public Boolean isChatAvailable() {
        return chatAvailable;
    }

    public void setChatAvailable(Boolean chatAvailable) {
        this.chatAvailable = chatAvailable;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return id.equals(match.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
