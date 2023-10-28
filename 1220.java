import java.util.*;

class Solution {
    public int countVowelPermutation(int n) {
        long[] vowels = new long[5];
        Arrays.fill(vowels, 1);
        int mod = (int) (Math.pow(10, 9) + 7);
        while (n > 1) {
            long[] temp = new long[5];
            temp[0] = (vowels[1] + vowels[2] + vowels[4]) % mod;
            temp[1] = vowels[0] + vowels[2] % mod;
            temp[2] = vowels[1] + vowels[3] % mod;
            temp[3] = vowels[2] % mod;
            temp[4] = vowels[2] + vowels[3] % mod;
            vowels = temp;
            n--;
        }
        return (int) ((vowels[0] + vowels[1] + vowels[2] + vowels[3] + vowels[4]) % mod);
    }
}
