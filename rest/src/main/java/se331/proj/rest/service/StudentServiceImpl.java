package se331.proj.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.dao.StudentDao;
import se331.proj.rest.entity.Student;
import se331.proj.rest.security.user.UserDao;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentDao studentDao;
    final UserDao userDao;
    @Override
    public Integer getStudentSize(){
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer perPage, Integer page) {
        return studentDao.getStudents(perPage, page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    public Student updateDetail(Student student) {
        Student updateStudent = studentDao.getStudent(student.getId());
        if (updateStudent != null) {
            updateStudent.getUser().setFirstname(student.getName());
            updateStudent.getUser().setLastname(student.getSurname());
            updateStudent.getUser().setDept(student.getDept());

            studentDao.save(updateStudent);

            userDao.save(updateStudent.getUser());
            return updateStudent;
        }
        return null;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Page<Student> getStudents(String name, Pageable page) {
        return studentDao.getStudents(name, page);
    }
}
