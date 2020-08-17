import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.*;
import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.*;
import static java.lang.System.out;
public class Shop {
    public static void main(String[] args){


        LocalDate time_1 = LocalDate.of(2020,APRIL,15);


        Item item11 = new Jeans(25,"Red", 120,"jeans","Official","Cotton");
        Item item12 = new Mike(30,"Blue",90,"Mike_G","Cloth");

        Item item21 = new Milk(3,70,"MilkG",time_1,1.5);



        Item item42 = new Kefir(5,150,"Kefir power",50,time_1);
        
        Item item51 = new Kefir(6,100,"Kefir good",40,time_1);


        Item item52 = new Cleaner(time_1,"SuperClean",200);

        Item item61 = new Cleaner(time_1,"PowerClean",300);
        Item item62 = new Mike(40,"Red",100,"Mike_H","ClothGood");


        Item item81 = new Cleaner(time_1,"PowerClean",300);
        Item item82 = new Mike(40,"Red",100,"Mike_H","ClothGood");

        Item item83 = new Sausage.Builder().givePrice(100).
                giveDays(5).giveMeat("Chicken").giveCompany("Chicken-Tower").Build();
        Item item31 = new Sausage.Builder().givePrice(400).
                giveDays(3).giveFat("30").setDate(time_1).giveMeat("Chicken").Build();

        Item item32 = new Sausage.Builder().givePrice(150).
                giveMeat("Duck").giveFat("30").giveCompany("NSA").setDate(time_1).Build();

        Item item41 = new Sausage.Builder().givePrice(100).
                giveDays(5).giveFat("40").giveMeat("Beaf").setDate(time_1).Build();




        Buyer first = new Buyer(1);
        Buyer second = new Buyer(2);

        second.addItemIntoCart(item21);
        second.addItemIntoCart(item11);
        second.addItemIntoCart(item12);

        Buyer third = new Buyer(3);

        third.addItemIntoCart(item31);
        third.addItemIntoCart(item32);

        Buyer fourth = new Buyer(4);

        fourth.addItemIntoCart(item41);
        fourth.addItemIntoCart(item42);

        Buyer fifth = new Buyer(5);

        fifth.addItemIntoCart(item51);
        fifth.addItemIntoCart(item52);

        Buyer sixth = new SmartBuyer(6);

        sixth.addItemIntoCart(item61);
        sixth.addItemIntoCart(item62);

        Buyer seventh = new SmartBuyer(7);

        Buyer eight = new LazyBuyer(8);

        eight.addItemIntoCart(item81);
        eight.addItemIntoCart(item82);
        eight.addItemIntoCart(item83);


        Supermarket galamart = new Supermarket();

        galamart.addCustomerToCollection(first);
        galamart.addCustomerToCollection(second);
        galamart.addCustomerToCollection(third);
        galamart.addCustomerToCollection(fourth);
        galamart.addCustomerToCollection(fifth);
        galamart.addCustomerToCollection(sixth);
        galamart.addCustomerToCollection(seventh);
        galamart.addCustomerToCollection(eight);



        CashBox cashBoxOne=new CashBox(1);
        cashBoxOne.setState(StateOfCashBox.WORK);

        CashBox cashBoxTwo=new CashBox(2);
        cashBoxTwo.setState(StateOfCashBox.WORK);

        CashBox cashBoxThird=new CashBox(3);
        cashBoxThird.setState(StateOfCashBox.NOT_WORK);



        Exit exit = new Exit();
        ArrayList<Buyer> buyers = galamart.getBuyers();
        for( Buyer person : buyers)
        {

            if(person instanceof SmartBuyer)
            {
                try
                {
                    if(((SmartBuyer) person).checkBestCashBoxByProduct(cashBoxOne) < 6)
                    {
                        cashBoxOne.addCustomerToQueue(person);
                    }
                    else
                    {
                        cashBoxTwo.addCustomerToQueue(person);
                    }
                }
                catch(NullPointerException ex)
                {
                    exit.addCustomerToQueue(person);
                }

            }
            else if(person instanceof LazyBuyer)
            {
                try
                {
                    if(person.checkBestCashBox(cashBoxOne) < 2)
                    {
                        cashBoxOne.addCustomerToQueue(person);
                    }
                    else
                    {
                        exit.addCustomerToQueue(person);
                    }
                }
                catch(NullPointerException ex)
                {
                    exit.addCustomerToQueue(person);
                }
            }
            else
            {
                try
                {
                    if(person.checkBestCashBox(cashBoxOne) < 3)
                    {
                        cashBoxOne.addCustomerToQueue(person);
                    }
                    else
                    {
                        cashBoxTwo.addCustomerToQueue(person);
                    }
                }
                catch(NullPointerException ex)
                {
                    exit.addCustomerToQueue(person);
                }

            }

        }

        System.out.println("________________________________");

        galamart.addSoldItems(cashBoxOne.processCustomer());
        galamart.addSoldItems(cashBoxTwo.processCustomer());


        galamart.getInformation();

        System.out.println("________________________________");
        exit.processCustomer();
        System.out.println("________________________________");
        ArrayList<Buyer> buyers_second;
        try (FileOutputStream fos = new FileOutputStream("D:\\KaspiLab\\Программы\\Задание 9\\Serialize.txt");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            System.out.println(" Serialize was successfull");
            out.writeObject(galamart);
            } catch (IOException i) {
             System.out.println("Exception writing out Portfolio: " + i);
             }


        try (FileInputStream fis = new FileInputStream("D:\\KaspiLab\\Программы\\Задание 9\\Serialize.txt");
             ObjectInputStream in = new ObjectInputStream(fis))
        {
            Supermarket newP = (Supermarket) in.readObject();
            System.out.println(" ____________________________");
            System.out.println(" Deserialaize was successfull");
            buyers_second =newP.getBuyers();
            System.out.println(" Recovered id " + buyers_second.get(0).getId() );

        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading in Portfolio: " + i);
        }










    }
}
