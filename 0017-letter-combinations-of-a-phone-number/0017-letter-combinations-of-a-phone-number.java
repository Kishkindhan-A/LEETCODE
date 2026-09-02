class Solution {

    public List<String> letterCombinations(String digits) {
        String[] key = new String[8];
        key[0] = "abc";
        key[1] = "def";
        key[2] = "ghi";
        key[3] = "jkl";
        key[4] = "mno";
        key[5] = "pqrs";
        key[6] = "tuv";
        key[7] = "wxyz";

        List<String> ans = new ArrayList<>();
        func(0, ans, new StringBuilder(), key, digits, digits.length());
        return ans;
    }
    public void func(int i, List<String> ans, StringBuilder sb, String[] key, String digits, int n) {
        if (i == n) {
            ans.add(sb.toString());
            return;
        }
        int idx = digits.charAt(i) - '2';
        for (int j = 0; j < key[idx].length(); j++) {
            sb.append(key[idx].charAt(j));
            func(i + 1, ans, sb, key, digits, n); // everytime adding next index all possibilites
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}