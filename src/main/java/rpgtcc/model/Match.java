package rpgtcc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Game")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;

    @Column(unique=true, nullable=false)
    private  String name;

    private char status;
    private Date dateCriacao;

    @ManyToOne
    private User matchUser;

    @ManyToMany(mappedBy = "sheetMatchs")
    private List<Sheet> matchSheets;

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

    public List<Sheet> getMatchSheets() {
        return matchSheets;
    }

    public void setMatchSheets(List<Sheet> matchSheets) {
        this.matchSheets = matchSheets;
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

    public Date getDataCriacao() {
        return dateCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dateCriacao = dataCriacao;
    }




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
