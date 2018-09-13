package com.base.dp;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DynamicPOperation {

	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	ArrayList<Point> gridPath = new ArrayList<>();
	boolean[][] hasVisited;

	public int countNWays(int n) {

		if (arrayList.get(n) != null)
			return arrayList.get(n);

		if (n <= 1) {
			return arrayList.get(n);
		}

		arrayList.add(n - 1, countNWays(n - 1));
		arrayList.add(n - 2, countNWays(n - 2));
		arrayList.add(n - 3, countNWays(n - 3));

		return arrayList.get(n - 1) + arrayList.get(n - 2) + arrayList.get(n - 3);
	}

	public void findPath(int[][] grid, int r, int c) {
		hasVisited = new boolean[grid.length][grid.length];
		findPathinGrid(grid, r, c);

	}

	private void findPathinGrid(int[][] grid, int r, int c) {

		if ((grid.length == 0 && grid.length == 0) || (grid.length == 1 && grid.length == 1))
			return;

		if (grid[r][c] == 0)
			return;

		if (r > grid.length || c > grid.length)
			return;

		if (grid[r][c] == 1) {
			gridPath.add(new Point(r, c));
			hasVisited[r][c] = true;
			if (r == grid.length - 1 && c == grid.length - 1) {
				System.out.println("Reached end of grid");
				for (Point p : gridPath) {
					System.out.println("(x:" + p.getX() + ", y:" + p.getY() + ")");
				}
				return;
			}
			if (r + 1 < grid.length && grid[r + 1][c] == 1 && !hasVisited[r + 1][c]) {
				findPathinGrid(grid, r + 1, c);
			} else if (r - 1 >= 0 && grid[r - 1][c] == 1 && !hasVisited[r - 1][c]) {
				findPathinGrid(grid, r - 1, c);
			}
			if (c + 1 < grid.length && grid[r][c + 1] == 1 && !hasVisited[r][c + 1]) {
				findPathinGrid(grid, r, c + 1);
			} else if (c - 1 >= 0 && grid[r][c - 1] == 1 && !hasVisited[r][c - 1]) {
				findPathinGrid(grid, r, c - 1);
			}
		}
	}

	public int findMagixIndexDuplicate(int[] arr, int s, int e) {
		if (s > e)
			return -1;

		int m = (s + e) / 2;

		if (arr[m] == m)
			return m;

		int l = Math.min(m - 1, arr[m]);
		int left = findMagixIndexDuplicate(arr, s, l);
		System.out.println("left:" + left);
		if (left >= 0)
			return left;

		int r = Math.max(m + 1, arr[m]);
		return findMagixIndexDuplicate(arr, r, e);
	}

	ArrayList<String> subsets = new ArrayList<String>();
	ArrayList<String> subsetMaster = new ArrayList<String>();

	/**
	 * 
	 * @param set
	 * @param index
	 * @return
	 */
	public ArrayList<String> subset(ArrayList<String> set, int index) {
		if (index == 0) {
			subsets.add("");
		} else if (index == 1) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i <= 1; i++) {
				sb.append(set.get(i));
				subsets.add(set.get(i));
			}
			subsets.add(sb.toString());
		} else if (index > 2) {
			for (int i = 0; i < 2; i++) {
				subsets = subset(set, i);
			}
			subsetMaster = new ArrayList<String>(subsets);
			for (int i = 2; i < set.size(); i++) {
				for (int j = 0; j < subsets.size(); j++) {
					StringBuffer sb = new StringBuffer();
					sb.append(subsets.get(j));
					sb.append(set.get(i));
					subsetMaster.add(sb.toString());
				}
				subsets = new ArrayList<String>(subsetMaster);
			}
			return subsetMaster;
		}
		return subsets;
	}

	private HashSet<String> stringPerumtations = new HashSet<>();

	public void getPerumutation(String str) {
		generatePerumtation(str, 0, str.length() - 1);
		System.out.println(stringPerumtations);
	}

	private void generatePerumtation(String str, int l, int r) {
		if (l == r)
			stringPerumtations.add(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				generatePerumtation(str, l + 1, r);
			}
		}
	}

	private String swap(String st, int a, int b) {
		char[] ch = st.toCharArray();
		char t = ch[a];
		ch[a] = ch[b];
		ch[b] = t;
		return String.valueOf(ch);
	}

	public int lcs(int[] a, int[] b, int iSt, int jSt) {

		if (iSt == a.length|| jSt == b.length) {
			return 0;
		}

		if (a[iSt] == b[jSt])
			return 1 + lcs(a, b, iSt + 1, jSt + 1);

		return Math.max(lcs(a, b, iSt + 1, jSt), lcs(a, b, iSt, jSt + 1));
	}

}
