class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String smallest = s;

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String addStr = new String(chars);

            if (visited.add(addStr)) {
                queue.add(addStr);
            }

            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (visited.add(rotated)) {
                queue.add(rotated);
            }
        }

        return smallest;
    }
}