package top.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJdbcRepositories(basePackages = "top.yang.repository")
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class);
        System.out.println("SystemApplication 启动成功");
    }
}
