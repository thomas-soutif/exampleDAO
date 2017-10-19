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
import java.util.List;

public class ExempleDAOEtudiant {


    public static void main(String[] args) {

        DAOEtudiant dao = new DAOEtudiantJDBC();
        Etudiant e = new Etudiant();
        e.setNomEt("SOUTIF");
        e.setPrenomEt("THOMAS");
        e.setCpEt("13100");
        e.setVilleEt("Paris");
        e.setGroupe(3);
        e.setAnnee(2);
        //e = dao.insert(e);

        System.out.println(e.toString());

        e.setVilleEt("Aix en Provence");

       boolean updateOk = dao.update(e);
        if(!updateOk)
        {
            System.out.println("Mise à jour échoué.");
        }

       e = dao.getById(e.getNumEt());

        System.out.println(e.toString());

        List<Etudiant> l = dao.findAll();

        for(Etudiant et : l)
            System.out.println(et.toString());

        l = dao.findByGroupe(2);

        for(Etudiant et : l)
            System.out.println(et.toString());


        System.out.println(dao.computeNbEtudiant());



    }

}
