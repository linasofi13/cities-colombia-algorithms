public class City {

    String name;
    int number;

    public City(String name, int number){
        this.name = name;
        this.number = number;
    }


    @Override
    public String toString() {
        return "Ciudad: " + this.name + ", Numero: " + this.number;
    }
    
}
