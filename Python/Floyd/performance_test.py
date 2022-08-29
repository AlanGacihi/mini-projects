import time
from floyd import recursive_floyd_warshall
from testdata import graph1, graph2, graph3


# Print heading
print("Test                 Time")

tests = [graph1, graph2, graph3]

# Print execution time of each test
for test in tests:
    n = len(test)
    start_time = time.time()
    recursive_floyd_warshall(test)
    print(f"{n}x{n} graph            {time.time() - start_time} seconds")
