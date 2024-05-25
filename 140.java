import java.util.*;

class Solution {

    // Main function to break the string into words
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memoization = new HashMap<>();
        return dfs(s, wordSet, memoization);
    }

    // Depth-first search function to find all possible word break combinations
    private List<String> dfs(
            String remainingStr,
            Set<String> wordSet,
            Map<String, List<String>> memoization) {
        // Check if result for this substring is already memoized
        if (memoization.containsKey(remainingStr)) {
            return memoization.get(remainingStr);
        }

        // Base case: when the string is empty, return a list containing an empty string
        if (remainingStr.isEmpty())
            return Collections.singletonList("");
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= remainingStr.length(); ++i) {
            String currentWord = remainingStr.substring(0, i);
            // If the current substring is a valid word
            if (wordSet.contains(currentWord)) {
                for (String nextWord : dfs(
                        remainingStr.substring(i),
                        wordSet,
                        memoization)) {
                    // Append current word and next word with space in between if next word exists
                    results.add(
                            currentWord + (nextWord.isEmpty() ? "" : " ") + nextWord);
                }
            }
        }
        // Memoize the results for the current substring
        memoization.put(remainingStr, results);
        return results;
    }
}
