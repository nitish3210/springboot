package restful.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import restful.restful.employee.UserInfo;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //get userinfo from database
        UserInfo userInfo = userInfoService.getUserInfo(username);
        //prepare userDetails
        UserInfoDetails userInfoDetails = new UserInfoDetails(userInfo);
        return userInfoDetails;
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
