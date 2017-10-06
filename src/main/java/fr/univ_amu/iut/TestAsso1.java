package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestAsso1 {

    public static void main(String[] args) {

        try {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();
            ArrayList liste = new ArrayList();
            ResultSet rset = etat.executeQuery("SELECT * FROM PROF");

            while (rset.next()) {

                Prof prof = new Prof(rset.getInt("NUM_PROF"), rset.getString("NOM_PROF"), rset.getString("PRENOM_PROF"),rset.getString("ADR_PROF"), rset.getString("CP_PROF"), rset.getString("VILLE_PROF"), new Module());
                liste.add(prof);

            }

            for (int i = 0; i < liste.size(); i++)
                System.out.println(liste.get(i).toString());

        } catch (SQLException e) {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }


    }
}
