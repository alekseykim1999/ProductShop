import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
public class Supermarket implements Serializable {

    ArrayList<Buyer> buyers;
    ArrayList<Item> soldItems = new ArrayList<>();
    public void addCustomerToCollection(Buyer person)
    {
        if(buyers==null)
            buyers=new ArrayList<>();

        buyers.add(person);
    }

    public ArrayList getBuyers()
    {
        return buyers;
    }

    public void getInformation()
    {
        System.out.println("_________По ценам выше назначенной");
        soldItems.stream().filter(p->p.price>100).
                forEach(p->System.out.println(p.name_item + "  " + p.price + " " + p.now));

        System.out.println("__________По сроку вышу назначенного");

        soldItems.stream().filter(p->p instanceof Food).
                filter(p->((Food) p).getExpiredDate() < 7).
                forEach(p->System.out.println(p.name_item + "  " + p.price + " " + p.now));
    }

    public void addSoldItems(ArrayList<Item> _soldItems) {

        _soldItems.stream().forEach(p->soldItems.add(p));
    }


}
