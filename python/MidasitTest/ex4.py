data=input()
tree=(int)(data.split(' ')[0])
appleNum=(int)(data.split(' ')[1])

getApple=0
cntApple=0
for i in range(tree):
    pos=input()
    cntApple=appleNum-(int)(pos.split(' ')[0])-(int)(pos.split(' ')[1])
    if cntApple>0:
        getApple=getApple+cntApple

print(getApple)



