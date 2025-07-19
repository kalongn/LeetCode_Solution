from typing import List


class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        folder.sort()
        result = [folder[0]]

        for i in range(1, len(folder)):
            prev_folder = result[-1]
            prev_folder += "/"

            if not folder[i].startswith(prev_folder):
                result.append(folder[i])

        return result
