import sys

input = sys.stdin.readline

def check(h, b):
    global N, M, m_re
    t = 0

    for n in range(N):
        for m in range(M):
            if m_re < t:
                return -1
            if h < MAT[n][m]:
                t += (MAT[n][m] - h) * 2
                b += MAT[n][m] - h
            else:
                t += h - MAT[n][m]
                b -= h - MAT[n][m]

    if b < 0:
        return -1

    return t

N, M, B = map(int, input().split())
MAT = [list(map(int, input().split())) for n in range(N)]

m_re, h_re = float('inf'), 0
for h in range(257):
    t = check(h, B)
    if t >= 0 and m_re >= t:
        m_re = t
        h_re = h

print(m_re, h_re)