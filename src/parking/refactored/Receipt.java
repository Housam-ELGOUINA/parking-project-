package parking.refactored;

public class Receipt {
    private final String plate;
    private final String type;
    private final int hours;
    private final double amount;
    private final String method;

    public Receipt(String plate, String type, int hours, double amount, String method) {
        this.plate = plate;

        this.type = type;
        this.hours = hours;

        this.amount = amount;

        this.method =   method;
    }

    public String getPlate()  { return plate;
    }
    public String getType()   {
        return type;
    }
    public int getHours()     {
        return hours; }
    public double getAmount() {
        return amount; }
    public String getMethod() {
        return method;
    }
}