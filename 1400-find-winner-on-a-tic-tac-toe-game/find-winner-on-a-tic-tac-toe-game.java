class Solution {
     public String tictactoe(int[][] moves) {
        // 8 tarike se jita ja sakta hai
        // 3 rows, 3 cols, 2 diagonals = 6 tarike
        int[] rows = new int[3];  
        int[] cols = new int[3];
        int diagonal = 0, antiDiagonal = 0;
        
        // Player A = +1, Player B = -1
        int player = 1; 
        
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            
            //  rows and cols ko update kar diya jaise jaise for loop iterate hoga
            rows[row] += player;
            cols[col] += player;
            
            // Main diagonal
            if (row == col) {
                diagonal += player;
            }
            
            // Anti-diagonal
            if (row + col == 2) {
                antiDiagonal += player;
            }
            
            // check kar leta hu kaun sa player jita
            if (Math.abs(rows[row]) == 3 || 
                Math.abs(cols[col]) == 3 || 
                Math.abs(diagonal) == 3 || 
                Math.abs(antiDiagonal) == 3) {
                return player == 1 ? "A" : "B";
            }
            
            // player ko badal deta hu
            player *= -1;
        }
        
        // agar sab 9 khali places bhar jaaye to iska matlab game tie ho gaya hai
        if (moves.length == 9) {
            return "Draw";
        }
        
        // agar upar ke koi bhi saubhagya nahi ban paa rahe to iska matlab game abhi bhbi on hai
        return "Pending";
    }
}