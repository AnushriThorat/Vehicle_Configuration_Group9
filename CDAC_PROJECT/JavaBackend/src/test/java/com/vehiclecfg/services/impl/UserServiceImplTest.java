package com.vehiclecfg.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vehiclecfg.entities.User;
import com.vehiclecfg.exception.UserNotFoundException;
import com.vehiclecfg.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private BCryptPasswordEncoder encoder;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    void shouldSaveUserSuccessfully() {

        User user = new User();

        user.setUsername("deepak");
        user.setPassword("12345");

        when(encoder.encode("12345"))
                .thenReturn("encodedPassword");

        when(repository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        User savedUser = service.save(user);

        assertNotNull(savedUser);
        assertEquals("encodedPassword", savedUser.getPassword());

        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void shouldReturnUserById() {

        User user = new User();

        user.setId(1);
        user.setUsername("deepak");

        when(repository.findById(1))
                .thenReturn(Optional.of(user));

        User result = service.getUserById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("deepak", result.getUsername());

        verify(repository).findById(1);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {

        when(repository.findById(1))
                .thenReturn(Optional.empty());

        assertThrows(
                UserNotFoundException.class,
                () -> service.getUserById(1));

        verify(repository).findById(1);
    }

    @Test
    void shouldReturnAllUsers() {

        List<User> users = List.of(
                new User(),
                new User(),
                new User());

        when(repository.findAll())
                .thenReturn(users);

        List<User> result = service.getAllUsers();

        assertEquals(3, result.size());

        verify(repository).findAll();
    }

    @Test
    void shouldUpdateUser() {

        User existing = new User();

        existing.setId(1);
        existing.setUsername("old");
        existing.setPassword("oldPassword");

        User updated = new User();

        updated.setUsername("new");
        updated.setPassword("12345");

        updated.setCompanyName("ABC Pvt Ltd");
        updated.setCompanyEmail("abc@gmail.com");

        when(repository.findById(1))
                .thenReturn(Optional.of(existing));

        when(encoder.encode("12345"))
                .thenReturn("encodedPassword");

        when(repository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        User result = service.updateUser(1, updated);

        assertEquals("new", result.getUsername());
        assertEquals("encodedPassword", result.getPassword());
        assertEquals("ABC Pvt Ltd", result.getCompanyName());

        verify(repository).save(existing);
    }

    @Test
    void shouldDeleteUserSuccessfully() {

        User user = new User();

        user.setId(1);

        when(repository.findById(1))
                .thenReturn(Optional.of(user));

        doNothing().when(repository)
                .delete(user);

        service.deleteUser(1);

        verify(repository, times(1))
                .delete(user);

    }

    @Test
    void shouldValidateUserSuccessfully() {

        User user = new User();

        user.setUsername("deepak");
        user.setPassword("encodedPassword");

        when(repository.findByUsername("deepak"))
                .thenReturn(user);

        when(encoder.matches(
                "12345",
                "encodedPassword"))
                .thenReturn(true);

        boolean result =
                service.validateUser(
                        "deepak",
                        "12345");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForWrongPassword() {

        User user = new User();

        user.setUsername("deepak");
        user.setPassword("encodedPassword");

        when(repository.findByUsername("deepak"))
                .thenReturn(user);

        when(encoder.matches(
                "wrongPassword",
                "encodedPassword"))
                .thenReturn(false);

        boolean result =
                service.validateUser(
                        "deepak",
                        "wrongPassword");

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenUserDoesNotExist() {

        when(repository.findByUsername("deepak"))
                .thenReturn(null);

        boolean result =
                service.validateUser(
                        "deepak",
                        "12345");

        assertFalse(result);
    }
    
    @Test
    void shouldThrowExceptionWhenDeletingNonExistingUser() {

        when(repository.findById(1))
                .thenReturn(Optional.empty());

        assertThrows(

                UserNotFoundException.class,

                () -> service.deleteUser(1)

        );

        verify(repository, never())
                .delete(any(User.class));

    }

}