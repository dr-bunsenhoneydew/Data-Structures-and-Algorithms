import random

def partition(nums, start, end):
    pivot = nums[end]
    pIndex = start
    for i in range(start,end):
        if nums[i] <= pivot:
            nums[i], nums[pIndex] = nums[pIndex], nums[i]
            pIndex += 1
    nums[pIndex], nums[end] = nums[end], nums[pIndex]
    return pIndex

def randompartition(nums, start, end):
    pIndex = random.randint(start, end)
    nums[pIndex], nums[end] = nums[end], nums[pIndex]
    pivot = nums[end]
    pIndex = start
    for i in range(start,end):
        if nums[i] <= pivot:
            nums[i], nums[pIndex] = nums[pIndex], nums[i]
            pIndex += 1
    nums[pIndex], nums[end] = nums[end], nums[pIndex]
    return pIndex

def quickSort(nums, start, end):
    if start < end:
        pIndex = randompartition(nums, start, end)
        quickSort(nums, start, pIndex - 1)
        quickSort(nums, pIndex + 1, end)
    return nums

#TEST CASE
nums = [64,34,25,12,22,11,90]
quickSort(nums, 0, len(nums) - 1)




def quickSort(nums):
    if len(nums) < 2:
        return nums
    else:
        pivot = nums[0]
        less = [i for i in nums[1:] if i <= pivot]
        greater = [i for i in nums[1:] if i > pivot]
        return quickSort(less) + [pivot] + quickSort(greater)
    return nums


#TEST CASE
quickSort([1, 7, 5, 13, 6, 8, 10, 22, 15])
