package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ExempleEntite {



    public static void main(String[] args) {

        try
        {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();
            ArrayList liste = new ArrayList();
            ResultSet rset = etat.executeQuery("SELECT * FROM ETUDIANT");

            while (rset.next()){

                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setGroupe(rset.getInt("GROUPE"));


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
