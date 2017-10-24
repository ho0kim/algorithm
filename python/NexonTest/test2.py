def countDuplicates(numbers):
    cnt=0
    setlist=list(set(numbers))
    numbers.sort()
    dic={}
    print(numbers)
    for i in setlist:
        dic[i]=0
    for i in numbers:
        dic[i]=dic[i]+1

    for i in dic.values():
        if i!=1:
            cnt = cnt + 1
    return cnt

print(countDuplicates([1,3,1,4,5,6,3,2]))