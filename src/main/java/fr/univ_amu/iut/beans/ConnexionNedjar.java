package fr.univ_amu.iut.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionNedjar
{
    private Connection connection;
    private  static ConnexionNedjar instance = null;
    private static String connect_url;
    private static String login;
    private static String password;

    protected ConnexionNedjar()
    {
        connect_url = "jdbc:mysql://mysql-nedseb.alwaysdata.net:3306/nedseb_gestionpedabd";
        login = "nedseb_user";
        password = "1234";
        try
        {
            connection = DriverManager.getConnection(connect_url, login, password);
            System.out.println("Connecté.");

        }
        catch (SQLException e)
        {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");

        }
    }

    public Connection getConnection()
    {

        return connection;
    }

    public static ConnexionNedjar getInstance()
    {

        if(instance == null)
            instance = new ConnexionNedjar();

        return instance;
    }

}



