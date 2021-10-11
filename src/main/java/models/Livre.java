package main.java.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Livre")
@Table(name="Livre")

public class Livre implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name = "auteur")
    private String auteur;
    @Column (name = "titre")
    private String titre;

    public Livre() {
    }

    // Getters & setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String toString() {
        return this.titre + " de " + this.auteur;
    }
}
