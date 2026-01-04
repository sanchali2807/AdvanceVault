import java.util.*;

class Solution {

    public List<Integer> toposort(List<List<Integer>> adj, int V) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return topo;
    }

    public String findOrder(String[] words) {
        int n = words.length;
        int V = 26; // fixed because we use char - 'a'

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Track which characters actually appear
        boolean[] present = new boolean[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        int presentCount = 0;
        for (boolean b : present) {
            if (b) presentCount++;
        }

        // Build graph
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // Prefix invalid case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                    adj.get(u).add(v);
                    break;
                }
            }
        }

        List<Integer> topo = toposort(adj, V);

        // Cycle check
        int used = 0;
        for (int x : topo) {
            if (present[x]) used++;
        }
        if (used < presentCount) {
            return "";
        }

        // Build answer
        StringBuilder ans = new StringBuilder();
        for (int x : topo) {
            if (present[x]) {
                ans.append((char) (x + 'a'));
            }
        }

        return ans.toString();
    }
}
