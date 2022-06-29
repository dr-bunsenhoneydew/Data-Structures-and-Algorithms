def longestsub(s):
    if len(s) < 1: return 0

    beginning = 0
    end = 0
    window = set()
    left = 0
    right = 0
    maxwindow = 0

    while left <= right and right < len(s):
        if s[right] in window:
            window.remove(s[left])
            left += 1
        else:
            window.add(s[right])
            if maxwindow < (right - left + 1):
                maxwindow = right - left + 1
                beginning = left
                end = right
            right += 1
    return maxwindow, s[beginning:end+1]


#TEST CASE
longestsub('longestsubstr')
longestsub('abcdddcbeaf')
