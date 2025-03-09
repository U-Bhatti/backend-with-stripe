package payment.umair.bhatti.stripe.core.vocabulary;

import java.util.UUID;
import org.springframework.lang.NonNull;

public class CustomerId extends BaseId {

  private static final String PREFIX = "CUSTOMER";

  private CustomerId(@NonNull UUID id) {
    super(id, PREFIX);
  }

  public static CustomerId from(@NonNull UUID id) {
    return BaseId.from(id, CustomerId::new);
  }

  public static CustomerId fromString(@NonNull String id) {
    return BaseId.fromString(id, CustomerId::new);
  }

  public static CustomerId create() {
    return BaseId.create(CustomerId::new);
  }
}