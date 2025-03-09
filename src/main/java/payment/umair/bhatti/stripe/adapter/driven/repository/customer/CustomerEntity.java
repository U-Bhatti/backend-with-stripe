package payment.umair.bhatti.stripe.adapter.driven.repository.customer;

import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Document;
import payment.umair.bhatti.stripe.core.model.Customer;
import payment.umair.bhatti.stripe.core.vocabulary.CustomerId;

@Slf4j
@Data
@Builder
@Document(collection = "customers")
public class CustomerEntity {

  @Id
  private UUID id;
  private String username;
  private String address;
  private String postalCode;
  private String city;

  public Customer toModel() {
    return Customer.builder()
        .id(CustomerId.from(getId()))
        .username(getUsername())
        .address(getAddress())
        .postalCode(getPostalCode())
        .city(getCity())
        .build();
  }

  public static CustomerEntity fromModel(Customer customer) {
    return CustomerEntity.builder()
        .id(customer.id().retrieveUUID())
        .username(customer.username())
        .address(customer.address())
        .postalCode(customer.postalCode())
        .city(customer.city())
        .build();
  }
}
