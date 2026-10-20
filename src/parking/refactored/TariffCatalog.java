package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class TariffCatalog {
    private final List<Tariff> tariffs = new ArrayList<>();

    public void add(Tariff tariff) {
        tariffs.add(tariff);
    }

    public Tariff findTariff(String vehicleType) {
        for (Tariff t : tariffs) {
            if (t.vehicleType().equals(vehicleType)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
    }
}