data=input()
needNum=(int)(data.split(' ')[0])
mNum=(int)(data.split(' ')[1])
dduk=[]

for i in range(mNum):
    dduk.append(input())

dduk.sort()
print(dduk)
dduk = [int (i) for i in dduk]
cnt=0
cntData=0
for i in range((dduk[-1])):
    for j in dduk:
        cnt= cnt + (int)(j/(i+1))
    if cnt<needNum:
        break
    cntData = i+1
    cnt=0

print(cntData)
