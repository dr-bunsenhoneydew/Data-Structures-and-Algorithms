#CONDITIONS:
#MUST HAVE A SORTED ARRAY
def countoccurence(nums, target, findingfirst):
    left = 0
    right = len(nums) - 1
    result = -1

    while left <= right:
        mid = (left + right)//2

        if nums[mid] == target:
            result = mid

            if findingfirst:
                right = mid - 1
            else:
                left = mid + 1

        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return result

first = countoccurence(nums, target, True)
last = countoccurence(nums, target, False)
count = last - first + 1
#TEST CASE
countoccurence(nums = [2,5,5,5,6,6,8,9,9,9], target = 5)


######################### OR ################################
def findfirst(nums, target):
    left = 0
    right = len(nums) - 1
    ind = -1

    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            ind = mid
            right = mid - 1
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return ind

def findlast(nums, target):
    left = 0
    right = len(nums) - 1
    ind = -1

    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            ind =  mid
            left = mid + 1
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return ind

def findcount(nums,target):
    firstcount = findfirst(nums,target)
    lastcount = findlast(nums,target)
    return "{} is listed {} times.".format(target, lastcount - firstcount + 1)

