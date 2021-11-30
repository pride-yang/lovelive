package top.yang.financial.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinancialGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialGatewayApplication.class, args);
        System.out.println("gateway 启动成功");
    }

}
