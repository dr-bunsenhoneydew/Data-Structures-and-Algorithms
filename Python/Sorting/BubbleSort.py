

def bubbleSort(nums):
    n = len(nums)

    for i in range(n):
        swapped = False

        for j in range(0, n-1-i):
            if nums[j] > nums[j+1]:
                nums[j], nums[j+1] = nums[j+1], nums[j]
                swapped = True

        if swapped == False:
            break
    return nums


#TEST CASE
bubbleSort([64,34,25,12,22,11,90])
