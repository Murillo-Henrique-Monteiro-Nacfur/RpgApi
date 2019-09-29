package rpgtcc.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Sheet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String  name;
    private Integer maxHealthPoints;
    private Integer currentHealthPoints;
    private Integer maxEnergyPoints;
    private Integer currentEnergyPoints;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charism;
    private Integer gold;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    public Sheet() {
    }

    public Sheet(@NonNull String name, Integer maxHealthPoints, Integer currentHealthPoints, Integer maxEnergyPoints, Integer currentEnergyPoints, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charism, Integer gold, User user, Match match) {
        this.name = name;
        this.maxHealthPoints = maxHealthPoints;
        this.currentHealthPoints = currentHealthPoints;
        this.maxEnergyPoints = maxEnergyPoints;
        this.currentEnergyPoints = currentEnergyPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charism = charism;
        this.gold = gold;
        this.user = user;
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long sheetId) {
        this.id = sheetId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getCharism() {
        return charism;
    }

    public void setCharism(Integer charism) {
        this.charism = charism;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(Integer maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public Integer getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(Integer currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public Integer getMaxEnergyPoints() {
        return maxEnergyPoints;
    }

    public void setMaxEnergyPoints(Integer maxEnergyPoints) {
        this.maxEnergyPoints = maxEnergyPoints;
    }

    public Integer getCurrentEnergyPoints() {
        return currentEnergyPoints;
    }

    public void setCurrentEnergyPoints(Integer currentEnergyPoints) {
        this.currentEnergyPoints = currentEnergyPoints;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getGold() { return gold; }

    public void setGold(Integer gold) { this.gold = gold; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheet sheet = (Sheet) o;
        return Objects.equals(id, sheet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

