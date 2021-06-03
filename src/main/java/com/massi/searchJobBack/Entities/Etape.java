package com.massi.searchJobBack.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Etape {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titre;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Date date;

    public Etape(){}

    public Etape(String titre, String description, Date date) {
        this.titre = titre;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
