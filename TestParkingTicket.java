class TestParkingTicket {
    public static void main(String[] args) {
        ParkedCar car = new ParkedCar("Toyota", "Corolla", "Red", "XYZ123", 125);
        ParkingMeter meter = new ParkingMeter(60);
        PoliceOfficer officer = new PoliceOfficer("John Doe", "12345");

        ParkingTicket ticket = officer.issueTicket(car, meter);
        if (ticket != null) {
            System.out.println("Ticket issued: \n" + ticket);
        } else {
            System.out.println("No ticket issued.");
        }
    }
}
