package main.java.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Livre")
@Table(name="Livre")

public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "auteur")
    private String auteur;
    @Column (name = "titre")
    private String titre;

    @Id
    @GeneratedValue
    @Column(name = "id_liv")
    public int getId() {
        return id;
    }

    public Livre() {
    }

    // Getters & setters
//    public int getId() {
//        return id;
//    }
    public void setId(int id) {
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
