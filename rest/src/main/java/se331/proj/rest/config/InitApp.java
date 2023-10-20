package se331.proj.rest.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Advisor;
import se331.proj.rest.entity.Student;
import se331.proj.rest.repository.AdvisorRepository;
import se331.proj.rest.repository.StudentRepository;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Student student1;
        Advisor advisor1;
        student1 = studentRepository.save(Student.builder()
            .studentId(642115025)
            .name("Thaipat2")
            .surname("Sukhumpraisan2")
            .dept("CAMT2")
            .imageLink("https://i.redd.it/jn8p6oejm0ub1.jpg")
            .build());

        advisor1 = advisorRepository.save(Advisor.builder()
            .advisorId(1234)
            .name("John")
            .surname("Doe")
            .dept("CAMT")
            .position("Lecturer")
            .imageLink("https://i.redd.it/qjfd7hi1w8ub1.jpg")
            .build());

        student1.setAdvisor(advisor1);
        advisor1.getStudents().add(student1);
    }
}