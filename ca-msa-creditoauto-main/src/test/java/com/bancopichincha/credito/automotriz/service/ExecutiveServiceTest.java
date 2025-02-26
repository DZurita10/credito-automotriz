package com.bancopichincha.credito.automotriz.service;

import com.bancopichincha.credito.automotriz.dto.ExecutiveDTO;
import com.bancopichincha.credito.automotriz.model.Executive;
import com.bancopichincha.credito.automotriz.repository.ExecutiveRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ExecutiveServiceTest {
    @InjectMocks
    private ExecutiveService executiveService;
    @Mock
    private ExecutiveRepository executiveRepository;

    @Test
    void findExecutiveByIdentification() {
        Executive executive = new Executive();
        executive.setIdentification("123456");

        when(executiveRepository.findByIdentification("123456")).thenReturn(Optional.of(executive));

        ExecutiveDTO executiveDTO = executiveService.findExecutiveByIdentification("123456");
        assertNotNull(executiveDTO);
        assertEquals("123456", executiveDTO.getIdentification());
    }
}