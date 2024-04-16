package dbSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dbSample.dao.CountryDAO;
import dbSample.entity.Country;

public class DbConnectSample06 {

    public static void main(String[] args) {
        CountryDAO dao = new CountryDAO();
        
        // 検索用キーワードを入力
        System.out.print("検索キーワードを入力してください > ");
        String name = keyIn();
        //listに名前を取得
        List<Country> list = dao.getCountryFromName(name);
        //順番に出力
        for(Country item : list){
            System.out.println(item.getName());
            System.out.println(item.getPopulation());
            }
        }
        
        //キーボードから入力された値をStringで返す 引数：なし 戻り値：入力された文字列
        private static String keyIn() {
            String line = null;
            try {
                BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
                line = key.readLine();
            } catch (IOException e) {
                
            }
            return line;
        

    }

}
