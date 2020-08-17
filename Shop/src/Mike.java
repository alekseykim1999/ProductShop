import java.io.FileWriter;

public class Mike extends Clothe {
    public String gate_type;


    public void gate_type(String _gate_style)
    {
        this.gate_type=_gate_style;
    }
    public Mike(int size,String color,int price, String _name, String gate)
    {
        super(_name,price);
        this.gate_type=gate;
        this.size=size;
        this.color=color;
    }

    public void displayInfo()
    {

    }
}
