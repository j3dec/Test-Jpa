package main.java;

import main.java.models.Livre;

import java.util.List;

public class TestJpa {
    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.init();
        Livre l = dao.findLivre(5);
        System.out.println(l.getId());
        System.out.println(l.getAuteur());
        System.out.println(l.getTitre());
        l.setTitre("Du plaisir dans la cuisine");

//        Livre l2 = new Livre();
//        l2.setId(19L);
//        l2.setTitre("Mefkepfe");
//        l2.setAuteur("Fff");
//        dao.addLivre(l2);

        List<Livre> a = dao.findAllLivres();
        System.out.println(a.toString());
        dao.close();


    }



}
