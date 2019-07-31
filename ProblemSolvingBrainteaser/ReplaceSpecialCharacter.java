package ProblemSolvingBrainteaser;

public class ReplaceSpecialCharacter {
	public static void main(String[] args) {

		String str = "hdjkqhd!@##f$;,+_^%()%$##^*~~````";

		System.out.println(str);

		str = str.replaceAll("[-+~!@#$%&*(;,_)`:><^]", "");
		System.out.println(str);

	}
}
