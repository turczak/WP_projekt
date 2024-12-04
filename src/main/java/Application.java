import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Application {
    public static void main(String[] args) {

        Validator<String> emailValidator = new EmailValidator();
        Validator<String> passwordValidator = new PasswordValidator();
        Validator<User> userValidator = new UserValidator(emailValidator, passwordValidator);

        IRegistrationService registrationService = new RegistrationServiceProxy(new RegistrationService(), userValidator);

        /*System.out.println("=========Z KLAWIATURY=========");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();

        System.out.println("Podaj email: ");
        String email = scanner.nextLine();

        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        User tester = new User(login, email, password);

        try {
            registrationService.register(tester);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
        }

        scanner.close();*/

        /*System.out.println("=====A TERAZ Z PLIKU JSON=====");

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File jsonFile = new File("src/main/java/user.json");
            List<User> usersFromJSON = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});
            ExecutorService executorService = Executors.newFixedThreadPool(4);

            for (User user: usersFromJSON){
                try{
                    registrationService.register(user);
                }catch (ValidationException e){
                    System.out.println("Złe dane użytkownika " + user.getLogin() + ", " + e.getMessage());
                }
            }

            executorService.shutdown();
            executorService.awaitTermination(3, TimeUnit.SECONDS);

            System.out.println("Pomyślnie dodano wszystkich użytkowników z pliku.");
        }catch (IOException e){
            System.out.println("Błąd odczytu pliku JSON. " + e.getMessage());
        }catch (InterruptedException e){
            System.out.println(e.getMessage());*/

        System.out.println("=========A TU Z PALCA=========");

        User testUser = new User("jankowalski", "jank@wp.pl", "@Password1");

        try {
            registrationService.register(testUser);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
        }

    }
}
