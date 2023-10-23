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

        Student student1;
        Advisor advisor1;
        student1 = studentRepository.save(Student.builder()
            .studentId(642115025)
            .name("Thaipat2")
            .surname("Sukhumpraisan2")
            .dept("CAMT2")
            .imageLink(new ArrayList<String>())
            .build());

        advisor1 = advisorRepository.save(Advisor.builder()
            .advisorId(1234)
            .name("John")
            .surname("Doe")
            .dept("CAMT")
            .position("Lecturer")
            .imageLink(new ArrayList<String>())
            .build());


        student1.setAdvisor(advisor1);
        student1.getImageLink().add("https://i.redd.it/jn8p6oejm0ub1.jpg");
        advisor1.getStudents().add(student1);
        advisor1.getImageLink().add("https://i.redd.it/qjfd7hi1w8ub1.jpg");
    }
}