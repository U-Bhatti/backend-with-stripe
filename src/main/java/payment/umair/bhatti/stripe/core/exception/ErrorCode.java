package payment.umair.bhatti.stripe.core.exception;

public enum ErrorCode {

  INVALID_ID("BWS0001", "Can not pass an invalid id"),;

  final String code;
  final String description;

  ErrorCode(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
