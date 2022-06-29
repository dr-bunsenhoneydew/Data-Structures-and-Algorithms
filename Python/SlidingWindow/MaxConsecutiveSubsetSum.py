def maxConsecutiveSubsetSum(nums, n):
    if len(nums) < n:
        return "Bad list"

    #sets maxsum = to the first window (index 0 to n)
    for i in range(n):
        maxsum += nums[i]

    maxsum = 0
    left = 0
    right = n
    tempsum = maxsum

    while right < len(nums):
        tempsum = tempsum - nums[left] + nums[right]
        maxsum = max(maxsum, tempsum)
        left += 1
        right += 1
    return maxsum


#TEST CASE
maxConsecutiveSubsetSum([2, 7, 14, 6, 8, 12, 9, 25, 13, 16], 3)
maxConsecutiveSubsetSum([2, 7, 14, 6, 8, 12, 9, 25, 13, 16], 7)
maxConsecutiveSubsetSum([2, 7, 14, 6, 8, 12, 9, 25, 13, 16], 22)
