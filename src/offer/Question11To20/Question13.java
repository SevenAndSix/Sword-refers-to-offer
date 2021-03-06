package offer.Question11To20;

public class Question13 {
    //得到一个格子的位数之和
    public int getDigitSum(int number){
        int sum = 0;
        while(number > 0)
        {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    //判断机器人能否进入(raw,col)的格子
    public boolean check(int threshold, int rows, int cols, int row, int col,
               boolean[][] visited)
    {
        if(row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row][col])
            return true;

        return false;
    }


    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <= 0)
            return 0;

        boolean[][] visited = new boolean[rows][cols];

        int count = movingCountCore(threshold, rows, cols,
                0, 0, visited);

        return count;
    }

    public int movingCountCore(int threshold, int rows, int cols, int row,
                        int col, boolean[][] visited)
    {
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited))
        {
            visited[row][col] = true;

            count = 1 + movingCountCore(threshold, rows, cols,
                    row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols,
                    row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols,
                    row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols,
                    row, col + 1, visited);
        }

        return count;
    }
}

/*
*   Question13测试函数
*       Question13 question13=new Question13();
        System.out.println(question13.movingCount(4,4,5));
* */