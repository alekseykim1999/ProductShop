import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Cleaner extends Item implements Expirable {

    public LocalDate release;

    public Cleaner(LocalDate _release, String _name, int _price)
    {
        super(_name,_price);
        this.release=_release;
    }

    @Override
    public int getExpiredDate()
    {

        LocalDate sixDaysBehind = now.minusDays(6);
        Period period = Period.between(now, sixDaysBehind);
        int diff = period.getDays();
        return diff;
    }

    @Override
    public void displayInfo() {

    }
}
