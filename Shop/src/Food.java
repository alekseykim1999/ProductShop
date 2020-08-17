import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Food extends Item implements Expirable {

    private int shelf_life;

    protected transient DateTimeFormatter format  = DateTimeFormatter.ISO_LOCAL_DATE;


    public LocalDate releaseDate;

    public Food()
    {

    }


    public Food(int date, int _price,String _name,LocalDate _releaseDate)
    {
        super(_name,_price);
        this.shelf_life=date;
        this.price=_price;
        this.name_item=_name;
        this.releaseDate=_releaseDate;

    }

    @Override
    public int getExpiredDate()
    {
        Period period = Period.between(now, releaseDate.plusDays(shelf_life));
        int diff = period.getDays();
        return diff;
    }
}
