package service.impl;

import entity.Branch;
import entity.Vehicle;
import repository.BranchRepository;
import repository.RentalRepository;
import service.RentalService;

import java.util.Map;
import java.util.Objects;

public class RentalServiceImpl implements RentalService {
    private Map<String, Object> rentalRepository = RentalRepository.getRentalRepository();
    private Map<String, Object> branchRepository = BranchRepository.getBranchRepository();

    @Override
    public void addRental(Vehicle vehicle, int startTime, int endTime) {

        if(rentalRepository!=null){
            //book


        }
        else{
            System.out.println("NO vehicle available");
        }
    }
}
