package pl.sda.projects.adverts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.projects.adverts.model.domain.User;

@Controller @Slf4j
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String prepareRegistrationPage(){
        return "registration/registration-form";
    }
    @PostMapping
    public String processRegistrationData(@RequestParam String username,
                                          @RequestParam String password,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        User user = User.builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName).build();
        log.debug("User to save: {}",user);

        return "";
    }

}
