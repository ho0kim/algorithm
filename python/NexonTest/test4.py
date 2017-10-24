def firstRepeatingLetter(s="abcba"):
    data=[]
    for i in s:
        data.append(i)

    for i in range(len(data)):
        for k in range(i+1,len(data)):
            if data[i]==data[k]:
                return data[i]




print(firstRepeatingLetter())