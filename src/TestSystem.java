public class TestSystem {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------------------");
        //Testing creating of Address and FlyerCard Subclasses, alongside the toString() override.
        Address add1 = new Address("13", "Cutler Cresent", "Sydney", "NSW", "2000", "Wollongong");
        Address add2 = new Address("11", "Lantana View", "Melbourne", "VIC", "3019", "Victoria");
        PlatniumCard platniumCard = new PlatniumCard("Nathan Henderson", add1);
        TitaniumCard titaniumCard = new TitaniumCard("Mario Bro", add2);
        System.out.println(add1);
        System.out.println(platniumCard);
        System.out.println(titaniumCard);
        System.out.println("--------------------------------------------------------------------------------------------");
        //Now testing CardRegisterSystem.
        CardRegisterSystem sys = new CardRegisterSystem();
        CardRegisterView view = new CardRegisterView();
        System.out.println("Create New Card: ");
        sys.createNewCard();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Create Coupon From Card: ");
        sys.createCouponFromCard();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Display Card Info: ");
        sys.displayCardInfo();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Display Coupon Info: ");
        sys.displayCouponInfo();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Get Discount Type: ");
        System.out.println(sys.getDiscountType(view.getFlyerCardIDFromConsole()));
        System.out.println(sys.getDiscountType(view.getCouponIDFromConsole()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Get Discount Amount: ");
        System.out.println(sys.getDiscountAmount(view.getFlyerCardIDFromConsole(), 300.00, TicketType.EconomyClass));
        System.out.println(sys.getDiscountAmount(view.getCouponIDFromConsole(), 300.00, TicketType.EconomyClass));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Search By Discount ID: ");
        System.out.println(sys.searchByDiscountID(view.getFlyerCardIDFromConsole()));
        System.out.println(sys.searchByDiscountID(view.getCouponIDFromConsole()));
        System.out.println("--------------------------------------------------------------------------------------------");
        /*Writing all cards/coupons to file then re-reading them back into the array*/
        sys.ObjectToFile("card.txt");
        sys.ObjectToFile("coupon.txt");
        sys.getObjectFromFile("card.txt");
        sys.getObjectFromFile("coupon.txt");
        /*You can see the duplicated objects in the array below, showing that they were successfully read from the file
        and stored back into the array.*/
        System.out.println(sys.cardarray());
        System.out.println(sys.couparray());
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}