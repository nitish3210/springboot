package restful.restful.service;

import restful.restful.employee.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfo(String userName);

    UserInfo saveUser(UserInfo userInfo);
}
