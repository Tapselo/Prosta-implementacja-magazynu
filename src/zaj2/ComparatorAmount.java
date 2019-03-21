package zaj2;

import java.util.Comparator;

public class ComparatorAmount implements Comparator<Item> {
    @Override
    public int compare(Item i1,Item i2){
        int roznica=i1.getIlosc()-i2.getIlosc();
        if(roznica!=0){
            return roznica;
        }
        else{
            return i1.compareTo(i2);
        }
    }

}
