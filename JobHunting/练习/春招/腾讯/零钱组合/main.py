def money_count(m, n, money):
    if n == 0:
        return -1
    money = sorted(money)  # 将面值数从小到大排序
    if money[0] != 1:
        return -1
    else:
        sum = 0
        count = []
        for i in range(n):
            count.append(0)
        for i in range(1, m):
            count = iterator(i, count, money)
            print('i = {0}, count={1}'.format(i, count))
        for i in range(n):
            sum = sum + count[i]
        return sum


# p表示：需要凑的面值数，count是每种面值的个数（数组） money：所有的面值（数组，从小到达排序）
def iterator(p, count, money):
    # 1. 找到需要凑的数p 在 所给的面值的哪个区间内
    k = 0
    while money[k] <= p:
        k = k + 1
        if k == len(money):
            break
    # 2. 统计下之前有的面值的总钱数，是否和p相等，如果相等，count不变;不等， count[k-1]的个数要增加。
    all = 0
    for i in range(k):
        all = all + count[i] * money[i]
    if all != p:
        count[k-1] = max(p // money[k-1], count[k-1])
    # 3. 计算每个面值的数量（count）
    # （原则：先找面值大的，再找面值小的）
    if k == 1:
        return count
    else:
        i = k - 2
        while i >= 0:
            tmp = 0
            for j in range(i+1, k):
                tmp = tmp + count[j] * money[j]
            count[i] = max((i - tmp)//money[i], count[i])
            i = i - 1
        return count


if __name__ == '__main__':
    # m, n, money = create_input()
    # print(m)
    # print(n)
    # print(money)
    m = 20
    n = 4
    money = [1, 2, 5, 10]
    print('sum = {}'.format(money_count(m, n, money)))