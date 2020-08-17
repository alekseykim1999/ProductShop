import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sausage extends Food
{

    private String meat_sort1;
    private String company;
    private int sav_days;
    private String fat1;
    private boolean isCheap;


    private Sausage()
    {



    };



    public static class Builder
    {
        private String meat_sort;
        private String company;
        private int sav_days;
        private String fat;
        private boolean isCheap;
        private int price;
        private LocalDate releaseDate;

        public Builder giveMeat(String _meat)
        {
            this.meat_sort=_meat;
            return this;
        }
        public Builder giveCompany(String _company)
        {
            this.company=_company;
            return this;
        }

        public Builder giveDays(int _days)
        {
            this.sav_days=_days;
            return this;
        }

        public Builder giveFat(String _fat)
        {
            this.fat=_fat;
            return this;
        }
        public Builder givePrice(int _price)
        {
            this.price=_price;
            return this;
        }

        public Builder IsCheap(boolean _isCheap)
        {
            this.isCheap=_isCheap;
            return this;
        }
        public Builder setDate(LocalDate date)
        {
            this.releaseDate=date;
            return this;
        }
        public Sausage Build()
        {
            Sausage meal = new Sausage();
            meal.setMeat(this.meat_sort);
            meal.setCompany(this.company);
            meal.setDays(this.sav_days);
            meal.setFat(this.fat);
            meal.setCheap(this.isCheap);
            meal.setPrice(this.price);
            meal.setDate(this.releaseDate);
            return meal;

        }



    }

    @Override
    public void displayInfo()
    {
    }

    private void setFat(String fat) {
        this.fat1=fat;
    }

    private void setPrice(int price) {
        this.price=price;
    }

    private void setCheap(boolean cheap) {
        this.isCheap=cheap;
    }

    private void setDays(int days) {
        this.sav_days=days;
    }

    private void setCompany(String company) {
        this.company=company;
    }

    private void setMeat(String meat_sort) {
        this.name_item=meat_sort;
    }
    private void setDate(LocalDate date) {
        this.releaseDate = date;
    }


}
