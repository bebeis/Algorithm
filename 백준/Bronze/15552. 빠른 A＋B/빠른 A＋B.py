import sys

i_size = int(sys.stdin.readline().rstrip())

for i in range(i_size):
    a, b = map(int, sys.stdin.readline().split())
    print(a + b)