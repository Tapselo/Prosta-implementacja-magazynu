package zaj2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	FulfillmentCenter mag1=new FulfillmentCenter("Jedynka",200.0);
	mag1.summary();

	Item sok=new Item("Tymbark",ItemCondition.NEW,5.8,1);
	Item sok2=new Item("TymbarkKubus",ItemCondition.NEW,4.2,2);
	Item kontener=new Item("Kontener",ItemCondition.USED,100,1);
	System.out.println("-----------------");
	mag1.addProduct(sok);
	mag1.addProduct(sok2);
	mag1.addProduct(kontener);
	List<Item> tymcz=mag1.searchPartial("Tymbark");
	System.out.println("-----------------");
	Item temp=mag1.search("Tymbark");
	temp=mag1.search("Kon");
	System.out.println("-----------------");
	mag1.summary();
	System.out.println("-----------------");
	mag1.countByCondition(ItemCondition.NEW);
	System.out.println("-----------------");
	Item pom=mag1.max();

	System.out.println("-----------------");
	FulfillmentCenterContainer centra=new FulfillmentCenterContainer();
	centra.addCenter("Dwa",100);
	centra.getMapka().get("Dwa").addProduct(sok2);
	centra.addCenter("Trzy",150);
	centra.summary();
	centra.removeCenter("Dwa");
	System.out.println("-----------------");
	centra.findEmpty();
    }
}
