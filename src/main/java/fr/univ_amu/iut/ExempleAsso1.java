package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExempleAsso1 {

    public static void main(String[] args) {

        try {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();
            ArrayList liste = new ArrayList();
            ResultSet rset = etat.executeQuery("SELECT * FROM PROF");
            ResultSet rset_module;

            while (rset.next()) {

                Prof prof = new Prof( , ,, , , new Module());
                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setAdrProf(rset.getString("ADR_PROF"));
                prof.setCpProf(rset.getString("CP_PROF"));
                prof.setVilleProf(rset.getString("VILLE_PROF"));




            }

            rset_module = etat.executeQuery("SELECT * " +
                    "FROM MODULE MO "+
                    "WHERE MO.CODE = "+ "\"" + rset.getString("MAT_SPEC") + "\"");

            liste.add(prof);

            for (int i = 0; i < liste.size(); i++)
                System.out.println(liste.get(i).toString());

        } catch (SQLException e) {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }


    }
}
