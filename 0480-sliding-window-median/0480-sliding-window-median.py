from sortedcontainers import SortedList

class Solution:
    def medianSlidingWindow(self, nums, k):
        res = []

        # store first half [0 ... n/2]
        maxset = SortedList(key=lambda x: (-x[0], -x[1]))

        # store second half [n/2 .... n]
        minset = SortedList(key=lambda x: (x[0], x[1]))

        for i in range(k):
            minset.add((nums[i], i))

        for _ in range(k // 2):
            it = minset[0]
            maxset.add(it)
            minset.remove(it)

        if k % 2:
            median = minset[0][0]
        else:
            median = (1.0 * maxset[0][0] + 1.0 * minset[0][0]) / 2.0

        res.append(median)

        r, l = k, 0

        while r < len(nums):

            add = (nums[r], r)
            remove = (nums[l], l)
            f = 1

            if remove in maxset:
                maxset.remove(remove)
                f -= 1
            else:
                minset.remove(remove)

            if f:
                maxset.add(add)
                it = maxset[0]
                minset.add(it)
                maxset.remove(it)
            else:
                minset.add(add)
                it = minset[0]
                maxset.add(it)
                minset.remove(it)

            if k % 2:
                median = minset[0][0]
            else:
                median = (1.0 * maxset[0][0] + 1.0 * minset[0][0]) / 2.0

            res.append(median)

            r += 1
            l += 1

        return res