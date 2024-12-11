class Solution:
    #Function to rotate an array by d elements in counter-clockwise direction. 
    def rotateArr(self, arr, d):
        length = len(arr) - 1
        
        for i in range(0, d):
            first = arr[0]
            
            for j in range(length):
                arr[j] = arr[j+1]
                print(i)
            
            arr[length] = first
            print("hello " , arr[4])


arr = [1, 2, 3, 4, 5]

solution = Solution()

solution.rotateArr(arr, 2)

print(arr)
