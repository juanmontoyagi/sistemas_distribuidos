package proyecto_tienda_distribuidos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexionDataBase {
	
	static final String URL = "jdbc:postgresql://localhost:5432/base_datos_tienda";
    static final String USER = "postgres";
    static final String PASS = "admin";
    static Statement sentencia = null;
    static Connection conexion = null;

    public static Connection crearConexion() throws ClassNotFoundException, SQLException{
    Class.forName("org.postgresql.Driver");
    conexion = DriverManager.getConnection(URL, USER, PASS);
    if (conexion != null){
    System.out.print("Conexion establecida...");
    sentencia = conexion.createStatement();

    return conexion;
    }
    return null;
    }

    public static void cerrarConexion() {
        conexion = null;
        if(sentencia!=null) {
            try {
                sentencia.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        if(conexion!=null) {
            try {
                conexion.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();

            }
        }
    }

}
