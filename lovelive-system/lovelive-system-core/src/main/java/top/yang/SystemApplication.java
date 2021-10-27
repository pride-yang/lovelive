package top.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(SystemApplication.class);
    System.out.println("SystemApplication 启动成功");
  }
}