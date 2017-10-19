package fr.univ_amu.iut.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique
{
    private Connection connection;
    private  static ConnexionUnique instance = null;
    private static String connect_url;
    private static String login;
    private static String password;

    protected ConnexionUnique()
    {
        connect_url = "jdbc:mysql://localhost:3306/gestion_peda";
        login = "root";
        password = "root";
        try
        {
            System.out.println("Connexion à " + connect_url );
            connection = DriverManager.getConnection(connect_url, login, password);
            System.out.println("Connecté.");

        }
        catch (SQLException e)
        {
            System.out.println("Connexion impossible pour l'utilisateur "+ login + "sur la base de donnée " + connect_url + " Veuillez vérifier vos identifiants.");
            System.out.println(e.getMessage() + "\n");

        }
    }

    public Connection getConnection()
    {

        return connection;
    }

    public static ConnexionUnique getInstance()
    {

        if(instance == null)
            instance = new ConnexionUnique();

        return instance;
    }

}



