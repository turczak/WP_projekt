public abstract class Validator<T> implements IValidator<T> {
    private IValidator<T> next;

    @Override
    public void setNext(IValidator<T> next) {
        this.next = next;
    }

    @Override
    public void validate(T data) throws ValidationException {
        doValidate(data);
        if(next != null){
            next.validate(data);
        }
    }

    protected abstract void doValidate(T data) throws ValidationException;
}
