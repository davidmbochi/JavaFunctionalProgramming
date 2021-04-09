package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09009877300"));


        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877300"));

        //chaining predicates
        System.out.println("chaining predicates");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000"));
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
