def reductionCost(num=[1,2,3,4]):
    saveNum=[]
    while len(num)>1:
        num.sort()
        a=num.pop(0)+num.pop(0)
        saveNum.append(a)
        num.insert(0,a)
        if len(num)==1:
            break
    result=0
    print(saveNum)
    for i in saveNum:
        result=result+i

    return result

print(reductionCost([1,2,3,4]))


