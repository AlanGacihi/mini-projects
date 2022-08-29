import sys

NO_PATH = sys.maxsize

"""
       10
  (0)------->(3)
    |         |
  5 |         |
    |         | 1
    |         |
  (1)------->(2)
        3
"""
graph1 = [[0, 5, NO_PATH, 10],
          [NO_PATH, 0, 3, NO_PATH],
          [NO_PATH, NO_PATH, 0, 1],
          [NO_PATH, NO_PATH, NO_PATH, 0]
          ]


"""
         8
  (0)------->(3)
    |         |
  7 |         |
    |         | 2
    |         |
  (1)------->(2)
        5
"""
graph2 = [[0, 7, NO_PATH, 8],
          [NO_PATH, 0, 5, NO_PATH],
          [NO_PATH, NO_PATH, 0, 2],
          [NO_PATH, NO_PATH, NO_PATH, 0]
          ]


"""
        12
  (0)------->(3)
    |         |
  6 |         |
    |         | 1
    |         |
  (1)------->(2)
         4
"""

graph3 = [[0, 6, NO_PATH, 12],
          [NO_PATH, 0, 4, NO_PATH],
          [NO_PATH, NO_PATH, 0, 1],
          [NO_PATH, NO_PATH, NO_PATH, 0]
          ]
