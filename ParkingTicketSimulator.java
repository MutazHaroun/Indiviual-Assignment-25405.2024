// ParkedCar Class
class ParkedCar {
    private String make;
    private String model;
    private String color;
    private String licenseNumber;
    private int parkedMinutes;

    public ParkedCar(String make, String model, String color, String licenseNumber, int parkedMinutes) {
        if (parkedMinutes < 0) {
            throw new IllegalArgumentException("Parked minutes cannot be negative.");
        }
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNumber = licenseNumber;
        this.parkedMinutes = parkedMinutes;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getParkedMinutes() {
        return parkedMinutes;
    }

    @Override
    public String toString() {
        return "ParkedCar{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", parkedMinutes=" + parkedMinutes +
                '}';
    }
}

// ParkingMeter Class
class ParkingMeter {
    private int purchasedMinutes;

    public ParkingMeter(int purchasedMinutes) {
        if (purchasedMinutes < 0) {
            throw new IllegalArgumentException("Purchased minutes cannot be negative.");
        }
        this.purchasedMinutes = purchasedMinutes;
    }

    public int getPurchasedMinutes() {
        return purchasedMinutes;
    }

    @Override
    public String toString() {
        return "ParkingMeter{" +
                "purchasedMinutes=" + purchasedMinutes +
                '}';
    }
}

// ParkingTicket Class
class ParkingTicket {
    private ParkedCar car;
    private double fine;
    private String officerName;
    private String badgeNumber;

    public ParkingTicket(ParkedCar car, int excessMinutes, String officerName, String badgeNumber) {
        this.car = car;
        this.fine = calculateFine(excessMinutes);
        this.officerName = officerName;
        this.badgeNumber = badgeNumber;
    }

    private double calculateFine(int excessMinutes) {
        if (excessMinutes <= 0) {
            return 0.0;
        }
        double baseFine = 25.0; // Base fine for the first hour
        double hourlyFine = 10.0; // Fine for each additional hour or part of an hour
        int additionalHours = (excessMinutes - 60 + 59) / 60; // Round up to the next hour
        return baseFine + (additionalHours * hourlyFine);
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "car=" + car +
                ", fine=$" + fine +
                ", officerName='" + officerName + '\'' +
                ", badgeNumber='" + badgeNumber + '\'' +
                '}';
    }
}
