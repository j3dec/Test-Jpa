package main.java;

import main.java.Dao.Dao;

public class TestBibliotheque {
    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.init();
        dao.finEmpruntLivres(2);
        dao.close();

    }
}
