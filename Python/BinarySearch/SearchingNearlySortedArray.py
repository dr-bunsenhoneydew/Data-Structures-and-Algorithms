def searchnearlysortedarray(nums, target):
    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = (left + right)//2

        if nums[mid] == target:
            return mid
        elif nums[mid - 1] == target:
            return mid - 1
        elif nums[mid + 1] == target:
            return mid + 1

        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1


#TEST CASE
searchnearlysortedarray(nums=[2,1,3,5,4,7,6,8,9], target=2)
