import java.util.ArrayDeque;
import java.util.ArrayList;

public class Exit implements CustomerWorkable{

    ArrayDeque<Buyer> persons_to_exit = new ArrayDeque<>();

    @Override
    public void addCustomerToQueue(Buyer buyer_current) {

        persons_to_exit.add(buyer_current);
    }

    @Override
    public ArrayList processCustomer() {

        ArrayList<Buyer> just = new ArrayList<>();

        for (Buyer person_free : persons_to_exit)
        {
            System.out.println("Покупатель с номером "  + person_free.getId()
                    + " прошел без товара");
        }

        return just;

    }
}
