
def mergeSort(nums):
    if len(nums) > 1:
        mid = len(nums)//2
        left = nums[:mid]
        right = nums[mid:]
        mergeSort(left)
        mergeSort(right)

        i = j = k = 0

        while (i < len(left) and j < len(right)):
            if left[i] <= right[j]:
                nums[k] = left[i]
                k += 1
                i += 1
            else:
                nums[k] = right[j]
                k += 1
                j += 1
        while (i < len(left)):
            nums[k] = left[i]
            k += 1
            i += 1
        while (j < len(right)):
            nums[k] = right[j]
            k += 1
            j += 1

    return nums


#TEST CASE
mergeSort([12, 11, 13, 5, 6, 7])
