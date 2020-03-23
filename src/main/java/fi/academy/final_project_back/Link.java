package fi.academy.final_project_back;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "links_id_seq")
    @SequenceGenerator(name = "links_id_seq",
            sequenceName = "links_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String link;
    private String description;
    private int week;

    public Link() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
