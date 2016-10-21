import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/10/6.
 */

@SpringBootApplication
@ComponentScan({"com.fc","com.hzit.controller","com.hzit.services"})
@MapperScan("com.hzit.mapper")
public class Starapplication extends SpringBootServletInitializer {
}
