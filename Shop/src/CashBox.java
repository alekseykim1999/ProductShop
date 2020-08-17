import java.util.*;
import java.util.stream.IntStream;

public class CashBox implements CustomerWorkable {

    private int num_cash;
    public CashBox(int _num)
    {
        this.num_cash=_num;
    }


    ArrayDeque<Buyer> buyer_queue = new ArrayDeque<>();
    StateOfCashBox current_state;
    public void setState(StateOfCashBox state)
    {
        current_state=state;
    }

    public StateOfCashBox getState()
    {
        return current_state;
    }


    static int CalculateCash(ArrayList<Item> items_in_basket)
    {
        int sum = items_in_basket.stream().mapToInt(Item::getPrice).sum();
        return sum;
    }

    public ArrayDeque<Buyer> getBuyer_queue()
    {
        return buyer_queue;
    }

    @Override
    public void addCustomerToQueue(Buyer buyer_current) {

            int check_for_exception = buyer_current.PutBasket().returnItems().size();
            System.out.println("У покупателя номер " + buyer_current.getId() + " " +
                    check_for_exception + " товаров в корзине");
             buyer_queue.add(buyer_current);

    }

    @Override
    public ArrayList processCustomer() {

        ArrayList<Item> items_sold=new ArrayList<>();
        for(Buyer person : buyer_queue){

            Basket person_basket = person.PutBasket();

            ArrayList<Item> items_in_basket=person_basket.returnItems();

            System.out.println("Сумма покупателя номер " + person.getId()
                    +" = " + CalculateCash(items_in_basket) + ". Касса номер " + num_cash);

            items_in_basket.stream().forEach(p->items_sold.add(p));
            buyer_queue.remove();
        }

        return items_sold;
    }


}
