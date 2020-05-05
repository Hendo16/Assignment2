import java.util.ArrayList;
import java.util.Collections;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<FlyerCard> cardArray = new ArrayList<>();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Creating objects to be cloned.");
        Address add1 = new Address("13", "Cutler Cresent", "Sydney", "NSW", "2001", "Wollongong");
        Address add2 = new Address("11", "Lantana View", "Melbourne", "VIC", "3018", "Victoria");
        PlatniumCard platniumCard = new PlatniumCard("Nathan Henderson", add1);
        TitaniumCard titaniumCard = new TitaniumCard("Mario Bros", add2);

        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println("Testing Cloneability in Address and Cards.");
        Address cloneadd1 = add1.clone();
        PlatniumCard cloneplatnium = platniumCard.clone();
        TitaniumCard clonetitanium = titaniumCard.clone();

        if(cloneadd1.equals(add1)){
            System.out.println("First Address and cloneadd1 are the same object.");
        }
        if(platniumCard.equals(cloneplatnium)){
            System.out.println("Original platnium and clone platnium are equal and have the same content.");
        }
        if(titaniumCard.equals(clonetitanium)){
            System.out.println("Original titanium and clone titanium are equal and have the same content.");
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        cardArray.add(cloneplatnium);
        cardArray.add(clonetitanium);
        cardArray.sort((p, t) -> p.compareTo(t));
        System.out.println(cardArray.toString());
    }
}