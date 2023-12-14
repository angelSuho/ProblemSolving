import datetime

def solution(book_time):
    for book in book_time:
        book[0] = datetime.datetime.strptime(book[0], "%H:%M")
        book[1] = (datetime.datetime.strptime(book[1], "%H:%M") + datetime.timedelta(minutes=10))
    flag = 1
    book_time.sort(key=lambda x:x[0])
    rooms = [book_time.pop(0)]
    for book in book_time:
        for room in rooms:
            tmp = room
            while type(tmp) != datetime.datetime: tmp = tmp[-1]
            if tmp <= book[0]:
                room.append(book)
                flag = 0; break
            else: flag = 1
        if flag:
            rooms.append(book)
    print(rooms)
    return len(rooms)