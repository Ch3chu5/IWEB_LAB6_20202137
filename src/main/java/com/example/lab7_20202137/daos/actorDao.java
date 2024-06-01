package com.example.lab7_20202137.daos;

import com.example.lab7_20202137.beans.Actores;

import java.sql.*;
import java.util.ArrayList;


public class actorDao {
    public ArrayList<Actores> obtenerListaActor(){
        ArrayList<Actores> listaActor = new ArrayList<>();

        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM act");

            while (rs.next()) {
                Actores act = new Actores();
                act.setIdActor(rs.getInt(1));
                act.setNombre(rs.getString(2));
                act.setApellido(rs.getString(3));
                act.setAnoNacimiento(rs.getInt(4));
                act.setPremioOscar(rs.getBoolean(5));

                listaActor.add(act);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listaActor;
    }


}
