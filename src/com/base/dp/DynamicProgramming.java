package com.base.dp;

public class DynamicProgramming {

	private static int[][] grid = new int[5][5];

	public static void main(String[] args) {
		DynamicPOperation pOperation = new DynamicPOperation();
		// ***** Jump for destination.
		// System.out.println("Number of ways to jump 10 steps: " +
		// pOperation.countNWays(5));
		// ***** GRID Robot navigation.
		// pOperation.findPath(getGrid(), 0, 0);
		// ***** Search for magic index in array.
		// int[] array = { -10, -5, -1, 2, 3, 5, 6, 50, 100 };
		// System.out.println("Magic index is: " +
		// pOperation.findMagixIndexDuplicate(array, 0, array.length - 1));
		// ***** Give subset.
		// ArrayList<String> set = new ArrayList<>();
		// set.add("a");
		// set.add("b");
		// set.add("c");
		// set.add("d");
		// System.out.println("Subsets of set{a,b,c} are: " + pOperation.subset(set,
		// set.size()).toString());
		// ***** .
		// pOperation.getPerumutation("ABC");
		// ***** Find LCS
		int[] a = { 1, 2, 4, 5, 0 };
		int[] b = { 2, 5, 0 };
		System.out.println("LCS: " + pOperation.lcs(a, b, 0, 0));
	}

	private static int[][] getGrid() {
		// Row 1
		grid[0][0] = 1;
		grid[0][1] = 0;
		grid[0][2] = 1;
		grid[0][3] = 1;
		grid[0][4] = 1;

		// Row 2
		grid[1][0] = 1;
		grid[1][1] = 0;
		grid[1][2] = 1;
		grid[1][3] = 0;
		grid[1][4] = 1;

		// Row 3
		grid[2][0] = 1;
		grid[2][1] = 0;
		grid[2][2] = 1;
		grid[2][3] = 0;
		grid[2][4] = 1;

		// Row 4
		grid[3][0] = 1;
		grid[3][1] = 0;
		grid[3][2] = 1;
		grid[3][3] = 0;
		grid[3][4] = 1;

		// Row 5
		grid[4][0] = 1;
		grid[4][1] = 1;
		grid[4][2] = 1;
		grid[4][3] = 0;
		grid[4][4] = 1;

		return grid;
	}

}
