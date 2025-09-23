class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        version1_l = version1.split(".")
        version2_l = version2.split(".")

        index = 0
        while index < len(version1_l) or index < len(version2_l):
            cur_v1 = int(version1_l[index]) if index < len(version1_l) else 0
            cur_v2 = int(version2_l[index]) if index < len(version2_l) else 0
            if cur_v1 < cur_v2:
                return -1
            elif cur_v1 > cur_v2:
                return 1
            index += 1
        return 0
