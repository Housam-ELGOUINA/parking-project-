package parking.refactored;

import java.util.List;

public interface ReceiptFormatter {
    String line(Receipt r);
    String report(List<Receipt> receipts, double total);
}