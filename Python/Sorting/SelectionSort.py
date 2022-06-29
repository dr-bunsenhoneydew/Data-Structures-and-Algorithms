import random

def findSmallest(nums):
    smallest = nums[0]
    smallest_index = 0
    for i in range(1, len(nums)):
        if nums[i] < smallest:
            smallest = nums[i]
            smallest_index = i
    return smallest_index

def findBiggest(nums):
    biggest = nums[0]
    biggest_index = 0
    for i in range(1,len(nums)):
        if nums[i] > biggest:
            biggest = nums[i]
            biggest_index = i
    return biggest_index

def selectionSortAscend(nums):
    sortedlist = []
    for i in range(len(nums)):
        smallest = findSmallest(nums)
        sortedlist.append(nums.pop(smallest))
    return sortedlist

def selectionSortDescend(nums):
    sortedlist = []
    for i in range(len(nums)):
        biggest = findBiggest(nums)
        sortedlist.append(nums.pop(biggest))
    return sortedlist


#TEST CASE
selectionSortAscend([1, 10, 12, 3, 7, 9, 22])
selectionSortDescend([1, 10, 12, 3, 7, 9, 22])
