# 알고리즘 공부 노트장

알고리즘 공부를 위한 노트장 입니다.

본 저장소의 알고리즘 해답은 정답일 수도 있고 아닐 수도 있습니다.

--------
## JAVA

### BOJ_1991(트리)
단순한 트리 순회 문제  
두가지 방식으로 풀이  

##### Sol 1.
node의 최대 갯수가 26개 밖에 안되기때문에 제일 처음 생각난 방식  
node 데이터를 ascii코드로 변환.  
'A' -> 0 으로 변환   
배열에 박아넣고 기존 트리 순회와 동일한 방법으로 품.  

##### Sol 2.
기존에 트리 생성과 순회를 하는 정석 방식  
최초 (add)에서 루트 노드를 박아넣고   
나머지는 노드가 들어갈 곳을 서치한뒤 add 하는 방식(searchAndAdd).  


### BOJ_11725(그래프 순회)
트리 순회라 그래서 풀었지만 그래프 순회 문제  
노드끼리 link를 걸어서 graph를 생성한 뒤  
그래프를 순회하면서  
bfs의 경우 queue에 노드를 enqueue할 때 dequeue 되어있는 노드를 parent로 넣어주면된다.  
parents array에 각 노드의 parent 데이터를 넣어주면된다   

순회는 bfs, dfs 아무거나 해도 상관없지만 개인적으로 bfs를 좋아해 bfs로 풀었다.

+DFS풀이 추가.  
bfs와 비슷.  
node가 pop되고 자식 노드들을 push할 때 해당 node들의 parent를 pop되어있는 node로 넣어주면 된다.  


### BOJ_7576(BFS문제)
사과 문제 처음에 고민을 많이함..  
BFS로 풀이과정을 결정 후 잘 풀림 - 사용 알고리즘만 결정나면 별로 어렵진 않음. 

- 풀이과정
1. 익은 사과들을 큐에 쭉 넣어준다.
2. 상하좌우 탐색을 하여서 안익은 사과가 있을경우
    - 해당 위치 방문 설정
    - 큐에 해당 위치 넣어줌
    - 전 위치의 숫자에 +1을 해줌
3. 결과값 출력
    - 가장 큰숫자에서 -1 해주면됨(시작 숫자가 1이었으므로)
    - 전체 데이터 중에서 안익은 상태(0) 이 하나라도 있으면 -1 리턴. 



