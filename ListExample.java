import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(final String[] args) {
		// sample CSV strings...pretend they came from a file
		String[] csvStrings = new String[] { "abc,def,ghi,jkl,mno", "pqr,stu,vwx,yz", "123,345,678,90" };

		List<List<String>> csvList = new ArrayList<List<String>>();

		// pretend you're looping through lines in a file here
		for (String line : csvStrings) {
			String[] linePieces = line.split(",");
			List<String> csvPieces = new ArrayList<String>(linePieces.length);
			for (String piece : linePieces) {
				csvPieces.add(piece);
			}
			csvList.add(csvPieces);
		}

		// write the CSV back out to the console
		for (List<String> csv : csvList) {
			// dumb logic to place the commas correctly
			if (!csv.isEmpty()) {
				System.out.print(csv.get(0));
				for (int i = 1; i < csv.size(); i++) {
					System.out.print("," + csv.get(i));
				}
			}
			System.out.print("\n");
		}
	}
}
