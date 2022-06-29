def squareroot(x):
    if x < 2:
        return x
    left = 1
    right = x//2
    result = 0
    while left <= right:
        mid = (left+right)//2
        sqr = mid*mid
        if sqr == x:
            return mid
        elif sqr > x:
            right = mid - 1
        else:
            result = mid
            left = mid + 1
    return result

#TEST CASE
squareroot(1)
squareroot(4)
squareroot(5)
squareroot(99)
squareroot(144)


