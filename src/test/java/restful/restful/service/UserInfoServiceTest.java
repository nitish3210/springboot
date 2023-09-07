package restful.restful.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import restful.restful.employee.UserInfo;
import restful.restful.employee.UserInfoRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UserInfoServiceTest {
    private UserInfoService userInfoService;

    @Test
    void getUserInfo() {
        UserInfo userInfo = userInfoService.getUserInfo("nitish");
        assertEquals("nitish", userInfo.getUsername());
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}