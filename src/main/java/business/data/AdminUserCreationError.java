package business.data;

public enum AdminUserCreationError {
    INVALID("Invalid"),
    PASSWORDS_DO_NOT_MATCH("Passwords do not match"),
    PASSWORD_MINIMUM_ONE_NUMBER("Your password must contain minimum 1 number"),
    SHOULD_HAVE_AT_LEAST_SEVEN_CHARACTERS("Should have at least 7 characters"),
    REQUIRED("Required"); // Added REQUIRED message

    private final String message;

    AdminUserCreationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
