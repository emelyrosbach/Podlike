package de.gsohs.bme5.model;
import javax.persistence.*;

@Entity
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PODCAST_ID_GEN")
    @SequenceGenerator(name = "PODCAST_ID_GEN", sequenceName = "PODCAST_ID_SEQ", initialValue = 1)
    private Long podcast_id;

    @Column(length = 10, nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private String description;

    //c
    public Podcast () {}

    //m
    public Long getPodcast_id() {
        return podcast_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setPodcast_id(Long pid) {
        podcast_id = pid;
    }

    public void setTitle(String new_title) {
        title = new_title;
    }

    public void setDescription(String new_description) {
        description = new_description;
    }
}
