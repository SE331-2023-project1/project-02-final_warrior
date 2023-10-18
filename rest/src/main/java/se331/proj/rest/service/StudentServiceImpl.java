package se331.proj.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.dao.StudentDao;
import se331.proj.rest.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentDao studentDao;
    @Override
    public Integer getStudentSize(){
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer perPage, Integer page) {
        return studentDao.getStudents(perPage, page);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentDao.getStudent(id);
    }
    
    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

}
