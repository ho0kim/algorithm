listNum=input()
data=input()
datalist=data.split(' ')
datalist = [int (i) for i in datalist]
sortedData=sorted(datalist)

def permute(list):
    if not list:
        return [list]
    else:
        data=[]
        for i in range(len(list)):
            data_ele=list[:i]+list[i+1:]
            for k in permute(data_ele):
                data.append(list[i:i+1]+k)
        return data

def listCheck(data,datalist):
    for i in range(len(datalist)):
        if data[i]!=datalist[i]:
            return False
    return True

allDataList=permute(sortedData)

result=0
cnt=0
for i in allDataList:
    if listCheck(i,datalist)==True:
        result=cnt
    cnt=cnt+1

print(len(allDataList)/len(datalist))
if (result-1) >= ((int)(len(allDataList)/len(datalist))):
    print(-1)
else:
    print(allDataList[result+1])