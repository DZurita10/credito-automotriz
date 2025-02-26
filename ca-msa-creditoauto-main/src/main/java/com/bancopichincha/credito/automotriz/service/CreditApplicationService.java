package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CreditApplicationDTO;
import com.bancopichincha.credito.automotriz.exception.NotFoundException;
import com.bancopichincha.credito.automotriz.mapper.CreditApplicationMapper;
import com.bancopichincha.credito.automotriz.mapper.CustomerCarYardMapper;
import com.bancopichincha.credito.automotriz.model.CreditApplication;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.model.CustomerCarYard;
import com.bancopichincha.credito.automotriz.model.Vehicle;
import com.bancopichincha.credito.automotriz.repository.CreditApplicationRepository;
import com.bancopichincha.credito.automotriz.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreditApplicationService implements ICreditApplicationService {
    private final CreditApplicationRepository creditApplicationRepository;
    private final CustomerCarYardService customerCarYardService;
    private final VehicleRepository vehicleRepository;

    @Override
    public CreditApplicationDTO findById(Long id){
        CreditApplication creditApplication = creditApplicationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encontro ninguna solicitud decredito con ese id"));
        return CreditApplicationMapper.toDTO(creditApplication);
    }

    @Override
    public CreditApplicationDTO save(CreditApplication creditApplication) {
        Optional<CreditApplication> creditApplicationDateCustomer = creditApplicationRepository.findByProductionDateAndCustomer(creditApplication.getProductionDate(), creditApplication.getCustomer());
        Optional<CreditApplication> creditApplicationVehicle = creditApplicationRepository.findByVehicle(creditApplication.getVehicle());
        CustomerCarYard customerCarYard = CustomerCarYard.builder()
                .customer(creditApplication.getCustomer())
                .carYard(creditApplication.getCarYard())
                .build();
        customerCarYardService.save(CustomerCarYardMapper.toDTO(customerCarYard));
        Vehicle vehicle = vehicleRepository.findById(creditApplication.getVehicle().getId())
                .orElseThrow(()-> new NotFoundException("No se Encuentra el vehiculo con ese id"));
        vehicle.setStatus("RESERVADO");
        vehicleRepository.save(vehicle);
        return CreditApplicationMapper.toDTO(creditApplicationRepository.save(creditApplication));
    }

    @Override
    public CreditApplicationDTO update(CreditApplication creditApplication, Long id){
        Optional<CreditApplication> creditApplicationBD = creditApplicationRepository.findById(id);
        if(creditApplicationBD.isPresent()){
            CreditApplication updateCreditApplication = creditApplicationBD.get();
            updateCreditApplication.setProductionDate(creditApplication.getProductionDate());
            updateCreditApplication.setCustomer(creditApplication.getCustomer());
            updateCreditApplication.setCarYard(creditApplication.getCarYard());
            updateCreditApplication.setVehicle(creditApplication.getVehicle());
            updateCreditApplication.setStatus(creditApplication.getStatus());
            updateCreditApplication.setExecutive(creditApplication.getExecutive());
            updateCreditApplication.setMonthsTerm(creditApplication.getMonthsTerm());
            updateCreditApplication.setObservation(creditApplication.getObservation());
            updateCreditApplication.setQuotas(creditApplication.getQuotas());
            updateCreditApplication.setEntry(creditApplication.getEntry());
            CreditApplication creditApplicationUpdate = creditApplicationRepository.save(updateCreditApplication);
            return CreditApplicationMapper.toDTO(creditApplicationUpdate);
        }
        throw new NotFoundException("No se encontro ninguna solicitud con ese id");
    }

    @Override
    public CreditApplicationDTO findByVehicle(Vehicle vehicle){
        CreditApplication creditApplicationBD = creditApplicationRepository.findByVehicle(vehicle)
                .orElseThrow(() -> new NotFoundException("No se Encuentra el vehiculo con ese id"));
        return CreditApplicationMapper.toDTO(creditApplicationBD);
    }

    @Override
    public CreditApplicationDTO findByProductionDateAndCustomer(Date productionDate, Customer customer){
        CreditApplication creditApplicationDateCustomer = creditApplicationRepository.findByProductionDateAndCustomer(productionDate, customer)
                .orElseThrow(() -> new NotFoundException("No se encontro ninguna solicitud del cliente en esa fecha"));
        return CreditApplicationMapper.toDTO(creditApplicationDateCustomer);
    }
}
