package com.sbota.PetClinic.controller;

import com.sbota.PetClinic.model.User;
import com.sbota.PetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerUser() {
        return "security/register";
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @PostMapping("/register")
    public String registerUser(String username, String password) {
        User user = new User();
//        user.setEmailAddress(emailAddress);
        user.setPassword(encoder().encode(password));
        user.setUsername(username);

        userRepository.save(user);
//        PendingUser pendingUser = new PendingUser();
//        String activationCode = randomStringGenerator.getAlphaNumericString(20);
//        pendingUser.setActivationCode(activationCode);
//        sendGridEmailService.sendHTML("buhaidebalta.15@gmail.com",
//                user.getEmailAddress(), "Please confirm account",
//                randomStringGenerator.linkCreator(activationCode,
//                        "https://online-school-catalog-sb.herokuapp.com"));
//        pendingUser.setUser(user);
//        pendingUserRepository.save(pendingUser);

        return "redirect:/login";
    }
}
