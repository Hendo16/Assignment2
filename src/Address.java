public class Address implements Cloneable{
    private String StreetNum;
    private String StreetName;
    private String City;
    private String State;
    private String Postcode;
    private String Suburb;

    public Address(String num, String name, String city, String state, String post, String sub){
        this.StreetNum = num;
        this.StreetName = name;
        this.City = city;
        this.State = state;
        this.Postcode = post;
        this.Suburb = sub;
    }

    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address)super.clone();
    }

    @Override
    public String toString(){
        String output =
                this.StreetNum + "," +
                this.StreetName + "," +
                this.City + "," +
                this.State + "," +
                this.Postcode + "," +
                this.Suburb;
        return output;
    }
}