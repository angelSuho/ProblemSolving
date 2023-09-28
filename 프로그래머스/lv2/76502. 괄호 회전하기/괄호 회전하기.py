def solution(s):
    global yalim
    answer = 0; yalim = ["[","(","{"] # 열림 괄호
    for i in range(len(s)):
        s = s[1:] + s[0]
        if rotation(s): answer += 1
    return answer
def rotation(lst):
    rlt = []
    for i in range(len(lst)):
        if lst[i] in yalim: rlt.append(lst[i])
        else:
            if len(rlt) == 0: return False;
            else: 
                now = rlt.pop()
                if now == "[" and lst[i] == "]":  continue
                elif now == "(" and lst[i] == ")":  continue
                elif now == "{" and lst[i] == "}":  continue
                else: return 0;   
    if len(rlt) != 0: return 0;
    return 1;