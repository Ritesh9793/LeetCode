class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            caseInsensitive.putIfAbsent(word.toLowerCase(), word);
            
            String devoweled = devowel(word.toLowerCase());
            vowelInsensitive.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                result[i] = query; // Rule 1
            } else if (caseInsensitive.containsKey(query.toLowerCase())) {
                result[i] = caseInsensitive.get(query.toLowerCase()); // Rule 2
            } else {
                String devoweledQuery = devowel(query.toLowerCase());
                result[i] = vowelInsensitive.getOrDefault(devoweledQuery, ""); // Rule 3 & 4
            }
        }
        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}