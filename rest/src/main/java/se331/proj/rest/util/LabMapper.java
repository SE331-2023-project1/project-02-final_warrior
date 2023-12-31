package se331.proj.rest.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import se331.proj.rest.entity.Advisor;
import se331.proj.rest.entity.AdvisorDTO;
import se331.proj.rest.entity.Announcement;
import se331.proj.rest.entity.AnnouncementDTO;
import se331.proj.rest.entity.Student;
import se331.proj.rest.entity.StudentDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    List<StudentDTO> getStudentDTO(List<Student> students);
    @Mapping(source = "ownStudent", target = "ownStudent")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.roles", target = "roles")
    @Mapping(source = "user.images", target = "images")
    @Mapping(source = "user.dept", target = "dept")
    @Mapping(source = "user.position", target = "position")
    AdvisorDTO getAdvisorDTO(Advisor advisor);
    List<AdvisorDTO> getTeacherDTO(List<Advisor> teachers);
    @Mapping(source = "advisor", target = "advisor")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.roles", target = "roles")
    @Mapping(source = "user.images", target = "images")
    @Mapping(source = "user.dept", target = "dept")
    StudentDTO getStudentDTO(Student student);
    List<AdvisorDTO> getAdvisorDTO(List<Advisor> advisors);
    AnnouncementDTO getAnnouncementDTO(Announcement announcement);
    List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcement);
}