#CONDITIONS:
#ONLY WORKS IF THERE ARE NO DUPLICATES IN THE SORTED ARRAY
#NOTE: IF THERE ARE DUPLICATES, WE CANNOT DO BETTER THAN O(N)
def binarysearch(nums, target):
    left = 0
    right = len(nums) - 1
    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return None

#TEST CASES
inpSmall = list(range(1, 101))
inpMedium = list(range(1, 1001))
inpLarge = list(range(1, 10001))
binarysearch(inpSmall, 55)
binarysearch(inpMedium, 777)
binarysearch(inpLarge, 5678)
