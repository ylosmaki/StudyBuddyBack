package fi.academy.final_project_back;

import javax.persistence.*;

@Entity
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String finnish;
    private String english;
    private String finnish_def;
    private String english_def;

    public Dictionary() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinnish() {
        return finnish;
    }

    public void setFinnish(String finnish) {
        this.finnish = finnish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getFinnish_def() {
        return finnish_def;
    }

    public void setFinnish_def(String finnish_def) {
        this.finnish_def = finnish_def;
    }

    public String getEnglish_def() {
        return english_def;
    }

    public void setEnglish_def(String english_def) {
        this.english_def = english_def;
    }
}
