package dbSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectSample03 {

    public static void main(String[] args) {
        // データベース接続と結果取得のための変数
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // 1. ドライバーのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. DBと接続する
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "L_sMyll321pP"
                    );
            // 3. DBとやりとりする窓口（Statementオブジェクト）の作成
            stmt = con.createStatement();
            // 4, 5. Select文の実行と結果を格納／代入
            System.out.println("検索キーワードを入力してください > ");
            String input = keyIn();
            
            String sql = "SELECT * FROM country where Name = '" + input + "'";
            rs = stmt.executeQuery(sql);
            // 6. 結果を表示する
            while( rs.next() ){
                // Name列の値を取得
                String name = rs.getString("Name");
            // Population列の値を取得
                int population = rs.getInt("Population");
                // 取得した値を表示
                System.out.print("国名：" + name + "人口：");
                System.out.println(population);
            }
            //データ更新
            sql = "update country set Population = 105000 where Code = 'ABW'";
            
        } catch (ClassNotFoundException e) {
            System.err.println("JDBCドライバーのダウンロードに失敗しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        } finally { 
            // 7. 接続を閉じる
            if( rs != null ){
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
            if( stmt != null ){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Statementを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("データベース切断時にエラーが発生しました。");
                    e.printStackTrace();
                }
            }
        }
    }
    public static String keyIn() {
        String line = null;
        try {
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            line = key.readLine();
        } catch(IOException e) {
            
        }
        return line;
    }
    
}
