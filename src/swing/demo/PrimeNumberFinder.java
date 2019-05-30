package swing.demo;

import java.util.BitSet;

/**
 * Outputs prime numbers <= the input parameter
 */
public class PrimeNumberFinder 
{
	public static void main(String[] args) 
	{
		String msg = "Please specify a positive number greater than 1";
		int max = 0;
		try 
		{
			max = Integer.parseInt(args[0]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
		{
			System.err.println(msg);
			return;
		}
		if (max < 2) 
		{
			System.err.println(msg);
			return;
		}
		new PrimeNumberFinder().generate(max);
	}

	/**
	 * Uses the sieve of Eratosthenes method to output prime numbers <= max
	 * @param max
	 */
	private void generate(int max) 
	{
		System.out.println("Prime numbers less than or equal to " + max + ":");
		BitSet found = new BitSet();
		System.out.println("2");
		int next = 3;
		while (next < max)
		{
			if (isPrime(next, found)) 
			{
				System.out.println(String.valueOf(next));
			}
			next += 2;
		}
	}

	/**
	 * Answers true, and adds candidate to the found set, if candidate is not divisible by any
	 * number in the found set, else answers false
	 * 
	 * @param candidate
	 * @param found
	 * @return
	 */
	private boolean isPrime(final int candidate, BitSet found) 
	{
		int divisor = found.nextSetBit(0);
		while (divisor != -1 && divisor * divisor <= candidate) 
		{
			if (candidate % divisor == 0) 
			{
				return false;
			}
			divisor = found.nextSetBit(++divisor);
		}
		
		/*
		 * no divisor found - we have a new prime
		 */
		found.set(candidate);
		return true;
	}
}
