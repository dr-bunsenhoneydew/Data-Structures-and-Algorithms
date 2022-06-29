#CONDITIONS:
#ONLY WORKS IF THERE ARE NO DUPLICATES IN THE SORTED ARRAY
#NOTE: IF THERE ARE DUPLICATES, WE CANNOT DO BETTER THAN O(N)
def rotationsincirculararray(nums):

    left = 0
    right = len(nums) - 1

    while left <= right:
        #edge case: no rotations
        if nums[left] <= nums[right]:
            return left

        #set mid
        mid = (left + right)//2

        #define the next and previous relative to target (mid)
        #the modulo n works if mid was the last element of the array
        next = (mid + 1) % len(nums)
        previous = (mid - 1 + len(nums)) % len(nums)

        #check if your first mid was the correct target (less than both next and previous)
        if nums[mid] <= nums[next] and nums[mid] <= nums[previous]:
            return mid
        #if your first mid was greater than the left, knock out everything to the left
        #if your first mid was less than the right, knock out everything to the right
        elif nums[mid] >= nums[left]:
            left = mid + 1
        else:
            right = mid - 1
    return -1


###Test Case:
nums = [1,2,3,4,5,6,7,8,9,10,11]
nums = [10,11,1,2,3,4,5,6,7,8,9]
