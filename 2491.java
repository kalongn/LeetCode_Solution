import java.util.*;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int prevTeam = -1;
        long multiSum = 0;
        for (int i = 0; i < skill.length / 2; i++) {
            if (prevTeam == -1) {
                prevTeam = skill[i] + skill[skill.length - i - 1];
                multiSum += skill[i] * skill[skill.length - i - 1];
            } else if (skill[i] + skill[skill.length - i - 1] != prevTeam) {
                return -1;
            } else {
                multiSum += skill[i] * skill[skill.length - i - 1];
            }
        }
        return multiSum;
    }
}
