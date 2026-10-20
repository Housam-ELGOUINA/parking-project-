package parking.refactored;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final TariffCatalog tariffs;
    private final ReceiptLog log;
    private final ReceiptFormatter formatter;
    private final List<Receipt> receipts = new ArrayList<>();
    private double total;

    public ParkingService(TariffCatalog tariffs, ReceiptLog log, ReceiptFormatter formatter) {
        this.tariffs = tariffs;
        this.log = log;
        this.formatter = formatter;
    }

    public double fee(Vehicle vehicle, int hours) {
        return tariffs.findTariff(vehicle.getType()).fee(hours);
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method) throws IOException {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;

        Receipt receipt = new Receipt(vehicle.getPlate(), vehicle.getType(),
                hours, amount, method.name());
        receipts.add(receipt);
        log.log(formatter.line(receipt));
    }

    // only refundable methods are accepted: passing CashPayment does not compile
    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        total -= amount;
    }

    public void refundAtDesk(Vehicle vehicle, int hours) {
        double amount = fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for " + vehicle.getPlate());
        total -= amount;
    }

    public String dailyReport() {
        return formatter.report(receipts, total);
    }
}