package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAO;
import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExempleDAOEtudiant {


    public static void main(String[] args) {

        DAOEtudiant dao = new DAOEtudiantJDBC();
        Etudiant e = new Etudiant();
        e.setNomEt("SOUTIF");
        e.setPrenomEt("THOMAS");
        e.setCpEt("13100");
        e.setVilleEt("Aix en Provence");
        e.setAnnee(2);
        e.setGroupe(3);

        e = dao.insert(e);

        System.out.println(e.toString());

    }

}
