

def findmissingterm(nums):
    left = 0
    right = len(nums) - 1

    #Here we assume a constant differential
    diff = (nums[-1] - nums[0]) // len(nums)

    while left <= right:
        mid = (left + right)//2

        if mid + 1 < len(nums) and nums[mid+1] - nums[mid] != diff:
            return nums[mid + 1] - diff
        elif mid - 1 >= 0 and nums[mid] - nums[mid-1] != diff:
            return nums[mid - 1] - diff

        #Check if missing term is on left or right side to reduce search
        elif nums[mid] - nums[0] != diff * (mid - 0):
            right = mid - 1
        else:
            left = mid + 1
    return -1

#TEST CASES
findmissingterm(nums = [5,7,9,11,15])
findmissingterm(nums = [1,4,7,10,16])
findmissingterm(nums = [2,3,4,5,7])
