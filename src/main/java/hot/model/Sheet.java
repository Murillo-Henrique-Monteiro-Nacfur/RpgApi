package hot.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Sheet implements Serializable  {

    public Sheet() {
    }

    public Sheet(long sheetId, String name, int maxHealthPoints, int currentHealthPoints, int maxEnergyPoints, int currentEnergyPoints, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charism, User sheetUser, Match match) {

        this.sheetId = sheetId;
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
        this.sheetUser = sheetUser;
        this.match = match;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sheetId;

    @NonNull
    private String  name;
    private int     maxHealthPoints;
    private int     currentHealthPoints;
    private int     maxEnergyPoints;
    private int     currentEnergyPoints;
    private int     strength;
    private int     dexterity;
    private int     constitution;
    private int     intelligence;
    private int     wisdom;
    private int     charism;

    @ManyToOne
    @JoinColumn(name = "sheet_user_id")
    private User sheetUser;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "match_match_id")//@JoinTable(name = "Sheet_in_Match",joinColumns = @JoinColumn(name = "Sheet_in_Match_sheet_id"),inverseJoinColumns = @JoinColumn(name = "Sheet_in_Match_match_id"))
    private Match match;

    public long getSheetId() {
        return sheetId;
    }

    public void setSheetId(long sheetId) {
        this.sheetId = sheetId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getCharism() {
        return charism;
    }

    public void setCharism(int charism) {
        this.charism = charism;
    }

    public User getSheetUser() {
        return sheetUser;
    }

    public void setSheetUser(User sheetUser) {
        this.sheetUser = sheetUser;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public int getMaxEnergyPoints() {
        return maxEnergyPoints;
    }

    public void setMaxEnergyPoints(int maxEnergyPoints) {
        this.maxEnergyPoints = maxEnergyPoints;
    }

    public int getCurrentEnergyPoints() {
        return currentEnergyPoints;
    }

    public void setCurrentEnergyPoints(int currentEnergyPoints) {
        this.currentEnergyPoints = currentEnergyPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AbstractEntity that = (AbstractEntity) o;
            return sheetId == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sheetId);
        }

}

