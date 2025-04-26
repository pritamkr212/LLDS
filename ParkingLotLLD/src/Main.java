import entity.ParkingLot;
import entity.ParkingTicket;
import entity.vehicle.Car;
import entity.vehicle.Vehicle;
import enums.ParkingSpotType;
import service.ParkingSpotService;
import service.PaymentService;
import service.impl.ParkingServiceImpl;
import service.impl.ParkingSpotServiceImpl;
import service.impl.PaymentServiceImpl;
import strategy.parkingStrategy.NearestFirstParkingStrategy;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        System.out.println("Hello world!");
        ParkingLot parkingLot = new ParkingLot("QWERTY");
        ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();
        parkingSpotService.createSpot(ParkingSpotType.COMPACT, "QWERTY", 1, 1, 1, 100);
        parkingSpotService.createSpot(ParkingSpotType.LARGE, "QWERTY", 1, 2, 1, 100);
        parkingSpotService.createSpot(ParkingSpotType.MINI, "QWERTY", 1, 3, 1, 100);


        parkingSpotService.createSpot(ParkingSpotType.COMPACT, "QWERTY", 1, 1, 2, 50);
        parkingSpotService.createSpot(ParkingSpotType.LARGE, "QWERTY", 1, 2, 2, 50);
        parkingSpotService.createSpot(ParkingSpotType.MINI, "QWERTY", 1, 3, 2, 50);

        parkingSpotService.createSpot(ParkingSpotType.COMPACT, "QWERTY", 1, 1, 3, 45);
        parkingSpotService.createSpot(ParkingSpotType.LARGE, "QWERTY", 1, 2, 3, 45);
        parkingSpotService.createSpot(ParkingSpotType.MINI, "QWERTY", 1, 3, 3, 45);


        Vehicle v1 = new Car(123);
        Vehicle v2 = new Car(234);
        Vehicle v3 = new Car(345);

        ParkingServiceImpl parkingLotService = new ParkingServiceImpl(new NearestFirstParkingStrategy(), parkingLot.getName());
        PaymentService paymentService = new PaymentServiceImpl();

        ParkingTicket parkingTicket1 = parkingLotService.entry(v1);
        System.out.println("parking ticket 1: " + parkingTicket1.toString());
        System.out.println("parking ticket 1 with vehicle id: " + parkingTicket1.getVehicle().getVehicleId());
        System.out.println(parkingTicket1.getVehicle().equals(v1));

        ParkingTicket parkingTicket2 = parkingLotService.entry(v2);
        System.out.println("parking ticket 2: " + parkingTicket2);
        System.out.println("parking ticket 2 with vehicle id: " + parkingTicket2.getVehicle().getVehicleId());
        System.out.println(parkingTicket1.getVehicle().equals(v2));

        try {
            int cost = parkingLotService.exit(parkingTicket2, v2);
            System.out.println("cost: "+ cost);
            paymentService.acceptCash(cost);

        } catch ( Exception e) {

        }

    }
}