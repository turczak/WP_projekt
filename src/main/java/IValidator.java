public interface IValidator<T> {
    void setNext(IValidator<T> next);
    void validate(T data) throws ValidationException;
}
