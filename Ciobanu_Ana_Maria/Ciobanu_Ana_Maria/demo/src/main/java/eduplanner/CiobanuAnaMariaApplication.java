package eduplanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "controllers")
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "structures")
public class CiobanuAnaMariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiobanuAnaMariaApplication.class, args);
	}
	
}
