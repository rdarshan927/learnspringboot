#User function Template for python3
class Solution:
    def getSecondLargest(self, arr):
        if len(arr) < 2:
            return -1 

        largest = second = float('-inf')

        for num in arr:
            if num > largest:
                second = largest
                largest = num
            elif num > second and num != largest:
                second = num

        return second if second != float('-inf') else -1


arr = [12, 35, 1, 10, 34, 1]
solution = Solution()
num = solution.getSecondLargest(arr) 

print(num) 
