package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+0898787879878",
                LocalDate.of(2000,1,1)
        );

//        CustomerValidatorService validatorService=
//                new CustomerValidatorService();
//        boolean valid = validatorService.isValid(customer);
//        System.out.println(valid);

        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
