package main.java.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Emprunt")

public class Emprunt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column (name = "date_debut", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date_debut;

    private int delai;

    @Column(name = "date_fin", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date_fin;


    @ManyToOne
    @JoinColumn (name = "ID_CLIENT")
    private Client clientE;

    @Id
    @GeneratedValue
    @Column(name = "id_emp")
    public int getId() {
        return id;
    }
    private Set<Livre> livres;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Compo",
            joinColumns = @JoinColumn (
                    name = "id_emp"),
            inverseJoinColumns = @JoinColumn(name = "id_liv")
    )


    public Set<Livre> getLivres() {
        return livres;
    }

    public Emprunt() {
    }

    // Getters & setters
        public void setId(int id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
