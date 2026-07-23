public class {
    public List<String> commonChars(String[] words) {
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (String w : words) {
            int[] cnt = new int[26];
            for (char c : w.toCharArray())
                cnt[c - 'a']++;
            for (int i = 0; i < 26; i++)
                min[i] = Math.min(min[i], cnt[i]);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            while (min[i]-- > 0)
                ans.add("" + (char)(i + 'a'));

        return ans;
    }
}
