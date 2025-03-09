package payment.umair.bhatti.stripe.adapter.driver.rest;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment.umair.bhatti.stripe.adapter.driver.web.security.StripeConfigProperties;
import payment.umair.bhatti.stripe.core.model.Customer;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final StripeConfigProperties stripeConfigProperties;

  public CustomerController(StripeConfigProperties stripeConfigProperties) {
    this.stripeConfigProperties = stripeConfigProperties;
  }

  @GetMapping
  public List<Customer> getAllBooks() {
//    log.debug("properties: ", stripeConfigProperties);
    System.out.println("Properties: " + stripeConfigProperties.toString());
    return List.of(Customer.builder().username("Working").build());
  }

}