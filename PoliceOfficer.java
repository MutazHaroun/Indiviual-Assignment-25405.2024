class PoliceOfficer {
    private String name;
    private String badgeNumber;

    public PoliceOfficer(String name, String badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public ParkingTicket issueTicket(ParkedCar car, ParkingMeter meter) {
        int overtimeMinutes = car.getParkedMinutes() - meter.getPurchasedMinutes();
        if (overtimeMinutes > 0) {
            double fine = 25 + (overtimeMinutes - 1) / 60 * 10;
            return new ParkingTicket(car, (int) fine, name, badgeNumber);
        }
        return null; // No ticket issued
    }
}
