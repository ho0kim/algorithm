def solution(n, arr1, arr2):
    answer = []
    intToBin(n,arr1)
    intToBin(n,arr2)

    return answer

def intToBin(n,arr):
    arr_a=[]
    for i in arr:
        i = "{0:b}".format(i).zfill(n)
        arr_a.append(i)
    return arr_a

def compareList(arr1,arr2):
    arr_a=[]
    str_a=""
    for i,j in zip(arr1,arr2):
        print(i+" "+j)
        for idx,k in enumerate(i):
            print(k+"  "+j[idx])
            if k=="0" and j[idx]=="0":
                str_a=str_a+" "
            else:
                str_a=str_a+"#"
        arr_a.append(str_a)
        str_a=""
    return arr_a





if __name__ == '__main__':
    print( compareList(['00000', '10100', '11100', '10010', '01011'],['00000', '00001', '10101', '10001', '11100']) )





