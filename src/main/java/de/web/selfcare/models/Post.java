package de.web.selfcare.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titel;
    private LocalDate datum;
    private String beschreibung;
    private String bild;
    private String meditation;
    private String sport;
    private String schlaf;
    private boolean skincare;

    public Long getId() {
        return id;
    }
    public String getTitel() {
        return titel;
    }
    public LocalDate getDatum() {
        return datum;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public String getBild() {
        return bild;
    }
    public String getMeditation() {
        return meditation;
    }
    public String getSport() {
        return sport;
    }
    public String getSchlaf() {
        return schlaf;
    }
    public boolean getSkincare() {
        return skincare;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public void setBild(String bild) {
        this.bild = bild;
    }
    public void setMeditation(String meditation) {
        this.meditation = meditation;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }
    public void setSchlaf(String schlaf) {
        this.schlaf = schlaf;
    }
    public void setSkincare(boolean skincare) {
        this.skincare = skincare;
    }
}
