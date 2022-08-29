import unittest
from testdata import graph1, graph2, graph3
from floyd import recursive_floyd_warshall


class Test_Floyd_Warshall(unittest.TestCase):
    """
    Unit Test Cases
    """
    def test_floyd1(self):
        """Test on graph 2"""
        actual = recursive_floyd_warshall(graph=graph2)
        expected = {(0, 0): 0, (0, 1): 7, (0, 3): 8, (0, 2): 12,
                    (1, 1): 0, (1, 3): 7, (1, 2): 5, (2, 2): 0,
                    (2, 3): 2, (3, 3): 0}
        self.assertEqual(actual, expected)

    def test_floyd2(self):
        """Test on graph 3"""
        actual = recursive_floyd_warshall(graph=graph3)
        expected = {(0, 0): 0, (0, 1): 6, (0, 2): 10, (0, 3): 11,
                    (1, 1): 0, (1, 2): 4, (1, 3): 5, (2, 2): 0,
                    (2, 3): 1, (3, 3): 0}
        self.assertEqual(actual, expected)

    def test_floyd3(self):
        """Test on graph 1"""
        actual = recursive_floyd_warshall(graph=graph1)
        expected = {(0, 0): 0, (0, 2): 8, (0, 1): 5, (0, 3): 9,
                    (1, 1): 0, (1, 2): 3, (1, 3): 4, (2, 2): 0,
                    (2, 3): 1, (3, 3): 0}
        self.assertEqual(actual, expected)
