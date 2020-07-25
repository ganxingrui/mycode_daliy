package com.daliy.leetcode;

/**
 * @author Lenovo
 * @date 2020/1/11 23:35
 */
class Solution {

	public static void main(String[] args) {
		char[][] arr = {{'.','.','.','.','5','.','.','1','.'},
				{'.','4','.','3','.','.','.','.','.'},
				{'.','.','.','.','.','3','.','.','1'},
				{'8','.','.','.','.','.','.','2','.'},
				{'.','.','2','.','7','.','.','.','.'},
				{'.','1','5','.','.','.','.','.','.'},
				{'.','.','.','.','.','2','.','.','.'},
				{'.','2','.','9','.','.','.','.','.'},
				{'.','.','4','.','.','.','.','.','.'}};
		System.out.println(isValidSudoku(arr));
	}
	public static boolean isValidSudoku(char[][] board) {
		int[] res = new int[9];
		//遍历每一行进行检测
		for (int i = 0; i < board.length; i++) {
			//遍历9*9，改变位图结果
			for (int j = 0; j < board.length; j++) {
				if (!add(res,board[i][j])) {
					return false;
				}
			}
			//清空位图结果
			clear(res);
		}
		//遍历每一列进行检测
		for (int i = 0; i < board.length; i++) {
			//遍历9*9，改变位图结果
			for (int j = 0; j < board.length; j++) {
				if (!add(res,board[j][i])) {
					return false;
				}
			}
			//清空位图结果
			clear(res);
		}
		//3*3扫描
		int count = 0;
		int i = 0;
		int j = 0;
		int hNum = 3;
		int lNum = 3;
		while(count <9){
			for (; i < hNum; i++) {
				for (; j < lNum; j++) {
					if (!add(res,board[i][j])) {
						return false;
					}
				}
				if (i<3){
					j = 0;
				}else if (i <6){
					j = 3;
				}else {
					j = 6;
				}
			}
			//清空位图结果
			clear(res);
			count++;
			if (count % 3 == 0){
				i = 0;
				lNum  = lNum + 3;
			}else {
				j = 0;
				hNum = hNum + 3;
			}
		}
		return true;
	}
	//当前位置为1，则返回false
	private static boolean add(int[] arr,char index) {
		if(index != '.'){
			int index2 = Integer.parseInt(index+"");
			if (arr[index2-1] != '.'){
				if(arr[index2-1] == 1){
					return false;
				}else {
					arr[index2-1] = 1;
				}
			}
			return true;
		}
		return true;
	}

	public static void clear(int[] res){
		for (int j = 0; j < 9; j++) {
			res[j] = 0;
		}
	}

}