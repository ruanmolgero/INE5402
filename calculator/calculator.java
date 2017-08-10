/*
 * An object of this class is specialized in solving
 * diferent several math calculations.
 */
public class calculator
{
    /**
     * Find the smallest integer, given any three.
     * 
     * @param n1 First integer.
     * @param n2 Second integer.
     * @param n3 Third integer.
     * @return Return the smallest number.
     */
    public int findSmaller(int n1, int n2, int n3) {
        int smaller = n1;
        
        if (n2 < smaller)
            smaller = n2;
        if (n3 < smaller)
            smaller = n3;
        
        return smaller;
    }   

    /**
     * Calculates the arithmetic mean of any three given integers.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @param n3 Third integer.
     * @return Return the float value of the mean.
     */
    public float calculateMean(int n1, int n2, int n3) {
        return (n1 + n2 + n3) / 3.0f;
    }

    /**
     * Calculates the sum of three given integers.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @param n3 Third integer.
     * @return Return the sum value.
     */
    public int calculateSum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    /**
     * Verify if the integer is even.
     *
     * @param n The number.
     * @return Return true if the n is even or false if n is odd.
     */
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * Verify if an integer is bigger than other.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return true if the first integer (n1) is bigger than the second (n2), and return false if not.
     */
    public boolean isBigger(int n1, int n2) {
        return n1 > n2;
    }

    /**
     * Verify if an positive integer is divisible by another positive integer bigger than zero.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return true if the first integer (n1) is divisible by the second integer (n2).
     */
    public boolean isDivisible(int n1, int n2) {
        return n1 % n2 == 0;
    }

    /**
     * Multiply two positive integers (greater than or equal to zero) without using the * symbol.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return the result of the multiplication.
     */
    public int multiply(int n1, int n2) {
        int i, temp = 0;        
        
        if ((n1 == 0 ) || (n2 == 0))
            return 0;
        
        for(i = 0; i<n1; i++)
            temp = temp + n2;
        
        return temp;
    }

    /**
     * Calculate the integer division of two positive integers without using the / symbol. Consider the second integer n2 always bigger than zero. 
     * Example: Dividing 6 by 3 should result 2; dividing 7 by 4 should result 1; 23 by 78 should result 0.
     *
     * @param n1 First integer (dividend).
     * @param n2 Second integer (divider).
     * @return Return the result of the division (n1 / n2).
     */
    public int divide(int n1, int n2) {
        int result = 0, temp = n1;
        
        while (!((temp - n2) < 0))
        {
            temp = temp - n2;
            result = result + 1;
        }
        
        return result;
    }

    /**
     * Verify if a year is a leap year (bissextile).
     *
     * @param year The year.
     * @return Return true if it is a leap year or false if not.
     */
    public boolean isLeapYear(int year) {
        return (isDivisible(year, 400) || 
               (isDivisible(year, 4) && !(isDivisible(year, 100)))) ;
    }

    /**
     * Calculate the greatest common divisor between two positive integers.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return the greatest common divisor between the two numbers.
     */
    public int calculateGCD(int n1, int n2) {
        int m1, m2, result = 0, remainder, divider, temp;
        
        if(n1>n2)
        {
            m1 = n1;
            m2 = n2;
        } 
        else 
        {
            m1 = n2;
            m2 = n1;
        }
        
        remainder = m1%m2;
        temp = m2;
        
        if(remainder == 0)
            result = temp;
        
        while(remainder != 0)
        {
            divider = remainder;
            remainder = temp % divider;
            temp = divider;
            result = divider;
        }
        
        return result;
    }

    /**
     * Calculates the sum of all dividers of a positive integer.
     *
     * @param n The number.
     * @return Returns the sum.
     */
    public int dividersSum(int n) {
        int i, result = 0;
        
        for(i = 1; i <= n; i++)
        {
            if(n % i == 0)
                result = result + i;
        }
        
        return result;
    }

    /**
     * Checks if two integers are friends.
     *
     * @param n1 The first integer.
     * @param n2 The second integer.
     * @return Returns true if both integers are friends and false if not.
     */
    public boolean areFriends(int n1, int n2) {
        return ((dividersSum(n1) - n1 == n2) && (dividersSum(n2) - n2 == n1));
    }

    /**
     * Verifica se um número maior que zero é primo.
     *
     * @param n O número.
     * @return Retorna true se o número for primo ou false caso contrário.
     */
    /*public boolean isPrime  (int n) {
        int i;
        
        for(i = 2; i <= n/2; i++)
        {
            
        }
        
        return false;
    }*/

    /**
     * Verifica se um número maior que zero é composto.
     *
     * @param n O número.
     * @return Retorna true se o número for composto ou false caso contrário.
     */
    /*public boolean isComposite(int n) {
        return isPrime(n) == false;
    }*/
}
