package payment.umair.bhatti.stripe.core.exception;

import lombok.Getter;

@Getter
public class BackendWithStripeException extends RuntimeException {

  private final ErrorCode code;

  public BackendWithStripeException(ErrorCode code) {
    super(code.description);
    this.code = code;
  }

  public BackendWithStripeException(ErrorCode code, String message) {
    super(message);
    this.code = code;
  }

  public BackendWithStripeException(ErrorCode code, String message, Throwable ex) {
    super(message, ex);
    this.code = code;
  }

  public BackendWithStripeException(ErrorCode code, Throwable ex) {
    super(code.description, ex);
    this.code = code;
  }

  @Override
  public String toString() {
    String s = getClass().getSimpleName();
    String message = getLocalizedMessage();
    return message == null
            ? String.format("%s [%s]", s, code)
            : String.format("%s [%s] - %s", s, code, message);
  }
}
