package parking.refactored;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TariffCatalog catalog = new TariffCatalog();
        catalog.add(new CarTariff());
        catalog.add(new MotorbikeTariff());
        catalog.add(new TruckTariff());

        ParkingService service = new ParkingService(
                catalog, new FileReceiptLog("parking.log"), new TextReceiptFormatter());

        Vehicle car   = new Vehicle("12345-A-6", "CAR");
        Vehicle moto  = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");
        CardPayment card = new CardPayment("4242");

        service.checkout(car, 3, card);
        service.checkout(moto, 2, new CashPayment());
        service.checkout(truck, 4, card);
        service.refundAtDesk(moto, 2);
        service.cancel(truck, 4, card);
        System.out.println(service.dailyReport());
    }
}