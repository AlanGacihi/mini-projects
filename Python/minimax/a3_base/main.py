import game
import agent
import human
import util
import sys

def main():
    
    player1 = assign_player(sys.argv[1], "X")
    player2 = assign_player(sys.argv[2], "O")

    results = game.Game(player1, player2).play()
    
    print(f"{results[0]} wins")
    for state in results[1]:
        util.pprint(state)


def assign_player(user, char):
    if user == "human":
        return human.HumanPlayer(char)
    elif user == "random":
        return agent.RandomPlayer(char)
    elif user == "minimax":
        return agent.MinimaxPlayer(char)
    else:
        return None


if __name__ == '__main__':
    main()