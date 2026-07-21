class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        Set<Character> seen = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            seen.add(c);
            if (seen.size() == 26) {
                return true;
            }
        }

        return seen.size() == 26;
    }
}
