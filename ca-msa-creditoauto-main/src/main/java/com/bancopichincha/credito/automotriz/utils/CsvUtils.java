package com.bancopichincha.credito.automotriz.utils;

import com.bancopichincha.credito.automotriz.dto.*;
import com.bancopichincha.credito.automotriz.exception.CustomException;
import com.bancopichincha.credito.automotriz.model.VehicleBrands;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CsvUtils {
    public List<CustomerDTO> verifyRepeatCustomer(List<CustomerDTO> customerDTOList) {
        Map<String, Integer> identificationCount = new HashMap<>();

        for (CustomerDTO customer : customerDTOList) {
            identificationCount.put(customer.getIdentification(),
                    identificationCount.getOrDefault(customer.getIdentification(), 0) + 1);
        }

        return customerDTOList.stream()
                .filter(customer -> identificationCount.get(customer.getIdentification()) == 1)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> convertCSVToCustomerDTO(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return new CsvToBeanBuilder<CustomerDTO>(fileReader)
                    .withType(CustomerDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new CustomException("Error al leer el archivo CSV: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            throw new CustomException("Error al procesar el contenido del CSV: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public List<ExecutiveDTO> verifyRepeatExecutive(List<ExecutiveDTO> executiveDTOList) {
        Map<String, Integer> identificationCount = new HashMap<>();
        for (ExecutiveDTO executive : executiveDTOList) {
            identificationCount.put(executive.getIdentification(),
                    identificationCount.getOrDefault(executive.getIdentification(), 0) + 1);
        }
        return executiveDTOList.stream()
                .filter(executive -> identificationCount.get(executive.getIdentification()) == 1)
                .collect(Collectors.toList());
    }

    public List<ExecutiveDTO> convertCSVToExecutiveDTO(File file) {
        try(FileReader fileReader = new FileReader(file)) {
            return new CsvToBeanBuilder<ExecutiveDTO>(fileReader)
                    .withType(ExecutiveDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }catch (IOException e) {
            throw new CustomException("Error al leer el archivo CSV: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (RuntimeException e) {
            throw new CustomException("Error al procesar el contenido del CSV: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public List<VehicleBrandsDTO> verifyRepeatVehicleBrands(List<VehicleBrandsDTO> vehicleBrandsDTOList) {
        Map<String , Integer> identificationCount = new HashMap<>();
        for (VehicleBrandsDTO vehicleBrands : vehicleBrandsDTOList) {
            identificationCount.put(vehicleBrands.getBrand(),
                    identificationCount.getOrDefault(vehicleBrands.getBrand(), 0) + 1);
        }
        return vehicleBrandsDTOList.stream()
                .filter(vehicleBrands-> identificationCount.get(vehicleBrands.getBrand()) == 1)
                .collect(Collectors.toList());
    }

    public List<VehicleBrandsDTO> convertCSVToVehicleBrandsDTO(File file) {
        try(FileReader fileReader = new FileReader(file)) {
            return new CsvToBeanBuilder<VehicleBrandsDTO>(fileReader)
                    .withType(VehicleBrandsDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }catch (IOException e) {
            throw new CustomException("Error al leer el archivo CSV: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (RuntimeException e) {
            throw new CustomException("Error al procesar el contenido del CSV: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public List<CarYardDTO> verifyRepeatCarYards(List<CarYardDTO> carYardsDTOList) {
        Map<String , Integer> identificationCount = new HashMap<>();
        for (CarYardDTO carYard : carYardsDTOList) {
            identificationCount.put(carYard.getName(),
                    identificationCount.getOrDefault(carYard.getName(), 0) + 1);
        }
        return carYardsDTOList.stream()
                .filter(carYardDTO-> identificationCount.get(carYardDTO.getName()) == 1)
                .collect(Collectors.toList());
    }

    public List<CarYardDTO> convertCSVToCarYards(File file) {
        try(FileReader fileReader = new FileReader(file)) {
            return new CsvToBeanBuilder<CarYardDTO>(fileReader)
                    .withType(CarYardDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }catch (IOException e) {
            throw new CustomException("Error al leer el archivo CSV: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (RuntimeException e) {
            throw new CustomException("Error al procesar el contenido del CSV: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public List<VehicleDTO> verifyRepeatVehicle(List<VehicleDTO> vehicleDTOList) {
        Map<String , Integer> identificationCount = new HashMap<>();
        for (VehicleDTO vehicle : vehicleDTOList) {
            identificationCount.put(vehicle.getRegistrationPlate(),
                    identificationCount.getOrDefault(vehicle.getRegistrationPlate(), 0) + 1);
        }
        return vehicleDTOList.stream()
                .filter(vehicle-> identificationCount.get(vehicle.getRegistrationPlate()) == 1)
                .collect(Collectors.toList());
    }

    public List<VehicleDTO> convertCSVToVehicle(File file) {
        try(FileReader fileReader = new FileReader(file)) {
            return new CsvToBeanBuilder<VehicleDTO>(fileReader)
                    .withType(VehicleDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }catch (IOException e) {
            throw new CustomException("Error al leer el archivo CSV: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (RuntimeException e) {
            throw new CustomException("Error al procesar el contenido del CSV: " + e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
