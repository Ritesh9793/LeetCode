class Solution {
     class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int id = 0;

        // Step 1: Map emails to IDs and owners
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                    emailToName.put(email, name);
                }
            }
        }

        DSU dsu = new DSU(id);

        // Step 2: Union emails belonging to the same account
        for (List<String> account : accounts) {
            int firstEmailId = emailToId.get(account.get(1));

            for (int i = 2; i < account.size(); i++) {
                int emailId = emailToId.get(account.get(i));
                dsu.union(firstEmailId, emailId);
            }
        }

        // Step 3: Group emails by root parent
        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : emailToId.keySet()) {
            int root = dsu.find(emailToId.get(email));
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        // Step 4: Build the result
        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);

            String name = emailToName.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }
}