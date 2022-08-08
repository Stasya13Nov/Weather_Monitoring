import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Integer> info; //0-макс,1-мин,2-давление,3-влажность,4-осадки

    public City(){}
    public City(String name) {
        this.name = name;
        info = new ArrayList<>();
    }
    public void addMaxTemp(int cifra){

        info.add(0,cifra);
    }
    public void addMinTemp(int cifra){

        info.add(1,cifra);
    }
    public void addPressure(int cifra)
    {
        info.add(2,cifra);
    }
    public void addHumidity(int cifra){

        info.add(3,cifra);
    }
    public void addPrecipitation(int cifra){

        info.add(4,cifra);
    }
    public int getMaxTemp(){
        return info.get(0);
    }
    public int getMinTemp(){
        return info.get(1);
    }
    public int getPressure(){
        return info.get(2);
    }
    public int getHumidity(){
        return info.get(3);
    }
    public int getPrecipitation(){
        return info.get(4);
    }


    @Override
    public String toString() {
        return name;
    }
}
