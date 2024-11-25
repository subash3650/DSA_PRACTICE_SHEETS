import java.io.*;
class Edit
{
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int T = Integer.parseInt(br.readLine().trim());
while (T-- > 0) {
String s1 = br.readLine();
String s2 = br.readLine();
Solution ob = new Solution();
int ans = ob.editDistance(s1, s2);
System.out.println(ans);
}
}
}
class Solution {
public int editDistance(String str1, String str2) {
int m = str1.length();
int n = str2.length();
int[][] dp = new int[m+1][n+1];
for(int i=0;i<=m;i++)
dp[i][0] = i;
for(int j=0;j<=n;j++)
dp[0][j] = j;

for(int i=1;i<=m;i++){
for(int j=1;j<=n;j++){
if(str1.charAt(i-1)==str2.charAt(j-1))
dp[i][j] = dp[i-1][j-1];
else
dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
}
}
return dp[m][n];
}
}