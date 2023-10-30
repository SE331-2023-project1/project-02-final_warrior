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
        Advisor updateAdvisor = advisorDao.getAdvisor(advisor.getId());
        if (updateAdvisor != null) {

            updateAdvisor.getUser().setFirstname(advisor.getName());
            updateAdvisor.getUser().setLastname(advisor.getSurname());
            updateAdvisor.getUser().setDept(advisor.getDept());
//            updateTeacher.getUser().setDepartment(teacher.getDepartment());

            advisorDao.save(updateAdvisor);

            userDao.save(updateAdvisor.getUser());
            return updateAdvisor;
        }
        return null;
    }

}
