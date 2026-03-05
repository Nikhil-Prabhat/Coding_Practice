// Tried Solution
class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        int[] rankOfNode = new int[accounts.size()];
        Map<String, Integer> accountsMap = new HashMap<>();
        ArrayList<String>[] mergedMails = new ArrayList[accounts.size()];
        List<List<String>> mergedAccounts = new ArrayList<>();

        IntStream.range(0, accounts.size())
                .forEach(index -> parent[index] = index);

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mailId = accounts.get(i).get(j);

                if (accountsMap.containsKey(mailId)) {
                    unionOfNodesByRank(i, accountsMap.get(mailId), parent, rankOfNode);
                } else {
                    accountsMap.put(mailId, i);
                }
            }
        }

        IntStream.range(0, accounts.size())
                .forEach(index -> mergedMails[index] = new ArrayList<>());

        accountsMap.entrySet()
                .stream()
                .forEach(
                        keyValPair -> {
                            int actualParent = getActualParentOfNode(keyValPair.getValue(), parent);
                            mergedMails[actualParent].add(keyValPair.getKey());
                        }
                );

        for (int i = 0; i < accounts.size(); i++) {
            if(mergedMails[i].isEmpty()) {
                continue;
            }

            Collections.sort(mergedMails[i]);
            List<String> intermediateList = new ArrayList<>();
            intermediateList.add(accounts.get(i).get(0));
            intermediateList.addAll(mergedMails[i]);
            mergedAccounts.add(intermediateList);
        }

        return mergedAccounts;
    }

    private int getActualParentOfNode(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = getActualParentOfNode(parent[node], parent);
    }

    private void unionOfNodesByRank(int firstNode, int secondNode, int[] parent, int[] rankOfNode) {
        int parentOfFirstNode = getActualParentOfNode(firstNode, parent);
        int parentOfSecondNode = getActualParentOfNode(secondNode, parent);

        if (parentOfFirstNode == parentOfSecondNode) {
            return;
        }

        // Union of parents
        if (rankOfNode[firstNode] < rankOfNode[secondNode]) {
            parent[firstNode] = secondNode;
        } else if (rankOfNode[firstNode] > rankOfNode[secondNode]) {
            parent[secondNode] = firstNode;
        } else {
            parent[secondNode] = firstNode;
            rankOfNode[firstNode]++;
        }
    }
}

// Actual Solution
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Union accounts having common emails
        for (int i = 0; i < n; i++) {
            int m = accounts.get(i).size();
            for (int j = 1; j < m; j++) {
                String mail = accounts.get(i).get(j);

                if (map.containsKey(mail)) {
                    union(i, map.get(mail), parent, size);
                } else {
                    map.put(mail, i);
                }
            }
        }

        // Step 2: Group emails by ultimate parent index
        HashMap<Integer, List<String>> mergedMap = new HashMap<>();
        for (String mail : map.keySet()) {
            int index = map.get(mail);
            int ultParent = find(parent, index);

            mergedMap.putIfAbsent(ultParent, new ArrayList<>());
            mergedMap.get(ultParent).add(mail);
        }

        // Step 3: Prepare final result
        List<List<String>> result = new ArrayList<>();
        for (int key : mergedMap.keySet()) {
            List<String> temp = mergedMap.get(key);
            Collections.sort(temp);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(key).get(0)); // Add the Name
            account.addAll(temp); // Add sorted emails

            result.add(account);
        }

        return result;
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent, parent[node]); // Path Compression
    }

    private void union(int u, int v, int[] parent, int[] size) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        if (pu == pv) return;

        // Union by Size
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
