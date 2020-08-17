import java.io.FileWriter;
import java.io.Serializable;

public class Jeans extends Clothe implements Serializable {
    public String style;
    public String tissue_type;

    public void displayInfo()
    {

    }
    public Jeans(int size,String color,int _price, String _name_item, String _style, String _tissue)
    {
        super(_name_item,_price);
        this.size=size;
        this.color=color;
        this.style=_style;
        this.tissue_type=_tissue;
    }

}
