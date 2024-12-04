public class PasswordValidator extends Validator<String> {
    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    protected void doValidate(String password) throws ValidationException {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new ValidationException(
                    "Hasło zbyt krótkie, musi być długie na minimum "
                            + MIN_PASSWORD_LENGTH
                            + " znaków.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new ValidationException("Hasło musi zawierać co najmniej jedną cyfrę.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new ValidationException("Hasło musi zawierać co najmniej jedną wielką literę.");
        }

        boolean hasSpecialCharacter = password.chars()
                .anyMatch(
                        c -> (c >= 33 && c <= 47) // od ! do /
                                || (c >= 58 && c <= 64) // od : do @
                                || (c >= 91 && c <= 96) // od [ do `
                                || (c >= 123 && c <= 126) // od { do ~
                );
        if(!hasSpecialCharacter){
            throw new ValidationException("Hasło musi zawierać co najmniej jeden znak specjalny.");
        }
    }
}
