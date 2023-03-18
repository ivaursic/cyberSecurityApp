package hr.csa.backend;

import hr.csa.backend.service.ThreatIntelligenceService;
import hr.csa.backend.service.UserAccountService;
import hr.csa.backend.service.impl.ThreatIntelligenceServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class BackendApplication {

	private static ThreatIntelligenceService threatIntelligenceService = new ThreatIntelligenceServiceJpa();
	@Bean
	public PasswordEncoder pswdEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				threatIntelligenceService.generateRandom();
			}
		}, 0, 10*1000);

	}

}
