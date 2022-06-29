def findall(str1, str2):

    set2 = set()
    for i in str2:
        set2.add(i)

    left = 0
    right = len(str2)


    while right < len(str1) + 1:
        testset = set()
        for i in str1[left:right]:
            testset.add(i)
        if testset == set2:
            print('Anagram ' + str(set2) + ' present at index ' + str(left))
            left += 1
            right += 1
        else:
            left += 1
            right += 1


#TEST CASE
findall(str1 = 'XYYZXZYZXXYZ', str2 = 'XYZ')
findall(str1 = 'ABDCBADDRABD', str2 = 'DBA')
