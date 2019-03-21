package zaj2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FulfillmentCenter {
    private String nazwaMag;
    private double maxMass;
    private List<Item> lista;
    private double currMass;

    public FulfillmentCenter(String s, double d){
        this.nazwaMag=s;
        this.maxMass=d;
        this.currMass=0;
        lista=new LinkedList<Item>();
    }

public void addProduct(Item i){
    if(((i.getMasa()*i.getIlosc())+currMass)<maxMass) {
        if(lista.contains(i)) {

            lista.get(lista.indexOf(i)).setIlosc(lista.get(lista.indexOf(i)).getIlosc()+i.getIlosc());
            currMass+=i.getIlosc()*i.getMasa();
        }
        else{
            lista.add(i);
            currMass+=i.getIlosc()*i.getMasa();
        }
    }
    else{
        System.err.println("Masa przekroczyłaby maksymalną, nie dodano produktu");
    }
}

    public void getProduct(Item i){
        if(lista.contains(i))
        {
            int indeks = lista.indexOf(i);
            if(lista.get(indeks).getIlosc() > 0){
                lista.get(indeks).setIlosc(lista.get(indeks).getIlosc()-1);
                currMass-=i.getIlosc()*i.getMasa();
            }
            else{
                currMass-=i.getIlosc()*i.getMasa();
                lista.remove(indeks);
            }
        }
        else {
            System.err.println("Brak takiego produktu");
        }
    }

    public void removeProduct(Item i){
        if(lista.contains(i))
        {
            currMass-=i.getIlosc()*i.getMasa();
            lista.remove(lista.indexOf(i));
        }
        else {
            System.err.println("Brak takiego produktu");
        }
    }

    public Item search(String s){
    boolean znaleziono=false;
    for(Item iterator : lista){
        if(iterator.getNazwa().equals(s)){
            System.out.println("Produkt o nazwie: "+s+" ma na liście indeks: "+lista.indexOf(iterator));
            znaleziono=true;
            return iterator;
        }
    }
    if(znaleziono==false)
    System.err.println("Brak produktu o nazwie: "+s+"!");
    return null;
    }


    public List<Item> searchPartial(String s){
        boolean znaleziono=false;
        List<Item> temp=new LinkedList<>();
        for(Item iterator : lista){
            if(iterator.getNazwa().contains(s)){
                System.out.println("Produkt o nazwie: "+iterator.getNazwa()+" ma na liście indeks: "+lista.indexOf(iterator));
                znaleziono=true;
                temp.add(iterator);
            }
        }
        if(znaleziono==false){
            System.err.println("Brak produktu o składowej w nazwie: "+s+"!");
            return null;
        }
        else{
            return temp;
        }

    }
    public void countByCondition(ItemCondition ic){
    int licznik=0;
    for(Item iterator:lista){
        if(iterator.getStan()==ic){
            licznik+=iterator.getIlosc();
        }
    }
        System.out.println("Produktów na liście: "+licznik);
    }
    public void summary(){
        System.out.println("--Informacje o magazynie--");
        System.out.println("Nazwa magazynu: "+nazwaMag);
        System.out.println("Maksymalna waga: "+maxMass);
        System.out.println("Aktualna waga: "+currMass);
        System.out.println("Procentowe zapełnienie: "+(currMass/maxMass)*100+"%");
        System.out.println("--Produkty--");
        for(Item iterator:lista){
            iterator.print();
        }
    }
    public List<Item> sortByName() {
        List<Item> pom = new LinkedList<>(lista);
        Collections.sort(pom);
        return pom;
    }
    public List<Item> sortByAmount(){
    List<Item> pom=new LinkedList<>(lista);
        Collections.sort(pom, new ComparatorAmount().reversed());
        return pom;
    }
    public Item max(){
    Item pom=Collections.max(lista, new ComparatorAmount());
        System.out.println("Max: ");
        pom.print();
    return pom;
    }

    public double getCurrMass() {
        return currMass;
    }
    public String getNazwaMag() {
        return nazwaMag;
    }
    public double getMaxMass() {
        return maxMass;
    }
    public List<Item> getLista() {
        return lista;
    }

}
