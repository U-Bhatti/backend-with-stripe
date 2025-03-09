package payment.umair.bhatti.stripe.core.vocabulary;

import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.codec.StandardStringCodec;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.springframework.lang.NonNull;
import payment.umair.bhatti.stripe.core.exception.BackendWithStripeException;

import static payment.umair.bhatti.stripe.core.exception.ErrorCode.INVALID_ID;

@EqualsAndHashCode
public abstract class BaseId {

  private static final String SEPARATOR = ":";

  public static UUID generateUUIDv7() {
    return UuidCreator.getTimeOrderedEpoch();
  }

  static UUID uuidFromString(String uuid) {
    return StandardStringCodec.INSTANCE.decode(uuid);
  }

  @NonNull
  private final UUID id;
  @EqualsExclude
  private final String prefix;

  protected BaseId(@NonNull UUID id, @NonNull String prefix) {
    this.id = id;
    this.prefix = prefix + SEPARATOR;
  }

  public String retrieveUuidAsString() {
    return id.toString();
  }

  public UUID retrieveUUID() {
    return id;
  }

  @Override
  public String toString() {
    return prefix + id;
  }

  protected static <T extends BaseId> T from(@NonNull UUID id, @NonNull IdFactory<T> factory) {
    return factory.create(id);
  }

  protected static <T extends BaseId> T fromString(@NonNull String id, @NonNull IdFactory<T> factory) {
    try {
      return factory.create(uuidFromString(id));
    } catch (Exception e) {
      throw new BackendWithStripeException(INVALID_ID, String.format("Invalid id: %s", e));
    }
  }

  protected static <T extends BaseId> T create(@NonNull IdFactory<T> factory) {
    return factory.create(generateUUIDv7());
  }

  @FunctionalInterface
  public interface IdFactory<T extends BaseId> {

    T create(UUID id);
  }
}
