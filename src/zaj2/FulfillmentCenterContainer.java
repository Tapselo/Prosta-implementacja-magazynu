package zaj2;

import java.util.*;

public class FulfillmentCenterContainer {
  private  Map<String, FulfillmentCenter> mapka=new TreeMap<>();

    public void addCenter(String s, double d){
        mapka.put(s, new FulfillmentCenter(s,d));
    }

    public void removeCenter(String s){
        if( mapka.containsKey(s))
        {
            mapka.remove(s);
            System.out.println("Usunięto element o kluczu: "+s);
        }
        else
            System.out.println("Brak elementu o takim kluczu!");
    }

    public List<FulfillmentCenter> findEmpty(){
        boolean znaleziono=false;
        List<FulfillmentCenter> wynik=new LinkedList<>();
        Set<Map.Entry<String,FulfillmentCenter>> entrySet = mapka.entrySet();
            for(Map.Entry<String,FulfillmentCenter>entry:entrySet){
                if(entry.getValue().getCurrMass()==0){
                    wynik.add(entry.getValue());
                    System.out.println("Pusty magazyn o nazwie: "+entry.getValue().getNazwaMag());
                    znaleziono=true;
                }
            }
            if(znaleziono==true){
                return wynik;
            }
            else{
                System.out.println("Brak pustych magazaynow!");
                return null;
            }
    }
    public void summary(){
        List<FulfillmentCenter> wynik=new LinkedList<>();
        Set<Map.Entry<String,FulfillmentCenter>> entrySet = mapka.entrySet();
        for(Map.Entry<String,FulfillmentCenter>entry:entrySet){
            entry.getValue().summary();
        }
    }

    public Map<String, FulfillmentCenter> getMapka() {
        return mapka;
    }
}
