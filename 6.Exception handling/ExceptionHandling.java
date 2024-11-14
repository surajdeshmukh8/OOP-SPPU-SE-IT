/**6.Exception handling -- CO4
Implement a program to handle Arithmetic exception, Array Index Out of Bounds. The user enters
two numbers Num1 and Num2. The division of Num1 and Num2 is displayed. If Num1 and Num2
are not integers, the program would throw a Number Format Exception. If Num2 were zero, the
program would throw an Arithmetic Exception. Display the exception.*/


import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter first no.");
            String input1 = sc.nextLine();
            System.out.println("Enter second no.");
            String input2 = sc.nextLine();
            
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            int result = num1 / num2;
            System.out.println(num1 + " / " + num2 + " : " + result);
            
            int arr[] = {10, 20, 30};
            System.out.println("Enter the index of element to be found");
            int key = sc.nextInt();
            System.out.println(arr[key]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Both numbers are not valid integers");
        } catch (ArithmeticException e) {
            System.out.println("Error: Can't divide by zero");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of range");
        } finally {
            System.out.println("Program executed successfully");
        }
    }
}
