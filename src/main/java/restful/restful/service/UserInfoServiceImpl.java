package restful.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import restful.restful.employee.UserInfo;
import restful.restful.employee.UserInfoRepository;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    private UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfo getUserInfo(String userName){
        UserInfo userInfo = findByName(userName);
        if(userInfo != null){
            return userInfo;
        }
        return null;
    }

    @Transactional
    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    private UserInfo findByName(String userName) {
        Specification<UserInfo> specification = (root, query, cb)->{
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("username"), userName));
            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return userInfoRepository.findOne(specification).orElse(null);
    }

    @Autowired
    public void setUserInfoRepository(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
}
