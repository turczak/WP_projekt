public class UserValidator extends Validator<User>{
    private final Validator<String> emailValidator;
    private final Validator<String> passwordValidator;

    public UserValidator(Validator<String> emailValidator, Validator<String> passwordValidator) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    protected void doValidate(User user) throws ValidationException {
        emailValidator.validate(user.getEmail());
        passwordValidator.validate(user.getPassword());
    }
}
