def solution(seat):
    for idx,i in enumerate(seat):
        for k in range(idx):
            if seat[idx][0]==seat[k][0] and seat[idx][1]==seat[k][1]:
                seat[k][0]=-1
                seat[k][1] =-1

    answer=0
    for idx,i in enumerate(seat):
        if seat[idx][0]!=-1:
            answer=answer+1
    return answer


seat=[[1,1],[2,1],[1,2],[3,4],[2,1],[2,1]]
print(solution(seat))