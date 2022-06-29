def findingpeaks(nums):
    left = 0
    right = len(nums) - 1

    while left < right:
        mid = (left + right)//2
        if (mid - 1 >= 0 and nums[mid - 1] <= nums[mid]):
            left = miid

    peakslist = []
    mid = (left + right)//2

    if (mid == 0 or nums[mid - 1] <= nums[mid]) and \
            (mid == len(nums) - 1 or nums[mid + 1] <= nums[mid]):
        peakslist.append(mid)

    elif mid - 1 >= 0 and nums[mid - 1] > nums[mid]:
        return findingpeaks(nums, left, mid - 1)

    elif mid + 1 <= len(nums) - 1 and nums[mid + 1] > nums[mid]:
        return findingpeaks(nums, mid + 1, right)

    return peakslist

