package com.massi.searchJobBack.Entities;


import com.massi.searchJobBack.Entities.Enums.CandidatureSource;
import com.massi.searchJobBack.Entities.Enums.CandidatureStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titreOffre;

    private String companyName;
    @Lob
    @Column( length = 100000 )
    private String url;
    @Column(columnDefinition = "TEXT")
    private String contain;
    private Date annonceDate;
    private Date candidatureDate;
    private String lieu;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Etape> etapes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private CandidatureSource candidatureSouce;

    @Enumerated(EnumType.STRING)
    private CandidatureStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public Date getAnnonceDate() {
        return annonceDate;
    }

    public void setAnnonceDate(Date annonceDate) {
        this.annonceDate = annonceDate;
    }

    public Date getCandidatureDate() {
        return candidatureDate;
    }

    public void setCandidatureDate(Date candidatureDate) {
        this.candidatureDate = candidatureDate;
    }

    public CandidatureSource getCandidatureSouce() {
        return candidatureSouce;
    }

    public void setCandidatureSouce(CandidatureSource candidatureSouce) {
        this.candidatureSouce = candidatureSouce;
    }

    public CandidatureStatus getStatus() {
        return status;
    }

    public void setStatus(CandidatureStatus status) {
        this.status = status;
    }

    public String getTitreOffre() {
        return titreOffre;
    }

    public void setTitreOffre(String titreOffre) {
        this.titreOffre = titreOffre;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public void addEtape(Etape etape) {
        this.etapes.add(etape);
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
