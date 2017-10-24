def solution(N):
    answer = [ "()" ]
    idx=1;
    imsi=[]
    while idx<N:
        for element in answer:
            imsi.append("("+element+")")
        for element in answer:
            imsi.append(element + "()")
            imsi.append("()"+element)
        imsi.pop()
        answer=imsi
        imsi=[]
        idx=idx+1

    return answer

print(solution(3))