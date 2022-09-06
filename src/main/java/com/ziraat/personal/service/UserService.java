package com.ziraat.personal.service;

import com.ziraat.personal.message.ResponseMessage;
import com.ziraat.personal.model.User;
import com.ziraat.personal.repo.UserRepository;
import com.ziraat.personal.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User createUsers(User user){
        return userRepository.save(user); }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUsersById(Long id){
        return userRepository.findById(id);
    }

  public User getById(Long id)
    {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return user;
    }

    public void deleteViaId(long id)
    {
        userRepository.deleteById(id);
    }



    public void store(MultipartFile file){
        try {
            List<User> lstUsers = ExcelUtils.parseExcelFile(file.getInputStream());
            // Save Customers to DataBase
            userRepository.saveAll(lstUsers);
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}
