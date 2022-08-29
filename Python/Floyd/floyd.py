import sys


def recursive_floyd_warshall(graph):
    """
    Finds the shortest path between all pairs of nodes using
    the Floyd-Warshall algorithm.
    """
    def shortest_path(i, j, k):
        """
        Finds the shortest path from i to j using only
        vertices 0 through k as intermediaries.
        """
        if (i, j, k) in cache:
            return cache[i, j, k]

        length = min(shortest_path(i, j, k-1),
                     shortest_path(i, k, k-1) + shortest_path(k, j, k-1))

        cache[i, j, k] = length
        return length

    cache = {}
    n = len(graph)
    indices = range(n)

    # preload the cache
    for i in indices:
        for j in indices:
            cache[i, j, -1] = graph[i][j]

    # compute all-pairs shortest paths
    d = {}
    for i in indices:
        for j in indices:
            m = shortest_path(i, j, n-1)
            if m == sys.maxsize:
                continue
            d[i, j] = m

    return d
