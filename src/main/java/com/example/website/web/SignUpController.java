package com.example.website.web;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    @Autowired
    UserService userService;

    @RequestMapping("/signup")
    public String getSignUpPage(Model uiModel){
        User user = userService.getUser();
        uiModel.addAttribute("user", user);
        return "signup";
    }

    @RequestMapping("/registerUser")
    public String creteUser(@ModelAttribute(value ="user") StudentUser studentUser){
       int userId = userService.signUp(studentUser.getName(),studentUser.getGender(),studentUser.getCollege(),studentUser.getLocation());
        if(userId != -1){
            ModelAndView modelAndView = new ModelAndView("redirect:welcome?id="+userId);
            return modelAndView.getViewName();
        }
        return "signup";
    }

    @RequestMapping("/welcome")
    public String showWelcomePage(@RequestParam("id") String userID, ModelMap map){
        map.addAttribute("userID",userID);
        return "welcome";
    }
}
