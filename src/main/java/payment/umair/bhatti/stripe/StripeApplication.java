package payment.umair.bhatti.stripe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import payment.umair.bhatti.stripe.adapter.driver.web.security.StripeConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(StripeConfigProperties.class)
public class StripeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StripeApplication.class, args);
	}

}
