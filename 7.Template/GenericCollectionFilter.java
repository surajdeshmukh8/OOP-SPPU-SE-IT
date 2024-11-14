/**7.Template -- CO4
Implement a generic program using any collection class to count the number of elements in a
collection that have a specific property such as even numbers, odd number, prime number and
palindromes.
*/


import java.util.*;
import java.util.function.Predicate;

public class GenericCollectionFilter {
    
    public static <T> int countIf(Collection<T> collection, Predicate<T> predicate) {
        int count = 0;
        for (T element : collection) {
            if (predicate.test(element)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(Integer number) {
        return number % 2 != 0;
    }

    public static boolean isPrime(Integer number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String value) {
        String reversed = new StringBuilder(value).reverse().toString();
        return value.equals(reversed);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(121, 22, 37, 45, 101, 12, 7, 19);
        
        int evenCount = countIf(numbers, GenericCollectionFilter::isEven);
        System.out.println("Even Numbers: " + evenCount);
        
        int oddCount = countIf(numbers, GenericCollectionFilter::isOdd);
        System.out.println("Odd Numbers: " + oddCount);
        
        int primeCount = countIf(numbers, GenericCollectionFilter::isPrime);
        System.out.println("Prime Numbers: " + primeCount);
        
        List<String> palindromes = Arrays.asList("121", "123", "131", "suraj", "deshmukh");
        
        int palindromeCount = countIf(palindromes, GenericCollectionFilter::isPalindrome);
        System.out.println("Palindrome Strings: " + palindromeCount);
    }
}
