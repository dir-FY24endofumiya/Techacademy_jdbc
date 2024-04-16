package dbSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // データベース接続と結果取得のための変数
    private static Connection con;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        //ドライバのクラスをJAVA上で読み込む
        Class.forName("com.mysql.cj.jdbc.Driver");
        //DBと接続
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "L_sMyll321pP"
                );
        
        return con;
        
    }
    public static void close() {
        //接続を閉じる
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
