# def solution(routes):
#     answer = routes
#     cctv = routes
#     for i in range(len(routes)):
#         for j in range(i+1, len(routes)):
#             if routes[i][0] <= cctv[j] and routes[i][1] >= cctv[j]:
#                 answer.pop(j)
#     return len(answer)

def solution(routes):
    answer = 0; cctv = routes
    routes.sort(key=lambda x:x[1])
    check = [False] * len(routes)
    for i in range(len(routes)):
        if check[i] == False:
            now = routes[i][1]
            answer += 1
        for j in range(i+1, len(routes)):
            if routes[j][0] <= now <= routes[j][1] and check[j] == False:
                check[j] = True
    return answer