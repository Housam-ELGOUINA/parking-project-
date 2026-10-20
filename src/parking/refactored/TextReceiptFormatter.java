package parking.refactored;

import java.util.List;

public class TextReceiptFormatter implements ReceiptFormatter {

    public String line(Receipt r) {
        return r.getPlate() + " | " + r.getType() + " | " + r.getHours() + " h | "
                + r.getAmount() + " MAD | " + r.getMethod();
    }

    public String report(List<Receipt> receipts, double total) {
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (Receipt r : receipts) {
            sb.append(line(r)).append("\n");
        }
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
}