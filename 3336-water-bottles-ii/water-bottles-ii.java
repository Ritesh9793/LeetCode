class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = 0;
        long full = numBottles;
        long empty = 0;
        long exchange = numExchange;
        
        // sabhi bottles ko pi lena hai
        drunk += full;
        empty += full;
        full = 0;
        
        // jab ham exchange kar sakte hai tab
        while (empty >= exchange) {
            // ek khali bottle ke badle ek full bottle exchange kar lenge
            empty -= exchange;
            full += 1;
            
            // exchange karne ke baad increament perform kar lenge
            exchange += 1;
            
            // ab us full bottle ko pi lenge
            drunk += full;
            empty += full;
            full = 0;
        }
        // last me total pi hui bottles ki sankhya return kara lenge
        return drunk;
    }
}