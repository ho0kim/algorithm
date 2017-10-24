
def solution(dartResult):
    answer = 0
    arr=[]
    arr=cut(dartResult)
    answer = calcul(arr)
    return answer

def cut(data):
    arr = []
    for idx,i in enumerate(data):
        if i =="S" or i=="D" or i=="T":
            arr.append(""+data[idx-1]+i)
        elif i=="*" or i=="#":
            arr.append(""+data[idx])
    return arr

def calcul(arr):
    arr1=[]
    total=0
    for i in arr:
        if i!='*' and i!='#':
            if i[1]=='T':
                element=int(i[0])**3
                arr1.append(element)
            elif i[1]=='D':
                element = int(i[0]) ** 2
                arr1.append(element)
            elif i[1] == 'S':
                element = int(i[0])
                arr1.append(element)
        else:
            if i=='*':
                arr1.append('*')
            elif i=='#':
                arr1.append('#')

    for idx,i in enumerate(arr1):
        print(total)
        if i=='*':
            total=total*2
        elif i=='#':
            total=total-2*int(arr1[idx-1])
        else:
            total=total+i
    return total


if __name__ == '__main__':
    print(solution("1D#2S*3S"))