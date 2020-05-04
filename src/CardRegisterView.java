import java.util.Scanner;

public class CardRegisterView {
    Scanner in = new Scanner(System.in);
    public CardRegisterView(){}
    public String getFlyerCardIDFromConsole(){
        System.out.print("Please enter Card ID: ");
        return in.nextLine();
    }
    public String getNameFromConsole(){
        System.out.print("Please enter your name: ");
        return in.nextLine();
    }
    public String[] getAddressFromConsole(){
        String[] output = new String[6];
        System.out.print("Please enter Street Number: ");
        output[0] = in.nextLine();
        System.out.print("Please enter Street Name: ");
        output[1] = in.nextLine();
        System.out.print("Please enter your Suburb: ");
        output[2] = in.nextLine();
        System.out.print("Please enter City: ");
        output[3] = in.nextLine();
        System.out.print("Please enter State: ");
        output[4] = in.nextLine();
        System.out.print("Please enter Postcode: ");
        output[5] = in.nextLine();
        return output;
    }
    public void displayInformationToConsole(String info){
        System.out.println(info);
    }
}
