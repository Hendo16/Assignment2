import java.time.LocalDate;

public abstract class FlyerCard implements Discount, Cloneable, Comparable<FlyerCard> {
    private String id;
    private String name;
    private LocalDate date;
    private Address address;
    private int ffp=0;

    public FlyerCard(String name, Address address){
        this.name = name;
        this.address = address;
        this.date = LocalDate.now();
        this.id = Double.toString(Math.random());
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

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(FlyerCard fc){
        return Integer.valueOf(this.getId()).compareTo(Integer.parseInt(fc.getId()));
    }

    @Override
    public FlyerCard clone() throws CloneNotSupportedException{
        FlyerCard card = (FlyerCard) super.clone();
        card.SetAddress(this.GetAddress().clone());
        return card;
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