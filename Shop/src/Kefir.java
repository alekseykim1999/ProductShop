import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Kefir extends Food {
    public int fat_kefir;


    public Kefir(int time, int price, String name, int fat, LocalDate t)
    {
        super(time,price,name,t);
        this.fat_kefir=fat;
    }

    public void displayInfo()
    {



    }


}
