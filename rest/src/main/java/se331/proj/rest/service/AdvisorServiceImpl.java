package se331.proj.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.dao.AdvisorDao;
import se331.proj.rest.entity.Advisor;
import se331.proj.rest.security.user.UserDao;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{
    final AdvisorDao advisorDao;
    final UserDao userDao;
    @Override
    public Integer getAdvisorSize(){
        return advisorDao.getAdvisorSize();
    }

    @Override
    public Page<Advisor> getAdvisors(Integer perPage, Integer page) {
        return advisorDao.getAdvisors(perPage, page);
    }

    @Override
    public Advisor getAdvisor(Long id) {
        return advisorDao.getAdvisor(id);
    }
    
    @Override
    public Advisor save(Advisor advisor) {
        return advisorDao.save(advisor);
    }

    @Override
    public Advisor updateDetail(Advisor advisor) {
        Advisor updateTeacher = advisorDao.getAdvisor(advisor.getId());
        if (updateTeacher != null) {

            updateTeacher.getUser().setFirstname(advisor.getName());
            updateTeacher.getUser().setLastname(advisor.getSurname());
//            updateTeacher.getUser().setDepartment(teacher.getDepartment());

            advisorDao.save(updateTeacher);

            userDao.save(updateTeacher.getUser());
            return updateTeacher;
        }
        return null;
    }

}
