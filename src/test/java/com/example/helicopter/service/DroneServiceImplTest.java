package com.example.helicopter.service;

import com.example.helicopter.entity.Drone;
import com.example.helicopter.repo.DroneRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class DroneServiceImplTest {
    @InjectMocks
    private DroneServiceImpl droneService;
    @Mock
    private DroneRepo droneRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDroneTest() {
        var droneMock = mock(Drone.class);
        var savedDroneMock = mock(Drone.class);
        when(droneRepo.save(droneMock)).thenReturn(savedDroneMock);

        var actual = droneService.createDrone(droneMock);

        assertEquals(savedDroneMock, actual);
        verify(droneRepo).save(droneMock);
        verifyNoMoreInteractions(droneRepo);
    }

    @Test
    void getAllTest() {
        var droneMock = mock(Drone.class);
        var droneListMock = List.of(droneMock);
        when(droneRepo.findAll()).thenReturn(droneListMock);

        var actual = droneService.getAll();

        assertEquals(droneListMock, actual);
        assertEquals(droneMock, actual.get(0));
        verify(droneRepo).findAll();
        verifyNoMoreInteractions(droneRepo);
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
    void getDroneBySerialTest(){
        String serialNumber = "kakoitoNomer";
        var droneMock = mock(Drone.class);
        when(droneRepo.findBySerialNumber(serialNumber)).thenReturn(droneMock);

        var actual = droneService.getDroneBySerial(serialNumber);

        assertEquals(droneMock, actual);
        verify(droneRepo).findBySerialNumber(serialNumber);
        verifyNoMoreInteractions(droneRepo);
    }

    @Test
    void updateDroneTest(){
        var droneMock = mock(Drone.class);
        var expected = mock(Drone.class);
        when(droneRepo.save(droneMock)).thenReturn(expected);

        var actual = droneService.updateDrone(droneMock);

        assertEquals(expected,actual);
        verify(droneRepo).save(droneMock);
        verifyNoMoreInteractions(droneRepo);
    }
}
