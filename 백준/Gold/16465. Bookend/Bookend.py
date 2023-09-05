def check(book, M, L):
    if book > M:    # 전체 책 길이 > 책장 길이
        return -1
    if book == M:   # 전체 책 길이 == 책장 길이
        return 0    
    if book < L:
        if (M-book-L) < 0:  # 전체 책 길이 < 책장, 북엔드 반대로 두기 X
            return -1
        else:
            return 1    # 전체 책 길이 < 책장, 북엔드 반대로 두기 O
    return 1    # 전체 책 길이 < 책장 길이, 전체 책 길이 > 북엔드 길이

N,M,L = map(int, input().split())
book = sum(list(map(int, input().split())))

print(check(book, M, L))