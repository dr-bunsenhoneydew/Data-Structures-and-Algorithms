#CONDITIONS:
#ONLY WORKS IF THERE ARE NO DUPLICATES IN THE SORTED ARRAY
def findsmallestmissingelement(nums):

    left = 0
    right = len(nums) - 1
    ind = -1

    while left <= right:
        mid = (left + right)//2

        if mid != nums[mid]:
            ind = mid
            right = mid - 1
        else:
            left = mid + 1
    return ind

