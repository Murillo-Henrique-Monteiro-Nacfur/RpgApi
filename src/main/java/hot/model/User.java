package hot.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Player")
public class User extends AbstractEntity {

    public User() {
    }

    public User(String name, String password, String email, Date dateaccount, List<Match> matchs, List<Sheet> sheets) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.dateaccount = dateaccount;
        this.matchs = matchs;
        this.sheets = sheets;
    }

    @Column(unique=true, nullable=false)
    private    String name;



    @Column(unique=true, nullable=false)
    private    String password;

    @Column(unique=true, nullable=false)
    private    String email;

    private    Date dateaccount;

    @OneToMany(mappedBy = "matchUser",cascade = CascadeType.PERSIST) // .ALL
    private List<Match> matchs;// @JoinColumn(name = "user_id")


    @OneToMany(mappedBy = "sheetUser",cascade = CascadeType.PERSIST) // .ALL
    private List<Sheet> sheets;
// @JoinColumn(name = "user_id")

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

    public Date getDateAccount() {
        return dateaccount;
    }

    public void setDateAccount(Date dateAccount) {
        this.dateaccount = dateAccount;
    }
}
