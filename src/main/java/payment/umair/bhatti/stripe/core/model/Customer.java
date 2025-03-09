package payment.umair.bhatti.stripe.core.model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import payment.umair.bhatti.stripe.core.vocabulary.CustomerId;

@Slf4j
@Builder
public record Customer(
    CustomerId id,
    String username,
    String address,
    String postalCode,
    String city
) {

}
