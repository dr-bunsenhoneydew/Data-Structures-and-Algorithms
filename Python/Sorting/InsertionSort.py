

def insertionSort(nums):

    for i in range(1,len(nums)):
        value = nums[i]
        hole = i
        while (hole > 0 and nums[hole-1] > value):
            nums[hole] = nums[hole-1]
            hole -= 1
        nums[hole] = value
    return nums




#TEST CASE
insertionSort([12, 11, 13, 5, 6])
