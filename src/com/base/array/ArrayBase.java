package com.base.array;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayBase {

	static int[] a = {64, 34, 25, 12, 22, 11, 90};

	public static void main(String[] args) {
		// rotateArray(a, 2);
		// maxSubArray(a);
		// char[] st = { 'a', 'b', 'c', ' ', 'd' };
		// replaceSpace(st);
		// String st1 = "Love";
		// String st2 = "Lov";
		// isOneEditAway(st1.toCharArray(), st2.toCharArray());
		bubbleSort(a);
	}

	private static void rotateArray(int[] ar, int position) {

		if (ar.length == 0)
			return;
		if (ar.length == 1)
			System.out.println(ar);

		int n = ar.length - 1;
		rotateinplace(ar, 0, n - position);
		rotateinplace(ar, (n - position) + 1, n);
		rotateinplace(ar, 0, n);

		System.out.println(ar);
	}

	private static void rotateinplace(int[] a, int i, int j) {
		while (i <= j) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			i++;
			j--;
		}
	}

	private static void maxSubArray(int[] a) {
		int max = 0;
		int ex = 0;
		int s = 0;
		int start = 0;
		int end = 0;
		HashMap<Point, Integer> maxSubset = new HashMap<>();

		ex = a[0];
		for (int i = 0; i < a.length; i++) {
			max = max + a[i];
			if (max > ex) {
				ex = max;
				start = s;
				end = i;
			}
			if (max < 0) {
				max = 0;
				System.out.println("Max so far:" + ex + "between (" + start + ":" + end + ")");
				maxSubset.put(new Point(start, end), ex);
				s = i + 1;
			}
		}
		maxSubset.put(new Point(start, end), ex);
		System.out.println("Final Max :" + ex + "between (" + start + ":" + end + ")");
	}

	private static char[] replaceSpace(char[] str) {

		System.out.println("love" + str.length);
		str = Arrays.copyOf(str, 20);
		System.out.println("lou" + str.length);
		return str;
	}

	// hello, hello
	// love, lov
	// smile, mmile
	// rule, drule
	private static void isOneEditAway(char[] a, char[] b) {

		// 0 or 1 insert
		// 0 or 1 edit
		// 0 or 1 delete

		boolean isInsert = false;
		boolean isEdit = false;
		boolean isDelete = false;
		boolean isDiff = false;

		if (a.length - b.length > 1) {
			System.out.println("False");
			return;
		}

		if (a.length - b.length == 1)
			isDiff = true;

		int p = a.length - 1;
		int q = b.length - 1;

		while (p <= a.length - 1 && q <= b.length - 1) {
			if ((isEdit && isInsert) || (isEdit && isDelete) || (isInsert && isDelete)
					|| (isInsert && isDelete && isEdit)) {
				System.out.println("Not One edit away!");
				break;
			}
			if (a[p] != b[q]) {
				if (isEdit) {
					isInsert = true;
				}
				isEdit = true;
				q++;
			} else {
				if (p == a.length - 1 || q == b.length - 1) {
					System.out.println("They are 1 or 0 edit away!");
					break;
				}
				q++;
				p++;
			}
		}
	}

	private static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Sorted: "+ Arrays.toString(a));
	}

}
