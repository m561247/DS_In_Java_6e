package Chapter9;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		return a.length() < b.length() ? -1 : (a.length() == b.length() ? 0 : 1);
	}
	
}
