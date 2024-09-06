package job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class JobTest {
    public static void main(String[] args) {
        String dir = System.getProperty("user.home");

        log.info("[ >>>> user.home : {} ]", System.getProperty("user.home"));
        log.info("[ >>>> java.version : {} ]", System.getProperty("java.version"));
        log.info("[ >>>> java.vendor : {} ]", System.getProperty("java.vendor"));
        log.info("[ >>>> java.class.version : {} ]", System.getProperty("java.class.version"));
        log.info("[ >>>> java.class.path : {} ]", System.getProperty("java.class.path"));
        log.info("[ >>>> user.name : {} ]", System.getProperty("user.name"));
        log.info("[ >>>> user.dir : {} ]", System.getProperty("user.dir"));


        log.info(">>>> tezt {}", HttpStatus.OK.name());
        log.info(">>>> tezt {}", HttpStatus.OK);

        System.out.println(LoginFailType.getFailType("NOT_REGISTER_MEMBERr"));

    }

    
}
