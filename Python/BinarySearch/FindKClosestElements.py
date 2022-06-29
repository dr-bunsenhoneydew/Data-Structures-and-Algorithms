def binarysearch(nums,target):
    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return left


def findkclosestelements(nums, target, k):

    ins = binarysearch(nums, target)

    left = ins - 1
    right = ins

    while k > 0:
        if left < 0 or (right < len(nums) and abs(nums[left] - target) > abs(nums[right] - target)):
            right = right + 1
        else:
            left = left - 1
        k = k-1
    return nums[left+1: right]

#TEST CASES
findkclosestelements(nums=[10,12,15,17,18,20,25],target=16,k=4)
findkclosestelements(nums=[1,12,15,17,21,30,31],target=20,k=6)
findkclosestelements(nums=[9,11,15,17,18,28,29],target=8,k=4)
