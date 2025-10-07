class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
         Map<String, Integer> indexMap = IntStream.range(0, list1.length)
                .boxed()
                .collect(Collectors.toMap(i -> list1[i], i -> i));

        Map<String, Integer> commonMap = IntStream.range(0, list2.length)
                .filter(j -> indexMap.containsKey(list2[j]))
                .boxed()
                .collect(Collectors.toMap(
                        j -> list2[j],
                        j -> j + indexMap.get(list2[j])
                ));

        int minSum = commonMap.values().stream().min(Integer::compare).orElse(Integer.MAX_VALUE);

        return commonMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minSum)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}