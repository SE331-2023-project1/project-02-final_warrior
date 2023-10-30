package se331.proj.rest.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Advisor;
import se331.proj.rest.entity.Announcement;
import se331.proj.rest.entity.Student;
import se331.proj.rest.repository.AdvisorRepository;
import se331.proj.rest.repository.AnnoucementRepository;
import se331.proj.rest.repository.StudentRepository;
import se331.proj.rest.security.user.Role;
import se331.proj.rest.security.user.User;
import se331.proj.rest.security.user.UserRepository;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final AnnoucementRepository announcementRepository;
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


        User userT1 = new User();
        userT1.setUsername("adv1");
        userT1.setPassword(encoder.encode("123"));
        userT1.setFirstname("Thaiphat");
        userT1.setLastname("kub");
        userT1.setRoles(List.of(Role.ROLE_ADVISOR));
        userT1.setDept("Lecture");
        userT1.setPosition("aa");
        userT1.setImages(Collections.singletonList("https://shorturl.at/qzH69"));
        userRepository.save(userT1);

        Advisor advisor1 = new Advisor();
        advisor1.setUser(userT1);
        advisorRepository.save(advisor1);

        User userS1 = new User();
        userS1.setUsername("stu1");
        userS1.setPassword(encoder.encode("123"));
        userS1.setFirstname("Lotus");
        userS1.setLastname("Khum");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setDept("Software Engineer");
        userS1.setImages(Collections.singletonList("https://rebrand.ly/xz81uz9"));
        userRepository.save(userS1);

        Student student1 = new Student();
        student1.setUser(userS1);
        student1.setAdvisor(advisor1);
        studentRepository.save(student1);

        Announcement announcement = Announcement.builder().id(1L).message("Hello, students.")
                                .file("https://media.discordapp.net/attachments/879626635949772830/1165361663881523290/Ichihime-2.png?ex=654692a0&is=65341da0&hm=2113c8160e7e8e2dfd5505fb8e5004bb0391265fcea9dc5ca7753073ebc05377&=&width=215&height=215")
                                .advisor(advisor1)
                                .build();
        announcementRepository.save(announcement);
    }
}