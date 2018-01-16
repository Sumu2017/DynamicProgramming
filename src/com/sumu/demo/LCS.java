package com.sumu.demo;

/**
 * 最长公共子序列
 * @author sumu
 *
 */
public class LCS {
	public static int LCS(String str1,String str2) {
		int str1Length=str1.length();
		int str2Length=str2.length();
		if (str1Length==0||str2Length==0) {
			//如果有一个字符串为0，那么这两个字符串的最长公共子序列就为0
			return 0;
		}
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		int [][] dp=new int[str1Length][str2Length];
		for (int i = 0; i < str2Length; i++) {//第一行
			if (charArray1[0]==charArray2[i]) {
				dp[0][i]=1;
				for (int j = i+1; j < str2Length; j++) {
					dp[0][j]=1;
				}
				break;
			}
		}
		
		for (int i = 0; i < str1Length; i++) {//第一列
			if (charArray2[0]==charArray1[i]) {
				dp[i][0]=1;
				for (int j = i+1; j < str1Length; j++) {
					dp[j][0]=1;
				}
				break;
			}
		}
		
		for (int i = 1; i < str1Length; i++) {
			for (int j = 1; j < str2Length; j++) {
				if (charArray1[i]==charArray2[j]) {
					//如果这两个字符相同，那么就等两个字符串加上该相同字符之前的最长公共子序列的长度加上1
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		printArray(dp);
		return dp[str1Length-1][str2Length-1];
	}
	
	public static void printArray(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int lcsLength = LCS.LCS("android", "random");
		System.out.println("最长公共子序列长度:"+lcsLength);
	}
}
