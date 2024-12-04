import java.util.regex.Pattern;

public class EmailValidator extends Validator<String>{
    private static final Pattern EMAIL =
            Pattern.compile("^[\\w-\\.+]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    @Override
    protected void doValidate(String email) throws ValidationException {
        if(!EMAIL.matcher(email).matches()){
            throw new ValidationException("Zły format email.");
        }
    }
}
