package kalo.kaloAdmin_kalo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KaloAdminKaloApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaloAdminKaloApplication.class, args);
	}

}
