/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);

		s1 = removeSpaces(s1);
		s2 = removeSpaces(s2);

		if (s1.length() != s2.length()) {
			return false;
		}

		char[] arr2 = s2.toCharArray();

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			boolean found = false;

			for (int j = 0; j < arr2.length; j++) {
				if (arr2[j] == c) {
					arr2[j] = '\0';
					found = true;
					break;
				}
			}

			if (!found) {
				return false;
			}
		}

		return true;
	}

	private static String removeSpaces(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				result += s.charAt(i);
			}
		}
		return result;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String formattedStr = "";
		int a = (int) 'a';
		int z = (int) 'z';
		int A = (int) 'A';
		int Z = (int) 'Z';
		int deltaA = a - A;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int code = (int) ch;

			if (code >= A && code <= Z) {
				formattedStr += (char) (code + deltaA);
			} else if (code >= a && code <= z) {
				formattedStr += ch;
			} else if (ch == ' ') {

				formattedStr += ' ';
			}
		}

		return formattedStr;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String s = str;
		String result = "";

		while (s.length() > 0) {
			int index = (int) (Math.random() * s.length());
			result += s.charAt(index);
			s = s.substring(0, index) + s.substring(index + 1);
		}

		return result;
	}
}
