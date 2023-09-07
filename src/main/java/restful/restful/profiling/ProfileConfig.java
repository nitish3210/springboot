package restful.restful.profiling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@PropertySource :: it allows specific property irrespective of active profile
//@PropertySource("application-dev.properties")
//@PropertySource("application-prod.properties")
//@PropertySource("application-local.properties")
//note :: @profile allows creation of bean iff active profile is dev
@Profile("prod")
public class ProfileConfig {
    @Value("${message}")
    public String message;

    @Value("${spring.profiles.active}")
    public String activeProfile;

    @PostConstruct
    public void printMessage(){
        System.out.println("Message Is" + " " + message);
        System.out.println("Active Profile Is" + " " + activeProfile);
    }
}
