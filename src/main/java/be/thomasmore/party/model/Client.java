package be.thomasmore.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private Integer id;
    private String name;
    private String birthDate;
    private String gender;
    private String startDate;

    public Client() {
    }

    public Client(String name, String birthDate, String gender, String startDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.setGender(gender);
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = "U";
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
