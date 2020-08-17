import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Milk extends Food implements Expirable{
    public double fat_milk;


    public Milk(int date, int _price, String _name, LocalDate _release, double _fat) {
        super(date,_price,_name,_release);
        if(_fat < 2)
        {
            this.fat_milk=_fat;
        }else
            this.fat_milk=0;

    }


    public void displayInfo()
    {

    }



    
}
