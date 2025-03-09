package payment.umair.bhatti.stripe.adapter.driven.repository.customer;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, UUID> {
  // Custom query methods (if needed) can be defined here
}
