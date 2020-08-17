import java.util.ArrayList;

public interface CustomerWorkable {

    void addCustomerToQueue(Buyer buyer_current);

    ArrayList processCustomer();
}
