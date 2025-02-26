package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CustomerDTO;
import com.bancopichincha.credito.automotriz.exception.AlreadyExistException;
import com.bancopichincha.credito.automotriz.exception.NotFoundException;
import com.bancopichincha.credito.automotriz.mapper.CustomerMapper;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.repository.CustomerCarYardRepository;
import com.bancopichincha.credito.automotriz.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerCarYardRepository customerCarYardRepository;

    @Override
    public CustomerDTO findCustomerByIdentification(String identification) throws NotFoundException {
        Customer customer = customerRepository.findByIdentification(identification)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

        return CustomerMapper.toCustomerDTO(customer);
    }

    @Override
    public String deleteCustomerByIdentification(String identification) {
        Customer customer = customerRepository.findByIdentification(identification)
                .orElseThrow(() -> new NotFoundException("Cliente con identificación " + identification + " no encontrado"));

        if (customerCarYardRepository.findByCustomer(customer).isPresent()) {
            throw new AlreadyExistException("No se puede eliminar el cliente con identificación " + identification +
                    " porque tiene registros en cliente patio");
        }

        customerRepository.delete(customer);
        return "Cliente con identificación " + identification + " eliminado exitosamente";
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        Customer customer = CustomerMapper.toCustomer(customerDTO);
        if(this.existCustomer(customerDTO.getIdentification())){
            throw new AlreadyExistException("Cliente ya existe");
        }
        customerRepository.save(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(String identification, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findByIdentification(identification)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

        customer.setName(customerDTO.getName());
        customer.setAge(customerDTO.getAge());
        customer.setAddress(customerDTO.getAddress());
        customer.setBirthdate(customerDTO.getBirthDate());
        customer.setCreditSubject(customerDTO.getCreditSubject());
        customer.setLastName(customerDTO.getLastName());
        customer.setMaritalStatus(customerDTO.getMaritalStatus());
        customer.setSpouseIdentification(customerDTO.getSpouseIdentification());
        customer.setSpouseName(customerDTO.getSpouseName());
        customer.setPhone(customerDTO.getPhone());

        customerRepository.save(customer);

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> massSave(List<CustomerDTO> customerDTOList) {
        List<Customer> customers = customerDTOList.stream()
                .map(CustomerMapper::toCustomer)
                .collect(Collectors.toList());

        List<Customer> savedCustomers = customerRepository.saveAll(customers);

        return savedCustomers.stream()
                .map(CustomerMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }


    private Boolean existCustomer(String identification) {
        Optional<Customer> customer = customerRepository.findByIdentification(identification);
        return customer.isPresent();
    }

}
