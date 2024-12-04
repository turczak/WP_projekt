public class RegistrationServiceProxy implements IRegistrationService {
    private final IRegistrationService registrationService;
    private final Validator<User> validatorChain;

    public RegistrationServiceProxy(IRegistrationService registrationService, Validator<User> validatorChain) {
        this.registrationService = registrationService;
        this.validatorChain = validatorChain;
    }

    @Override
    public void register(User user) throws ValidationException {
        validatorChain.validate(user);
        registrationService.register(user);
    }
}
