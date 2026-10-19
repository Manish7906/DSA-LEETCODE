class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            int i = 0;
            int j = 0;

            while (i < query.length()) {
                if (j < pattern.length() &&
                    query.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                }
                else if (Character.isUpperCase(query.charAt(i))) {
                    break;
                }
                else {
                    i++;
                }
            }

            ans.add(i == query.length() && j == pattern.length());
        }

        return ans;
    }
}