package BD;

import java.sql.*;

public class BDconnect {
    private String url = "jdb: mysql://localhost:3307/senac";
    private String user = "aluno";
    private String password = "senac";
    private Connection conn;


public boolean conectaDB() {
    try{
        //Carregar o driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Estabelecer a conexão
        this.conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
            return true;
}

public boolean encerrarConexao() {
    try {
        this.conn.close();    
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}

public PreparedStatement getPreparedStatement (String query) {
    try {
        return this.conn.prepareStatement(query);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return null;
 }
}
