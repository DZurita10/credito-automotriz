package com.bancopichincha.credito.automotriz.utils;

import com.bancopichincha.credito.automotriz.dto.CarYardDTO;
import com.bancopichincha.credito.automotriz.dto.CustomerDTO;
import com.bancopichincha.credito.automotriz.dto.ExecutiveDTO;
import com.bancopichincha.credito.automotriz.dto.VehicleBrandsDTO;
import com.bancopichincha.credito.automotriz.service.CarYardService;
import com.bancopichincha.credito.automotriz.service.CustomerService;
import com.bancopichincha.credito.automotriz.service.ExecutiveService;
import com.bancopichincha.credito.automotriz.service.VehicleBrandsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class SaveInitialData {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private VehicleBrandsService vehicleBrandsService;

    @Autowired
    private ExecutiveService executiveService;

    @Autowired
    private CarYardService carYardService;

    @Autowired
    private CsvUtils csvUtils;

    public void runInitialData() {
        saveCustomer();
        saveCarYard();
        saveVehicleBrands();
        saveExecutive();
    }

    private void saveCustomer() {
        File file = new File("files/customer.csv");
        List<CustomerDTO> customerDTOList = csvUtils.verifyRepeatCustomer(csvUtils.convertCSVToCustomerDTO(file));
        customerService.massSave(customerDTOList);
    }

    private void saveCarYard(){
        File file = new File("files/carYard.csv");
        List<CarYardDTO> carYardDTOList = csvUtils.verifyRepeatCarYards(csvUtils.convertCSVToCarYards(file));
        carYardService.massSave(carYardDTOList);
    }

    private void saveVehicleBrands(){
        File file = new File("files/vehicleBrands.csv");
        List<VehicleBrandsDTO> vehicleBrandsDTOList = csvUtils.verifyRepeatVehicleBrands(csvUtils.convertCSVToVehicleBrandsDTO(file));
        vehicleBrandsService.massSave(vehicleBrandsDTOList);
    }

    private void saveExecutive(){
        File file = new File("files/executive.csv");
        List<ExecutiveDTO> executiveDTOList = csvUtils.verifyRepeatExecutive(csvUtils.convertCSVToExecutiveDTO(file));
        executiveService.massSave(executiveDTOList);
    }




}
