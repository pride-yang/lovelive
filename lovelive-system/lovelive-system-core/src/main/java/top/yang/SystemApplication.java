package top.yang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class SystemApplication implements ApplicationRunner {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class);
        System.out.println("SystemApplication 启动成功");
    }

    @Override
    public void run(ApplicationArguments args) {
        String property = environment.getProperty("dubbo.registry.address");
        System.out.println(property);
    }
}
