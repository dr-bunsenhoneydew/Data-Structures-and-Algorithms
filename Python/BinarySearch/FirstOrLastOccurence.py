#CONDITIONS:
#MUST HAVE A SORTED ARRAY
def firstoccurence(nums, target):
    left = 0
    right = len(nums) - 1
    result = -1

    while left <= right:
        mid = (left + right)//2


        if nums[mid] == target:
            result = mid
            right = mid - 1
        elif target < nums[mid]:
            right = mid - 1
        else:
            left = mid + 1
    return result

def lastoccurence(nums, target):
    left = 0
    right = len(nums) - 1
    result = -1

    while left <= right:
        mid = (left + right)//2


        if nums[mid] == target:
            result = mid
            left = mid + 1
        elif target < nums[mid]:
            right = mid - 1
        else:
            left = mid - 1
    return result


#TEST CASES
firstoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 5)
firstoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 8)
firstoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 9)

lastoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 5)
lastoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 8)
lastoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 9)
