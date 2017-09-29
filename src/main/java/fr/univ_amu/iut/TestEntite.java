package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestEntite {



    public static void main(String[] args) {

        try
        {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();
            ArrayList liste = new ArrayList();
            ResultSet rset = etat.executeQuery("SELECT * FROM ETUDIANT");

            while (rset.next()){

                Etudiant etudiant = new Etudiant(rset.getInt("NUM_ET"),rset.getString("NOM_ET"),rset.getString("PRENOM_ET"),rset.getString("CP_ET"),rset.getString("VILLE_ET"),rset.getInt("ANNEE"),rset.getInt("GROUPE"));
                liste.add(etudiant);

            }

            for(int i = 0; i < liste.size(); i++)
                System.out.println(liste.get(i).toString());

        }
        catch (SQLException e)
        {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }








    }









}
