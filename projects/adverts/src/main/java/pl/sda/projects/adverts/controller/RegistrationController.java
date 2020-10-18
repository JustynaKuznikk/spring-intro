package pl.sda.projects.adverts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.projects.adverts.model.domain.User;
import pl.sda.projects.adverts.model.repository.UserRepository;

@Controller @Slf4j //controller - rejestrowanie klasy przez springa
@RequestMapping("/register") //rządamy ścieżki register w przeglądarce met. Get
public class RegistrationController {

    //repozytorium do zapisu użytkownika
    private UserRepository userRepository;
    //szyfrowanie hasła
    private PasswordEncoder passwordEncoder;

    @Autowired //userRepository będzie wstrzyknięty przez springa
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping //aplikacja przygotowuje treść komunikatu i zwraca widok html
    public String prepareRegistrationPage(){
        return "registration/registration-form";
    }
    @PostMapping //dostajemy zestaw danych i budujemy uzytkownika i zapisujemy go
    public String processRegistrationData(@RequestParam String username,
                                          @RequestParam String password,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName,
                                          ModelMap model){
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .firstName(firstName)
                .lastName(lastName)
                .active(true)
                .build();
        log.debug("User to save: {}",user);
        userRepository.save(user);
        log.info("New user saved: {}", user);

        model.addAttribute("savedUser", user);

        return "registration/registration-summary";
    }

}
