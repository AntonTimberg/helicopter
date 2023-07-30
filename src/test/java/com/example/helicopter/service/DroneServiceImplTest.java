package com.example.helicopter.service;

import com.example.helicopter.converter.DroneConverter;
import com.example.helicopter.dto.DroneDto;
import com.example.helicopter.entity.Drone;
import com.example.helicopter.repo.DroneRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


class DroneServiceImplTest {
    @InjectMocks
    private DroneServiceImpl droneService;
    @Mock
    private DroneRepo droneRepo;

    @Mock
    private DroneConverter conversionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void createDroneTest() {
        var drone = mock(Drone.class);
        var savedDrone = mock(Drone.class);
        var convertedDrone = mock(DroneDto.class);

        when(droneRepo.save(drone)).thenReturn(savedDrone);
        when(conversionService.convert(savedDrone)).thenReturn(convertedDrone);

        var actual = droneService.createDrone(drone);

        assertEquals(convertedDrone, actual);
        verify(droneRepo).save(drone);
        verify(conversionService).convert(savedDrone);
        verifyNoMoreInteractions(droneRepo);
        verifyNoMoreInteractions(conversionService);
    }

    @Test
    void getAllTest() {
        var droneMock = mock(Drone.class);
        var convertedDrone = mock(DroneDto.class);
        var droneListMock = List.of(droneMock);
        var droneDtoMocks = List.of(convertedDrone);

        when(droneRepo.findAll()).thenReturn(droneListMock);
        when(conversionService.convert(droneMock)).thenReturn(convertedDrone);

        //when(droneService.getAll()).thenReturn();

        var actual = droneService.getAll();

        assertEquals(droneDtoMocks, actual);
        //assertEquals(droneMock, actual.get(0));
        verify(droneRepo).findAll();
        verify(conversionService).convert(droneMock);
        verifyNoMoreInteractions(droneRepo, conversionService);
    }

    @Test
    void deleteDroneBySerialWhenDroneIsFoundTest(){
        String serialNumber = "kakoitoNomer";
        var droneMock = mock(Drone.class);
        when(droneRepo.findBySerialNumber(serialNumber)).thenReturn(droneMock);

        droneService.deleteDroneBySerial(serialNumber);

        verify(droneRepo).findBySerialNumber(serialNumber);
        verify(droneRepo).delete(droneMock);
        verifyNoMoreInteractions(droneRepo);
    }
    
    @Test
    void deleteDroneBySerialWhenDroneIsNullTest(){
        String serialNumber = "kakoitoNomer";
        when(droneRepo.findBySerialNumber(serialNumber)).thenReturn(null);

        droneService.deleteDroneBySerial(serialNumber);

        verify(droneRepo).findBySerialNumber(serialNumber);
        verifyNoMoreInteractions(droneRepo);
    }

    @Test
    void getDroneBySerialTest() {
        String serialNumber = "kakoitoNomer";
        var droneMock = mock(Drone.class);
        var droneDtoMock = mock(DroneDto.class);

        when(droneRepo.findBySerialNumber(serialNumber)).thenReturn(droneMock);
        when(conversionService.convert(droneMock)).thenReturn(droneDtoMock);

        var actual = droneService.getDroneBySerial(serialNumber);

        assertEquals(droneDtoMock, actual);

        verify(droneRepo).findBySerialNumber(serialNumber);
        verify(conversionService).convert(droneMock);
        verifyNoMoreInteractions(droneRepo, conversionService);
    }

    @Test
    void updateDroneTest() {
        Drone droneMock = mock(Drone.class);
        DroneDto droneDtoMock = mock(DroneDto.class);

        when(droneMock.getId()).thenReturn(1L);
        when(droneRepo.existsById(1L)).thenReturn(true);
        when(droneRepo.save(droneMock)).thenReturn(droneMock);
        when(conversionService.convert(droneMock)).thenReturn(droneDtoMock);

        DroneDto actual = droneService.updateDrone(droneMock);

        assertEquals(droneDtoMock, actual);

        verify(droneRepo).existsById(1L);
        verify(droneRepo).save(droneMock);
        verify(conversionService).convert(droneMock);

        verifyNoMoreInteractions(droneRepo, conversionService);
    }
}
