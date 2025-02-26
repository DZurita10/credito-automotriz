package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CustomerCarYardDTO;
import com.bancopichincha.credito.automotriz.exception.AlreadyExistException;
import com.bancopichincha.credito.automotriz.exception.NotFoundException;
import com.bancopichincha.credito.automotriz.mapper.CarYardMapper;
import com.bancopichincha.credito.automotriz.mapper.CustomerCarYardMapper;
import com.bancopichincha.credito.automotriz.mapper.CustomerMapper;
import com.bancopichincha.credito.automotriz.model.CarYard;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.model.CustomerCarYard;
import com.bancopichincha.credito.automotriz.repository.CustomerCarYardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerCarYardService implements ICustomerCarYardService{

    private final CustomerCarYardRepository customerCarYardRepository;

    @Override
    public CustomerCarYardDTO findCustomerCarYardById(Long id){
        CustomerCarYard customerCarYard = customerCarYardRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encontro el cliente patio"));
        return CustomerCarYardMapper.toDTO(customerCarYard);
    }

    @Override
    public CustomerCarYardDTO findCustomerCarYardByCustomer(Customer customer){
        CustomerCarYard customerCarYard = customerCarYardRepository.findByCustomer(customer)
                .orElseThrow(()-> new NotFoundException("No se encontro el cliente patio"));
        return CustomerCarYardMapper.toDTO(customerCarYard);
    }

    @Override
    public CustomerCarYardDTO findByCarYard(CarYard carYard){
        CustomerCarYard customerCarYard = customerCarYardRepository.findByCarYard(carYard)
                .orElseThrow(()-> new NotFoundException("No se encontro el cliente patio"));
        return CustomerCarYardMapper.toDTO(customerCarYard);
    }

    @Override
    public CustomerCarYardDTO save(CustomerCarYardDTO customerCarYardDTO){
        Optional<CustomerCarYard> customerCarYard = customerCarYardRepository
                .findByCustomerAndCarYard(CustomerMapper.toCustomer(customerCarYardDTO.getCustomer()),
                        CarYardMapper.toEntity(customerCarYardDTO.getCarYard()));

        if (customerCarYard.isPresent()){
            throw new AlreadyExistException("El cliente ya esta asignado a este patio");
        }

        return CustomerCarYardMapper.toDTO(customerCarYardRepository.save(CustomerCarYardMapper.toEntity(customerCarYardDTO)));
    }

    @Override
    public CustomerCarYardDTO update(CustomerCarYardDTO customerCarYardDTO, Long id){
        CustomerCarYard customerCarYard = customerCarYardRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encontro el cliente patio"));
        customerCarYard.setCustomer(CustomerMapper.toCustomer(customerCarYardDTO.getCustomer()));
        customerCarYard.setCarYard(CarYardMapper.toEntity(customerCarYardDTO.getCarYard()));
        customerCarYard.setAssignmentDate(customerCarYardDTO.getAssignmentDate());
        return CustomerCarYardMapper.toDTO(customerCarYardRepository.save(customerCarYard));
    }

    @Override
    public String deleteCustomerCarYardById(Long id){
        CustomerCarYard customerCarYard = customerCarYardRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encontro el cliente patio"));
        customerCarYardRepository.delete(customerCarYard);
        return "El cliente patio se ha eliminado";
    }

    @Override
    public List<CustomerCarYardDTO> massSave(List<CustomerCarYardDTO> customerCarYardDTOList){
        List<CustomerCarYard> customerCarYards = customerCarYardDTOList.stream()
                .map(CustomerCarYardMapper::toEntity)
                .collect(Collectors.toList());

        List<CustomerCarYard> savedCustomerCarYards = customerCarYardRepository.saveAll(customerCarYards);

        return savedCustomerCarYards.stream().map(CustomerCarYardMapper::toDTO).collect(Collectors.toList());

    }

}
