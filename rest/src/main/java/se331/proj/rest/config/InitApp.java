package se331.proj.rest.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Advisor;
import se331.proj.rest.entity.Student;
import se331.proj.rest.repository.AdvisorRepository;
import se331.proj.rest.repository.StudentRepository;
import se331.proj.rest.security.user.Role;
import se331.proj.rest.security.user.User;
import se331.proj.rest.security.user.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        userRepository.save(User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .roles(List.of(Role.ROLE_ADMIN))
                .build());

        userRepository.save(User.builder()
                .username("st1")
                .password(encoder.encode("123"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .roles(List.of(Role.ROLE_STUDENT))
                .build());

                
//        User user1, user2, user3;
//        user1 = User.builder()
//                .username("admin")
//                .password(encoder.encode("admin"))
//                .firstname("admin")
//                .lastname("admin")
//                .email("admin@admin.com")
//                .roles(List.of(Role.ROLE_ADMIN))
//                .build();
//        user2 = User.builder()
//                .username("teacher")
//                .password(encoder.encode("teacher"))
//                .firstname("teacher")
//                .lastname("teacher")
//                .email("enabled@user.com")
//                .roles(List.of(Role.ROLE_ADVISOR))
//                .build();
//        user3 = User.builder()
//                .username("student")
//                .password(encoder.encode("student"))
//                .firstname("student")
//                .lastname("student")
//                .email("disableUser@user.com")
//                .roles(List.of(Role.ROLE_ADVISOR))
//                .build();
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
        User userT1 = new User();
        userT1.setUsername("KK");
        userT1.setPassword(encoder.encode("KK"));
        userT1.setFirstname("Kong");
        userT1.setLastname("Passakorn");
        userT1.setRoles(List.of(Role.ROLE_ADVISOR));
        userT1.setDept("Software Engineer");
        userT1.setPosition("PhD");
        userT1.setImages(Collections.singletonList("https://shorturl.at/qzH69"));
        userRepository.save(userT1);

        Advisor teacher1 = new Advisor();
        teacher1.setUser(userT1);
        advisorRepository.save(teacher1);

        User userS1 = new User();
        userS1.setUsername("642115020");
        userS1.setPassword(encoder.encode("642115020"));
        userS1.setFirstname("Thiwakon");
        userS1.setLastname("Sakunchao");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setDept("Software Engineer");
        userS1.setImages(Collections.singletonList("https://rebrand.ly/xz81uz9"));
        userRepository.save(userS1);

        Student student1 = new Student();
        student1.setUser(userS1);
        student1.setAdvisor(teacher1);
        studentRepository.save(student1);


    }
}