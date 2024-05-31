package com.example.lab7_20202137.daos;

import com.example.lab7_20202137.beans.Peliculas;

import java.sql.*;
import java.util.ArrayList;

public class peliDao {
    public ArrayList<Peliculas> obtnerListaPelis(){
        ArrayList<Peliculas> listaPelis = new ArrayList<>();

        try{
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM peli");

            while (rs.next()) {
                Peliculas peli = new Peliculas();
                peli.setIdPelicula(rs.getInt(1));
                peli.setTitulo(rs.getString(2));
                peli.setDirector(rs.getString(3));
                peli.setAnoPublicacion(rs.getInt(4));
                peli.setRating(rs.getDouble(5));
                peli.setBoxOffice(rs.getDouble(6));
                peli.setGenero(rs.getString(7));

                listaPelis.add(peli);
            }

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return listaPelis;
    }
}
