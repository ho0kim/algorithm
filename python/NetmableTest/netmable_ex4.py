def generateList(S):
    anagramList = []
    if len(S) <= 1:
        anagramList.append(S)
    else:
        for w in generateList(S[1:]):
            for i in range(len(S)):
                anagramList.append(w[:i] + S[0] + w[i:])
    return anagramList


def solution(a, b):
    answer = False
    anagramList=generateList(a)
    b=b.lower()
    for i in anagramList:
        if i==b:
            answer=True
    return answer

if __name__ == "__main__":
    print(solution("asdfghjkl","asdflkjhg"))

