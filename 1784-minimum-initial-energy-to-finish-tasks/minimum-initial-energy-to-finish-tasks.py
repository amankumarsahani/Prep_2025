class Solution(object):
    def minimumEffort(self, tasks):
        """
        :type tasks: List[List[int]]
        :rtype: int
        """

        # Tasks with larger buffer first
        tasks.sort(key=lambda x: (x[1] - x[0]), reverse=True)

        ans = 0
        energy = 0

        for actual, minimum in tasks:
            if energy < minimum:
                ans += (minimum - energy)
                energy = minimum

            energy -= actual

        return ans