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
        userT1.setLastname("Kub");
        userT1.setRoles(List.of(Role.ROLE_ADVISOR));
        userT1.setDept("Lecture");
        userT1.setPosition("aa");
        userT1.setImages(Collections.singletonList("https://shorturl.at/qzH69"));
        userRepository.save(userT1);

        Advisor advisor1 = new Advisor();
        advisor1.setUser(userT1);
        advisorRepository.save(advisor1);

        User userT2 = new User();
        userT2.setUsername("adv2");
        userT2.setPassword(encoder.encode("123"));
        userT2.setFirstname("Adam");
        userT2.setLastname("Crimson");
        userT2.setRoles(List.of(Role.ROLE_ADVISOR));
        userT2.setDept("Lecture");
        userT2.setPosition("bb");
        userT2.setImages(Collections.singletonList("https://shorturl.at/qzH69"));
        userRepository.save(userT2);

        Advisor advisor2 = new Advisor();
        advisor2.setUser(userT2);
        advisorRepository.save(advisor2);

        User userT3 = new User();
        userT3.setUsername("adv3");
        userT3.setPassword(encoder.encode("123"));
        userT3.setFirstname("Damian");
        userT3.setLastname("Coco");
        userT3.setRoles(List.of(Role.ROLE_ADVISOR));
        userT3.setDept("Lecture");
        userT3.setPosition("cc");
        userT3.setImages(Collections.singletonList("https://shorturl.at/qzH69"));
        userRepository.save(userT3);

        Advisor advisor3 = new Advisor();
        advisor3.setUser(userT3);
        advisorRepository.save(advisor3);

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

        User userS2 = new User();
        userS2.setUsername("stu2");
        userS2.setPassword(encoder.encode("123"));
        userS2.setFirstname("Fame");
        userS2.setLastname("Kub");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setDept("Econ");
        userS2.setImages(Collections.singletonList("https://rebrand.ly/xz81uz9"));
        userRepository.save(userS2);

        Student student2 = new Student();
        student2.setUser(userS2);
        student2.setAdvisor(advisor2);
        studentRepository.save(student2);

        User userS3 = new User();
        userS3.setUsername("stu3");
        userS3.setPassword(encoder.encode("123"));
        userS3.setFirstname("P");
        userS3.setLastname("Han");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setDept("Education");
        userS3.setImages(Collections.singletonList("https://rebrand.ly/xz81uz9"));
        userRepository.save(userS3);

        Student student3 = new Student();
        student3.setUser(userS3);
        student3.setAdvisor(advisor3);
        studentRepository.save(student3);

        Announcement announcement = Announcement.builder().id(1L).message("Good morning")
                                .file("https://i.redd.it/qx0md16altwb1.jpg")
                                .advisor(advisor1)
                                .build();
        announcementRepository.save(announcement);
    }
}