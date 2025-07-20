package DynamicProgramming.grids;

public class NinjaTraining {
    public static int ninjaTraining(int n, int[][] points){
        Integer[][] dp = new Integer[n][4];
        return solve(n - 1, 3, points, dp);
    }

    public static int solve(int day, int lastTask, int[][] points, Integer[][] dp){
        if(day == 0){
            int max = 0;
            for(int task = 0; task < 3; task++){
                if(task != lastTask){
                    max = Math.max(max, points[0][task]);
                }
            }
            return max;
        }

        if(dp[day][lastTask] != null) return dp[day][lastTask];

        int max = 0;
        for(int task = 0; task < 3; task++){
            if(task != lastTask){
                int pointsEarned = points[day][task] + solve(day - 1, task, points, dp);
                max = Math.max(max, pointsEarned);
            }
        }

        return dp[day][lastTask] = max;
    }

    public static void main(String[] args) {
        int[][] points = {
                {10, 50, 1},
                {5, 100, 11},
                {20, 5, 111}
        };
        System.out.println(ninjaTraining(points.length, points)); // Output: 221
    }
}
