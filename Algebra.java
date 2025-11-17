public class Algebra {
	public static void main(String args[]) {
		System.out.println(plus(2, 3)); // 5
		System.out.println(minus(7, 2)); // 5
		System.out.println(minus(2, 7)); // -5
		System.out.println(times(3, 4)); // 12
		System.out.println(plus(2, times(4, 2))); // 10
		System.out.println(pow(5, 3)); // 125
		System.out.println(pow(3, 5)); // 243
		System.out.println(div(12, 3)); // 4
		System.out.println(div(25, 7)); // 3
		System.out.println(mod(25, 7)); // 4
		System.out.println(mod(120, 6)); // 0
		System.out.println(sqrt(36)); // 6
		System.out.println(sqrt(263169)); // 513
		System.out.println(sqrt(76123)); // 275
	}

	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			while (x2 != 0) {
				x1--;
				x2++;
			}
		} else {
			while (x2 != 0) {
				x1++;
				x2--;
			}
		}
		return x1;
	}

	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	public static int times(int x1, int x2) {
		boolean negative = false;
		if (x1 < 0) {
			x1 = -x1;
			negative = !negative;
		}
		if (x2 < 0) {
			x2 = -x2;
			negative = !negative;
		}
		int result = 0;
		while (x2 != 0) {
			result = plus(result, x1);
			x2 = minus(x2, 1);
		}
		if (negative)
			result = -result;
		return result;
	}

	public static int pow(int x, int n) {
		if (n == 0)
			return 1;
		int result = 1;
		while (n != 0) {
			result = times(result, x);
			n = minus(n, 1);
		}
		return result;
	}

	public static int div(int x1, int x2) {

		boolean negative = false;
		if (x1 < 0) {
			x1 = -x1;
			negative = !negative;
		}
		if (x2 < 0) {
			x2 = -x2;
			negative = !negative;
		}

		int result = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			result = plus(result, 1);
		}

		if (negative)
			result = -result;
		return result;
	}

	public static int mod(int x1, int x2) {

		boolean negative = x1 < 0;
		if (x1 < 0)
			x1 = -x1;
		if (x2 < 0)
			x2 = -x2;

		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}

		if (negative)
			x1 = -x1;
		return x1;
	}

	public static int sqrt(int x) {
		int guess = 0;
		while (times(guess, guess) <= x) {
			guess = plus(guess, 1);
		}
		return minus(guess, 1);
	}
}
