package model;

/**
 * The {@code CarRecord} class represents a car in the Car Rental system.
 * It mirrors the structure of the {@code car_record} table in the database.
 * <p>
 * Each {@code CarRecord} contains details about a car such as its plate number,
 * model, brand, year manufactured, mileage, seat capacity, transmission type,
 * current status, and the branch it belongs to.
 * </p>
 * <p>
 * This class is part of the Model layer (M in MVC) and is used to
 * hold car-related data before interacting with the database.
 * </p>
 *
 * @author Galicia
 * @author Marcelino
 * @author Samarista
 * @author Sy
 */
public class CarRecord {
    private String carPlateNumber;        // Primary Key
    private String carTransmission;       // 'Manual' or 'Automatic'
    private String carModel;
    private String carBrand;
    private int carYearManufactured;
    private int carMileage;
    private int carSeatNumber;
    private String carStatus;             // 'Available', 'Rented', or 'Under Maintenance'
    private String carBranchId;           // Foreign Key → branch_record(branch_id)

    /**
     * Default constructor for {@code CarRecord}.
     * Useful for frameworks or creating empty objects.
     */
    public CarRecord() {}

    /**
     * Creates a {@code CarRecord} with all specified details.
     *
     * @param carPlateNumber       the unique plate number of the car
     * @param carTransmission      the transmission type (Manual or Automatic)
     * @param carModel             the car's model name
     * @param carBrand             the brand of the car
     * @param carYearManufactured  the year the car was manufactured
     * @param carMileage           the current mileage of the car
     * @param carSeatNumber        the number of seats in the car
     * @param carStatus            the current status (Available, Rented, or Under Maintenance)
     * @param carBranchId          the ID of the branch where the car belongs
     */
    public CarRecord(String carPlateNumber, String carTransmission, String carModel,
                     String carBrand, int carYearManufactured, int carMileage,
                     int carSeatNumber, String carStatus, String carBranchId) {
        this.carPlateNumber = carPlateNumber;
        this.carTransmission = carTransmission;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carYearManufactured = carYearManufactured;
        this.carMileage = carMileage;
        this.carSeatNumber = carSeatNumber;
        this.carStatus = carStatus;
        this.carBranchId = carBranchId;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarYearManufactured() {
        return carYearManufactured;
    }

    public void setCarYearManufactured(int carYearManufactured) {
        this.carYearManufactured = carYearManufactured;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public int getCarSeatNumber() {
        return carSeatNumber;
    }

    public void setCarSeatNumber(int carSeatNumber) {
        this.carSeatNumber = carSeatNumber;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarBranchId() {
        return carBranchId;
    }

    public void setCarBranchId(String carBranchId) {
        this.carBranchId = carBranchId;
    }

    /**
     * Returns a string representation of the {@code CarRecord},
     * useful for debugging or logging.
     *
     * @return a formatted string containing car details
     */
    @Override
    public String toString() {
        return "CarRecord{" +
                "carPlateNumber='" + carPlateNumber + '\'' +
                ", carTransmission='" + carTransmission + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carYearManufactured=" + carYearManufactured +
                ", carMileage=" + carMileage +
                ", carSeatNumber=" + carSeatNumber +
                ", carStatus='" + carStatus + '\'' +
                ", carBranchId='" + carBranchId + '\'' +
                '}';
    }
}
