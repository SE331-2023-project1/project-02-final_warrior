package se331.proj.rest.service;

import java.util.List;

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
    public List<Student> getStudents(Integer perPage, Integer page) {
        return studentDao.getStudents(perPage, page);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentDao.getStudent(id);
    }
}
