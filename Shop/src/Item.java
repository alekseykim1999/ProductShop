import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
public class Item implements Serializable {
    public String name_item;
    public int price;

    protected transient LocalDate now = LocalDate.now();
    public Item(String _name, int _price)
    {
        this.name_item=_name;
        this.price=_price;
    }

    public Item(){

    }
    public void displayInfo()
    {
        System.out.println( " " + now);
    }

    public int getPrice() {
        return price;
    }


}
