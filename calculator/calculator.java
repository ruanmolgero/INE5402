/*
 * An object of this class is specialized in solving
 * diferent several math calculations.
 */
public class calculator
{    
    /**
     * Finds the smallest integer, given any three.
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
     * Verifies if the integer is even.
     *
     * @param n The number.
     * @return Return true if the n is even or false if n is odd.
     */
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * Verifies if an integer is bigger than other.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return true if the first integer (n1) is bigger than the second (n2), and return false if not.
     */
    public boolean isBigger(int n1, int n2) {
        return n1 > n2;
    }

    /**
     * Checks if an positive integer is divisible by another positive integer bigger than zero.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return true if the first integer (n1) is divisible by the second integer (n2).
     */
    public boolean isDivisible(int n1, int n2) {
        return n1 % n2 == 0;
    }

    /**
     * Multiplies two positive integers (greater than or equal to zero) without using the * symbol.
     *
     * @param n1 First integer.
     * @param n2 Second integer.
     * @return Return the result of the multiplication.
     */
    public int multiplies(int n1, int n2) {
        int i, temp = 0;
        
        //test for the biggest and smallest number between n1 and n2 # See teacher answers #
        
        for(i = 0; i<n1; i++)
            temp = temp + n2;
        
        return temp;
    }

    /**
     * Calculates the integer division of two positive integers without using the / symbol. Consider the second integer n2 always bigger than zero. 
     * Example: Dividing 6 by 3 should result 2; dividing 7 by 4 should result 1; 23 by 78 should result 0.
     *
     * @param n1 First integer (dividend).
     * @param n2 Second integer (divider).
     * @return Return the result of the division (n1 / n2).
     */
    public int divides(int n1, int n2) {
        int result = 0;
        
        while (!((n1 - n2) < 0))            //easier to understand if it is (n1 >= n2) # See teacher answers #
        {
            n1 = n1 - n2;
            result = result + 1;
        }
        
        return result;
    }
    
    /**
     * Checks if a year is a leap year (bissextile).
     *
     * @param year The year.
     * @return Return true if it is a leap year or false if not.
     */
    public boolean isLeapYear(int year) {
        return (isDivisible(year, 400) || 
               (isDivisible(year, 4) && !(isDivisible(year, 100))));
    }

    /** 
     * Calculates the greatest common divisor between two positive integers.
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
        } else {
            m1 = n2;
            m2 = n1;
        }
        
        remainder = m1%m2;
        temp = m2;
        
        //if(remainder == 0)                  //this program can be improved only by removing this if the same test is done on the while loop
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
        int result = n + 1, m = n/2;
        
        for(int i = 2; i <= m; i++)     //m is used in order to avoid doing useless calculations inside the for loop # See teacher answers #
        {
            if(n % i == 0)              //could be isDivisible(n,i) # See teacher answers #
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
     * Checks if an integer greater than zero is prime.
     *
     * @param n The number.
     * @return Returns true is the integer is prime or false if not.
     */
    public boolean isPrime  (int n) {
        int i, test = 0;
        
        for(i = 2; i <= n/2; i++)       //bad implementation, too much iteractions if n is too high # See teacher answers #
        {
            if(n % i == 0)
                test = test + 1;
        }
        
        return test == 0;
        
            
        //int i = 2, test = 0, m = n/2;
        
        //while((test == 0) || (i<=m))
        //{
        //    if(n % i == 0)
        //    {
        //        test = test + 1;
        //        i = i + 1;
        //    }
        //}
        
        //return test == 0;
        
    }

    /**
     * Checks if an integer greater than zero is composite.
     *
     * @param n The number.
     * @return Returns true if the integer is composite or false if not.
     */
    public boolean isComposite(int n) {
        return isPrime(n) == false;
    }
    
    /* TEACHER ANSWERS */
    
    /*
    public int multipliesTeacher(int n1, int n2) 
    {
        int result = 0, numberOfIteractions, numberToAdd;
        
        if(n1<n2)
        {
            numberOfIteractions = n1;
            numberToAdd = n2;
        } else {
            numberOfIteractions = n2;
            numberToAdd = n1;
        }
        
        for(int i = 1; i<=numberOfIteractions; i++)
            result = result + numberToAdd;
        
        return result;
    }   
    */
    
    /*
    public int dividesTeacher(int n1, int n2) 
    {
        int result = 0;
        
        while (n1 >= n2)
        {
            n1 = n1 - n2;
            result = result + 1;
        }
        
        return result;
    } 
    */
   
    /*
    public int dividersSumTeacher(int n) 
    {
        int result = n + 1, limit = n/2;
        
        for(int i = 2; i <= limit; i++)
            if(isDivisible(n,i))
                result = result + i;
        
        return result;
    }
    */
   
    
    public boolean isPrimeTeacher(int n)
    {
        boolean prime;
       
        if(n <= 3)
            prime = true;
        else
            if (n % 2 == 0)
                prime = false;
            else {
                prime = true;
                int limit = n/2;
                int i = 3;
                
                while(prime && i <= limit)
                    if(n % i == 0)
                        prime = false;
                    else
                        i = i + 2;
            }
        
        return prime;
    }
   
    /*
    public int calculateGCD(int n1, int n2) {
        int remainder, greater, smaller;
        if (n1 > n2) {
            greater = n1;
            smaller = n2;
        } else {
            greater = n2;
            smaller = n1;
        }
        do {
            remainder = greater % smaller;
            greater = smaller;
            smaller = remainder;
        } while (remainder != 0);
    return greater;
    }
    */
   
    /*
    public int calculateGCDTeacher(int n1, int n2) {
        int remainder, greater, smaller, gcd;
        if (n1 > n2) {
            greater = n1;
            smaller = n2;
        } else {
            greater = n2;
            smaller = n1;
        }
        
        remainder = greater % smaller;
        
        while(remainder!=0) {
            greater = smaller;
            smaller = remainder;
            remainder = greater % smaller;
        }
        
        gcd = smaller;
        
    return gcd;
    }
    */
}
