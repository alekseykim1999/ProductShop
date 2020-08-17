import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.Serializable;
public class Buyer implements Serializable{
    private int id;
    private Basket basket;
    public int getId() {
        return id;
    }

    public void addItemIntoCart(Item item)
    {
        if(basket==null)
        {
            basket=new Basket();
        }
        basket.addItem(item); //добавление товара  в корзину текущего покупателя
    }


    public Basket PutBasket()
    {
        return basket;
    }

    public Buyer(int _id)
    {
        this.id=_id;
    }

    public int checkBestCashBox(CashBox cash_for_check)
    {
        int number_of_people=0;
        if(cash_for_check.getState()==StateOfCashBox.WORK)
        {
            number_of_people= cash_for_check.getBuyer_queue().size();

        }
        return number_of_people;


    }
}
