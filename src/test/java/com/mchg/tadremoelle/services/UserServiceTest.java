package com.mchg.tadremoelle.services;

import com.mchg.tadremoelle.dto.AddUserDTO;
import com.mchg.tadremoelle.models.User;
import com.mchg.tadremoelle.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.userService = new UserService(userRepository);
    }

    @Test
    void dummy() {
        assertTrue(false);
    }

    @Test
    void findUserByUsername() {
        User expected = new User();
        expected.setId(0L);
        expected.setEmail("test@test.dk");
        expected.setPassword("u1pass");
        expected.setUsername("u1");

        String username = "u1";

        when(userRepository.findByUsername(username)).thenReturn(expected);

        assertEquals(expected, userService.findUserByUsername(username));

        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void findUserByUsernameNoUser() {
        String username = "u1";

        when(userRepository.findByUsername(username)).thenReturn(null);

        assertNull(userService.findUserByUsername(username));

        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void findUserByUsernameAndPassword() {
        User expected = new User();
        expected.setId(0L);
        expected.setEmail("test@test.dk");
        expected.setPassword("u1pass");
        expected.setUsername("u1");

        String[] user = {"u1", "u1pass"};

        when(userRepository.findByUsernameAndPassword(user[0], user[1])).thenReturn(expected);

        assertEquals(expected, userService.findUserByUsernameAndPassword(user[0], user[1]));

        verify(userRepository, times(1)).findByUsernameAndPassword(user[0], user[1]);
    }

    @Test
    void findUserByUsernameAndPasswordNoUser() {
        String[] user = {"u1", "u1pass"};

        when(userRepository.findByUsernameAndPassword(user[0], user[1])).thenReturn(null);

        assertNull(userService.findUserByUsernameAndPassword(user[0], user[1]));

        verify(userRepository, times(1)).findByUsernameAndPassword(user[0], user[1]);
    }

    @Test
    void findUserByUsernameAndPasswordWrongPass() {
        String[] user = {"u1", "u2pass"};

        when(userRepository.findByUsernameAndPassword(user[0], user[1])).thenReturn(null);

        assertNull(userService.findUserByUsernameAndPassword(user[0], user[1]));

        verify(userRepository, times(1)).findByUsernameAndPassword(user[0], user[1]);
    }



    @Test
    void add() {
        AddUserDTO dto = new AddUserDTO();
        dto.setUsername("TestUsername");
        dto.setPassword("TestPassword");
        dto.setEmail("Test@Email.example");

        User user = userService.transform(dto);

        User expected = new User();
        expected.setUsername("TestUsername");
        expected.setPassword("TestPassword");
        expected.setEmail("Test@Email.example");

        when(userRepository.save(user))
                .thenReturn(expected);

        User actual = userService.add(dto);

        assertEquals(expected, actual);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void addUserExists() {
        AddUserDTO dto = new AddUserDTO();
        dto.setUsername("TestUsername");
        dto.setPassword("TestPassword");
        dto.setEmail("Test@Email.example");

        User existing = new User();
        existing.setUsername("TestUsername");
        existing.setPassword("TestPassword");
        existing.setEmail("Test@Email.example");

        when(userRepository.findByUsername(dto.getUsername()))
                .thenReturn(existing);

        User actual = userService.add(dto);

        assertNull(actual);

        verify(userRepository, times(1)).findByUsername(dto.getUsername());
    }
}