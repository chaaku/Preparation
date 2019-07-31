package ProblemSolvingBrainteaser;

public class PatternSearchInString {

	public static void main(String[] args) {

		String txt = "AABAACAADAABAAABAA";
		String pat = "AAB";

		System.out.print("Pattern found at : ");
		NaivefindIndexes(txt, pat);
	}

	private static void NaivefindIndexes(String txt, String pat) {

		int m = pat.length();
		int n = txt.length();

		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == m)
				System.out.print(i + " ");
		}
	}

}
