package zaj2;

import java.util.Objects;

public class Item implements Comparable<Item>{
   private String nazwa;
   private ItemCondition stan;
   private double masa;
   private int ilosc;

public Item(String name,ItemCondition st,double mass,int counter){
    this.nazwa=name;
    this.stan=st;
    this.masa=mass;
    this.ilosc=counter;
}

    @Override
    public int compareTo(Item o) {
        if(nazwa.compareTo(o.nazwa)==0){
            return stan.compareTo(o.stan);
        }
        else{
            return nazwa.compareTo(o.nazwa);
        }
    }

    public int compareTo(String s){
         return nazwa.compareTo(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return nazwa.equals(item.nazwa) &&
                stan == item.stan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, stan);
    }

    public void print(){
       System.out.println("Nazwa: "+nazwa+" Stan: "+stan+" Masa: "+masa+" Ilość: "+ilosc);
   }

    public String getNazwa() {
        return nazwa;
    }

    public ItemCondition getStan() {
        return stan;
    }


    public double getMasa() {
        return masa;
    }


    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
