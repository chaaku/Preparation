package ProblemSolvingBrainteaser;

public class NextHigherBitDecimalEqual1 {

	public static void main(String[] args) {
		int a = 455;

		String bits = changeBaseToStringBits(a, 2);
		System.out.println("a is " + a + " in bits: " + bits);

		int nextHighestWithSameOnes = getNextHighestWithSameOnes(a);

		String bits2 = changeBaseToStringBits(nextHighestWithSameOnes, 2);
		System.out.println(nextHighestWithSameOnes + " in bits is:   " + bits2);
	}

	private static int getNextHighestWithSameOnes(int a) {
		String bits = changeBaseToStringBits(a, 2);

		// look for one on whose left we have zero, if found swap it. cosolidate all the
		// ones on the right of it to the extreme right, bubbling up the ones.
		// if we reach end, then add extra character:=> 1xxx=> 10xxx, corresponds to 111
		// => 1011, 1110 => 10011

		int i = bits.length() - 1;
		int numberOfOnesEncountered = 0;
		while (i >= 0) {
			if (i > 0 && bits.charAt(i) == '1' && bits.charAt(i - 1) == '0') {
				// swap i and i-1
				if (i != bits.length() - 1)
					bits = bits.substring(0, i - 1) + "10" + bits.substring(i + 1);
				else
					bits = bits.substring(0, i - 1) + "10";
				break;
			}
			// all 1111's
			// or 1 at the end like: 111000
			// transform to 111 => 1011 and 111000 ==> 1011000
			if (i == 0 && bits.charAt(i) == '1') {
				bits = "10" + bits.substring(1);
				i = 1;
				break;
			}
			if (bits.charAt(i) == '1')
				numberOfOnesEncountered++;
			i--;
		}
		// 101100 => 110100 ==> 110001
		// so basically move the i back and determine how many 1's you encounter.
		int numberOfZeroesNeeded = (bits.length() - i) - numberOfOnesEncountered; // 100110 => 101010 6 - 3 - 1 = 2

		// now recreate bis add zeroes and ones as needed.
		bits = bits.substring(0, i);
		// add zeroes
		for (; numberOfZeroesNeeded > 0; numberOfZeroesNeeded--, bits += "0")
			;
		for (; numberOfOnesEncountered > 0; numberOfOnesEncountered--, bits += "1")
			;

		int newNumber = convertBitStringToNum(bits);
		return newNumber;
	}

	private static int convertBitStringToNum(String bits) {
		int newNumber = 0;
		int base = 1;
		for (int i = bits.length() - 1; i >= 0; i--, base *= 2) {
			if (bits.charAt(i) == '1') {
				newNumber += base;
			}
		}
		return newNumber;
	}

	private static String changeBaseToStringBits(int a, int base) {
		String bits = "";
		while (a > 0) {
			bits = a % base + bits;
			a = a / base;
		}
		return bits;
	}

}