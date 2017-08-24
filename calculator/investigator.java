
public class investigator
{   
    public int findFirstPrime(int n)        //finds first prime after integer n knowing that you can usa a calculator that can only find if an integer is prime
    {
        calculator c = new calculator();
        
        if(n != 2 && n % 2 == 0)            //tests if n is equal 2 (return n) && tests the parity of the number
            n = n + 1;
        
        while(c.isPrime(n) == false)
            n = n + 2;
        
        return n;
    }
    
    public int findPrimeN(int n, int number) //find the n-th prime starting from number
    {
        int result = findFirstPrime(number);            //execute the first iteraction
        n = n - 1;                                      //and decrement n
        
        for(int i = 1; i <= n; i++)                     //iteract through all the missing iteractions
        {
            result = this.findFirstPrime(result + 2);   //increment 2 because result is a prime, and the next prime is a minimum of (result + 2)
        }
        
        return result;
    }
}
