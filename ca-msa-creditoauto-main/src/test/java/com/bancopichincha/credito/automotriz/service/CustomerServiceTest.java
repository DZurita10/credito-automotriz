package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.CustomerDTO;
import com.bancopichincha.credito.automotriz.model.Customer;
import com.bancopichincha.credito.automotriz.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;

    @Test
    void findCustomerByIdentification() {
        Customer customer = new Customer();
        customer.setIdentification("123456789");

        when(customerRepository.findByIdentification("123456789")).thenReturn(Optional.of(customer));
        CustomerDTO result = customerService.findCustomerByIdentification("123456789");
        assertNotNull(result);
        assertEquals("123456789", result.getIdentification());

    }
}