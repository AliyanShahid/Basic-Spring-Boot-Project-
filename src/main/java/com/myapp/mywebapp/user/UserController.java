package com.myapp.mywebapp.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
     @Autowired
     public UserService service;
      @GetMapping ("/users")
      public String showuserlist(Model model)
      {
           List<user> listusers = service.listall();
           model.addAttribute("listusers",listusers);
                  return "users";
      }
      @GetMapping ("/users/new")
    public String shownewform(Model model)
      {
            model.addAttribute("pagetitle", "Add new User");
          model.addAttribute("user", new user());
           return "user_form";
      }
      @PostMapping("/users/save")
      public  String sveuser(user user, RedirectAttributes ra){
          service.save(user);

          ra.addFlashAttribute("message", "The user has been saved Successfully");
          return "redirect:/users";
      }
     @GetMapping ("/users/edit/{id}")
    public String edituserform (@PathVariable("id") Integer id, Model model , RedirectAttributes ra)
     {
         try {

             user user= service.get(id);
             model.addAttribute("user", user);
             model.addAttribute("pagetitle", "Edit User : " + id);
             return "user_form";
         } catch (UserNotFoundException e) {
             ra.addFlashAttribute("message", e.getMessage());
             return "redirect:/users";
         }
     }


    @GetMapping ("/users/delete/{id}")
    public String deleteuserform (@PathVariable("id") Integer id, RedirectAttributes ra)
    {
        try {

          service.delete(id);
          ra.addFlashAttribute("message", "User with Id "+ id +" has beed deleted successfuly ");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/users";
    }
}
