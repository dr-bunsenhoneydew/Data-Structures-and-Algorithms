#CONDITIONS
#ONLY WORKS IF THERE ARE NO DUPLICATES IN THE SORTED ARRAY
#NOTE: IF THERE ARE DUPLICATES, WE CANNOT DO BETTER THAN O(N)
def searchelementincircular(nums,target):
    left = 0
    right = len(nums) - 1

    while left <= right:
        #define mid
        mid = (left + right)//2

        #if first mid is target, return index
        if nums[mid] == target:
            return mid

        #since this list is circular and sorted, one half of the array, either left or right, must be sorted
        #so, we compare nums[mid] to the right pointer, it will either be less than (right is sorted) or greater
        # than (left is sorted)
        if nums[mid] <= nums[right]:
            #if the right side is sorted, the target can fall between the mid and right pointer (inclusive)
            if nums[mid] < target <= nums[right]:
                #so we cross-out everything left of mid
                left = mid + 1
            #or else, the target must be on the left side, and we cancel everything on the right
            else:
                right = mid - 1

        #here left side of mid is sorted
        else:
            #and the target can either fall to the left, in which case we cross-out everything to the right of mid
            if nums[left] <= target < nums[mid]:
                right = mid - 1
            #or the target is actually on the right, and we cross-out everything to the left of mid
            else:
                left = mid + 1

    #return -1 if target not in array
    return -1


#TEST CASE
searchelementincircular(nums = [8,9,10,2,5,6], target = 10)
searchelementincircular(nums = [9,10,2,5,6,8], target = 5)
searchelementincircular(nums = [9,10,2,5,6,8], target = 7)
