package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionNedjar;
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
            Connection conn = ConnexionNedjar.getInstance().getConnection();
            Statement etat = conn.createStatement();
            ArrayList liste = new ArrayList();
            ResultSet rset = etat.executeQuery("SELECT * FROM PROF PR,MODULE MO " +
                    "WHERE MO.CODE = PR.MAT_SPEC");


            while (rset.next()) {

                Prof prof = new Prof();
                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setAdrProf(rset.getString("ADR_PROF"));
                prof.setCpProf(rset.getString("CP_PROF"));
                prof.setVilleProf(rset.getString("VILLE_PROF"));
                Module module = new Module();
                module.setCode(rset.getString("CODE"));
                module.setLibelle(rset.getString("LIBELLE"));

                prof.setMatSpec(module);
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
