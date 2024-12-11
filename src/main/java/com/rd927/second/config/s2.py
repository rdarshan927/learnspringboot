class Solution:
    def pushZerosToEnd(self, arr):
        length = len(arr)
        count = 0

        for i in range(length):
            if arr[i] != 0:
                arr[count], arr[i] = arr[i], arr[count]
                count += 1
        return arr

arr = [1, 3, 0, 2, 0, 0, 5, 4, 7, 6, 8]
solution = Solution()
solution.pushZerosToEnd(arr)
print(arr)