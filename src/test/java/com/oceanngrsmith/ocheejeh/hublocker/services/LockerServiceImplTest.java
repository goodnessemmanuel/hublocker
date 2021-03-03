package com.oceanngrsmith.ocheejeh.hublocker.services;


import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.repository.LockerRepo;
import com.oceanngrsmith.ocheejeh.hublocker.services.impl.LockerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LockerServiceImplTest {
    @Mock
    private LockerRepo lockerRepository;

    @InjectMocks
    private LockerServiceImpl lockerService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(lockerRepository);
    }

    @Test
    void shouldSaveLocker(){
        Locker returnLocker = new Locker("Awesome Locker", "250 item per/mo");
        returnLocker.setId(1L);

        when(lockerRepository.save(returnLocker)).thenReturn(returnLocker);

        Locker savedLocker = lockerService.saveLocker(returnLocker);
        assert savedLocker.getId().equals(returnLocker.getId());
        assert savedLocker.getName().equals(returnLocker.getName());

        verify(lockerRepository, times(1)).save(returnLocker);
    }
}
