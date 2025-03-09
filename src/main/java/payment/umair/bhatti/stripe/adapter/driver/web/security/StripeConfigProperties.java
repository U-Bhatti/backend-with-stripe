package payment.umair.bhatti.stripe.adapter.driver.web.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("stripe")
public record StripeConfigProperties(String stripeSecretKey, String stripeWebHookKey) {

}
