package config;

import java.sql.Connection;

public class PruebaConexion {

    public static void main(String[] args) {
        Connection con = Conexion.getConnection();
        if (con != null) {
            System.out.println("CONEXION EXITOSA A PANLOGIC_DB");
        } else {
            System.out.println("FALLO LA CONEXION");
        }
    }
}