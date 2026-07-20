// You are playing a game. At each level of the game, you have to choose one of the roads to go to the next level. Initially, you have h amount of health and m amount of money.

// If you take the first road then health decreases by 20 and money increase by 5. 
// If you take the second road then your health decreases by 5 and money decrease by 10.
// If you take the third road then your health increases by 3 and money increase by 2.
// Determine the maximum number of levels that can be completed such that no two consecutive levels use the same road, and the game terminates as soon as health or money becomes ≤ 0.

class Solution {

    static int[][][] dp;

    static int[] dh = {-20, -5, 3};
    static int[] dm = {5, -10, 2};

    static int solve(int h, int m, int last) {

        if (h <= 0 || m <= 0)
            return 0;

        if (dp[h][m][last] != -1)
            return dp[h][m][last];

        int ans = 0;

        for (int road = 1; road <= 3; road++) {

            if (road == last)
                continue;

            int nh = h + dh[road - 1];
            int nm = m + dm[road - 1];

            ans = Math.max(ans, 1 + solve(nh, nm, road));
        }

        return dp[h][m][last] = ans;
    }

    static int maxLevel(int h, int m) {

        dp = new int[1005][1005][4];

        for (int i = 0; i < 1005; i++)
            for (int j = 0; j < 1005; j++)
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = -1;

        return solve(h, m, 0);
    }
}
public class maxLevel {
    public static void main(String[] args) {
        int h = 20, m = 8;
        System.out.println(Solution.maxLevel(h, m));
    }
}