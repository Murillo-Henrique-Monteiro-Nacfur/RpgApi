package rpgtcc.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Game")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Column(unique=true, nullable=false)
    private  String name;
    private char status;
    private Date dateCriacao;
    private Integer pin;

    @ManyToOne
    @JoinColumn(name = "match_user_id")
    private User matchUser;

    @JsonManagedReference
    @OneToMany(mappedBy = "match",cascade = CascadeType.PERSIST)
    private List<Sheet> sheets;

    public Match() {
    }

    public Match(String name, char status, Date dateCriacao, Integer pin, User matchUser, List<Sheet> sheets) {
        this.name = name;
        this.status = status;
        this.dateCriacao = dateCriacao;
        this.pin = pin;
        this.matchUser = matchUser;
        this.sheets = sheets;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public Date getDateCriacao() {
        return dateCriacao;
    }

    public void setDateCriacao(Date dateCriacao) {
        this.dateCriacao = dateCriacao;
    }

    public User getMatchUser() { return matchUser; }

    public void setMatchUser(User matchUser) { this.matchUser = matchUser; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Integer getPin() { return pin; }

    public void setPin(Integer pin) { this.pin = pin; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return matchId == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId);
    }
}
