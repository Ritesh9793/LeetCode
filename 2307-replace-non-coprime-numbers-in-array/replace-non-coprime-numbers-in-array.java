class Solution {
    private long lcm(int a, int b, int g){
        return (long)(a/g)*b;
    }
    //euclidean algorithm
    private int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int x : nums){
            stack.addLast(x);
            while(stack.size()>=2){
                int last = stack.getLast();
                int secondLast = stack.get(stack.size()-2);
                int g = gcd(secondLast, last);
                if(g == 1) {
                    break;
                }
                stack.removeLast();
                long lcm = lcm(secondLast, last, g);
                stack.removeLast();
                stack.addLast((int)lcm);
            }
        }

        return stack;
    }
}