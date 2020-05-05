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
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Address other = (Address) obj;
        if(StreetNum == null){
            if(other.StreetNum != null){
                return false;
            }
            else if(!StreetNum.equals(other.StreetNum)){
                return false;
            }
        }
        if(StreetName == null){
            if(other.StreetName != null){
                return false;
            }
            else if(!StreetName.equals(other.StreetName)){
                return false;
            }
        }
        if(Suburb == null){
            if(other.Suburb != null){
                return false;
            }
            else if(!Suburb.equals(other.Suburb)){
                return false;
            }
        }
        if(City == null){
            if(other.City != null){
                return false;
            }
            else if(!City.equals(other.City)){
                return false;
            }
        }
        if(State == null){
            if(other.State != null){
                return false;
            }
            else if(!State.equals(other.State)){
                return false;
            }
        }
        if(Postcode == null){
            if(other.Postcode != null){
                return false;
            }
            else if(!Postcode.equals(other.Postcode)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address) super.clone();
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