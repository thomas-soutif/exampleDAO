package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAO;
import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExempleDAOEtudiant {


    public static void main(String[] args) {

        try {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();



        } catch (SQLException e) {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }


    }

}
