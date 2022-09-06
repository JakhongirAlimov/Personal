package com.ziraat.personal.controller;

import com.ziraat.personal.model.User;
import com.ziraat.personal.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.sun.xml.txw2.Document;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = {"/users"})
    public String addProductPage() {
        return "user-add";
    }


    @PostMapping("/upload")
    public String UserUpload( @ModelAttribute("user")User user,
                             @RequestParam("file") MultipartFile file, Model model) throws IOException {
         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            user.setPhotos(fileName);
            user.setContent(file.getBytes());
        model.addAttribute("success", "File Uploaded Successfully");
        service.createUsers(user);
        return "redirect:/upload/show";
    }
    @GetMapping("/upload/show/image")
    public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<User> user)
        throws  ServletException , IOException{
        user = service.findUsersById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
        response.getOutputStream().write(user.get().getContent());
      //  if(user.get().getContent() == null ){}
        response.getOutputStream().close();

    }
    @GetMapping("/upload/show")
    public  String show(Model model){
        List<User> list = service.getAllUsers();
        model.addAttribute("list", list);
        return "user-list";
    }
    @GetMapping("/upload/show/edit/{id}")
    public String updateUser(@PathVariable(value = "id") long id, Model model) {
            User list = service.getById(id);
            model.addAttribute("list", list);
            return "user-details";
    }

    @GetMapping("upload/show/delete/{id}")
    public String deteleUser(@PathVariable(value = "id") long id){
        service.deleteViaId(id);
        return "redirect:/upload/show";
    }


    @GetMapping("/upload/show/file")
    public String index() {
        return "excel-list";
    }

    @PostMapping("/upload/show/file")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
        try {
            service.store(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
        }
        return "excel-list.html";
    }

}
