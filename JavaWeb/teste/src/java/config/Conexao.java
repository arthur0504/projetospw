package config;
import java.sql.*;
public class Conexao {
    public Connection conectar() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/teste?user=root&password=");
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
