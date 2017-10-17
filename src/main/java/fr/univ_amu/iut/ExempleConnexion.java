package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionUnique;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExempleConnexion {


    public static void main(String[] args) {

        try
        {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            Statement etat = conn.createStatement();
            etat.close();
        }
        catch (SQLException e)
        {
            System.out.println("Erreur main");
            System.out.println(e.getMessage() + "\n");
        }








    }




}
