package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.User;
import com.vehiclecfg.exception.UserNotFoundException;
import com.vehiclecfg.repository.UserRepository;
import com.vehiclecfg.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User save(User user) {

        user.setPassword(

                encoder.encode(user.getPassword())

        );

        return repository.save(user);

    }

    @Override
    public List<User> getAllUsers() {

        return repository.findAll();

    }

    @Override
    public User getUserById(Integer id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new UserNotFoundException(

                                "User not found with ID : " + id

                        )

                );

    }

    @Override
    public User updateUser(Integer id, User user) {

        User existing = repository.findById(id)

                .orElseThrow(() ->

                        new UserNotFoundException(

                                "User not found with ID : " + id

                        )

                );

        existing.setUsername(user.getUsername());

        existing.setPassword(

                encoder.encode(user.getPassword())

        );

        existing.setCompanyName(user.getCompanyName());

        existing.setCompanyEmail(user.getCompanyEmail());

        existing.setRegistrationNo(user.getRegistrationNo());

        existing.setHoldingType(user.getHoldingType());

        existing.setAddress1(user.getAddress1());

        existing.setAddress2(user.getAddress2());

        existing.setCity(user.getCity());

        existing.setState(user.getState());

        existing.setPin(user.getPin());

        existing.setAuthorizedPersonName(user.getAuthorizedPersonName());

        existing.setDesignation(user.getDesignation());

        existing.setAuthPersonTel(user.getAuthPersonTel());

        existing.setCell(user.getCell());

        existing.setPhone(user.getPhone());

        existing.setFax(user.getFax());

        existing.setCompanyStNo(user.getCompanyStNo());

        existing.setCompanyVatNo(user.getCompanyVatNo());

        existing.setTaxPan(user.getTaxPan());

        return repository.save(existing);

    }

    @Override
    public void deleteUser(Integer id) {

        User existing = repository.findById(id)

                .orElseThrow(() ->

                        new UserNotFoundException(

                                "User not found with ID : " + id

                        )

                );

        repository.delete(existing);

    }

    @Override
    public User getByUsername(String username) {

        User user = repository.findByUsername(username);

        if (user == null) {

            throw new UserNotFoundException(

                    "User not found with username : " + username

            );

        }

        return user;

    }

    // Used during Login
    public boolean validateUser(String username, String password) {

        User user = repository.findByUsername(username);

        if (user == null) {

            return false;

        }

        return encoder.matches(

                password,

                user.getPassword()

        );

    }

}