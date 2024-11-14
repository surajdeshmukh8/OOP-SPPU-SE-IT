/**1.Classes and object -- CO1 and CO2
Design a class ‘Complex ‘with data members for real and imaginary part. Provide default and
Parameterized constructors. Write a program to perform arithmetic operations of two complex
numbers */


public class ComplexNumber {
    // for real and imaginary parts of complex numbers
    double real, img;

    // constructor to initialize the complex number
    ComplexNumber(double r, double i) {
        this.real = r;
        this.img = i;
    }

    // method to sum two complex numbers
    public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
        // creating a temporary complex number to hold the sum of two numbers
        ComplexNumber temp = new ComplexNumber(0, 0);
        temp.real = c1.real + c2.real;
        temp.img = c1.img + c2.img;
        // returning the output complex number
        return temp;
    }

    public static void main(String args[]) {
        ComplexNumber c1 = new ComplexNumber(5.5, 4);
        ComplexNumber c2 = new ComplexNumber(1.2, 3.5);
        ComplexNumber temp = sum(c1, c2);

        // formatting the output with a proper sign for the imaginary part
        //System.out.printf("Sum is: %.2f + %.2fi", temp.real, temp.img);
        System.out.println("Sum is " + temp.real + " + " + temp.img + "i");
    }
}

