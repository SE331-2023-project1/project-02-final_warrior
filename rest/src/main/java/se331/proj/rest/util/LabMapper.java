package se331.proj.rest.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se331.proj.rest.entity.Advisor;
import se331.proj.rest.entity.AdvisorDTO;
import se331.proj.rest.entity.Student;
import se331.proj.rest.entity.StudentDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
    AdvisorDTO getAdvisorDTO(Advisor advisor);
    List<AdvisorDTO> getAdvisorDTO(List<Advisor> advisors);
}
