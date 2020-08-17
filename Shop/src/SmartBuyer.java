import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.Serializable;
public class
SmartBuyer extends Buyer implements Serializable{


    public SmartBuyer(int _id) {
        super(_id);
    }


    public int checkBestCashBoxByProduct(CashBox cash_for_check) {


        ArrayDeque<Buyer> buyer_queue = cash_for_check.getBuyer_queue();
        int count_of_product=0;
        for(Buyer person : buyer_queue){
            count_of_product+=person.PutBasket().returnItems().size();

        }

        return count_of_product;




    }
}
