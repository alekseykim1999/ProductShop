import java.util.ArrayList;
import java.io.Serializable;
public class Basket implements Serializable {

    public Basket() {};

    ArrayList<Food> items_food= new ArrayList<>();
    ArrayList<Clothe> items_clothe= new ArrayList<>();
    ArrayList<Cleaner> items_clean= new ArrayList<>();

    ArrayList<Item> all_items=new ArrayList<>();

    public void addItem(Item item)
    {
        if(item instanceof Food)
        {
            items_food.add((Food) item);
            all_items.add(item);
        }
        else if(item instanceof Clothe){
            items_clothe.add((Clothe) item);
            all_items.add(item);
        }
        else if(item instanceof Cleaner){
            items_clean.add((Cleaner) item);
            all_items.add(item);
        }

    }

    public ArrayList returnItems() //вывод всех товаров
    {
        return all_items;
    }
}
