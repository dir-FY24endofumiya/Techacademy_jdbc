package dbSample.entity;

public class Country {
    //フィールド
    String name;
    int population;
    
    //引数なしコンストラクタ
    public Country() {
        
    }
    //引数ありコンストラクタ
    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    
    

}
