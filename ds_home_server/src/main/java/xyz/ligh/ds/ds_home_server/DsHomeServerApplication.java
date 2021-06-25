package xyz.ligh.ds.ds_home_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DsHomeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsHomeServerApplication.class, args);
	}

}
