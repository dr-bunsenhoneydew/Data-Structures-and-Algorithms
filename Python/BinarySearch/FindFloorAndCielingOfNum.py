#CONDITIONS:
#ONLY WORKS IF THERE ARE NO DUPLICATES IN THE SORTED ARRAY

def findfloor(nums, target):
    left = 0
    right = len(nums) - 1
    floor = -1

    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            return nums[mid]
        elif nums[mid] > target:
            right = mid - 1
        else:
            floor = nums[mid]
            left = mid + 1
    return floor

def findcieling(nums, target):
    left = 0
    right = len(nums) - 1
    cieling = -1

    while left <= right:
        mid = (left + right)//2
        if nums[mid] == target:
            return nums[mid]
        elif nums[mid] < target:
            left = mid + 1
        else:
            cieling = nums[mid]
            right = mid - 1
    return cieling

def returnfloorciel(nums,target):
    floor = findfloor(nums,target)
    cieling = findcieling(nums,target)
    return "{} is the floor and {} is the cieling".format(floor, cieling)
