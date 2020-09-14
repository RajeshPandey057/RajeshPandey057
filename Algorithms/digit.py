def bit_score(l):
    Score = []
    for i in l:
        temp = (list(map(int, str(i))))
        Score.append(((max(temp) * 11 + min(temp) * 7) % 100))
    return Score


def calc(l):
    even = [0] * 10
    odd = [0] * 10
    result = 0
    for i in range(0, len(l), 2):
        even[(int(l[i]) // 10)] += 1
    for i in range(1, len(l), 2):
        odd[(int(l[i]) // 10)] += 1
    for i in range(0, 10):
        if odd[i] > 2 or even[i] > 2:
            result += 2
        elif odd[i] == 2 or even[i] == 2:
            result += 1
    print(result, end="")


no = int(input())
digits = list(map(int, input().split()))
bs = bit_score(digits)
calc(bs)
