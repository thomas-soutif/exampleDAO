package fr.univ_amu.iut.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique
{
    private Connection connection;
    private ConnexionUnique instance;
    private String connect_url;
    private String login;
    private String password;

    public ConnexionUnique()
    {
        connect_url = "jdbc:mysql://localhost:3306/gestion_peda";
        login = "lambda";
        password = "1234";
        try ( Connection connection = DriverManager.getConnection(connect_url, login, password))
        {
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

    public ConnexionUnique getInstance()
    {
        instance = new ConnexionUnique();
        return instance;
    }

}



