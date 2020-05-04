import java.time.LocalDate;
import java.util.Calendar;

public abstract class FlyerCard implements Discount {
    private String id;
    private String name;
    private LocalDate date;
    private Address address;
    private int ffp=0;

    public FlyerCard(String name, Address address){
        this.name = name;
        this.address = address;
    }
    protected FlyerCard(String id, String name, LocalDate date, Address address, int ffp){
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.ffp = ffp;
    }

    public String GetName() {
        return this.name;
    }

    public void SetAddress(Address address){
        this.address = address;
    }

    public Address GetAddress() {
        return this.address;
    }

    public int GetPoints() {
        return this.ffp;
    }

    public LocalDate GetDate() {
        return this.date;
    }

    @Override
    public String toString(){
        String output = "Customer Name: " + this.GetName() +
                "\n Address: "+ this.GetAddress() +
                "\n Signup Date: " + this.GetDate().toString() +
                "\n Current Points: " + this.GetPoints();
        return output;
    }

}