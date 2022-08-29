import util
import connect3

class Player:

    def __init__(self, char):
        self.char = char

    def choose_action(self, state):
        pass

class Game:
    
    state = connect3.State()
        
    def __init__(self, player1, player2):
        self.player1 = player1
        self.player2 = player2
        
    def play(self):
        player = self.player1
        visits = []
        
        while True:
            move = player.choose_action(self.state)
            
            result = self.state.execute(move)
            util.pprint(result)
            visits.append(result)

            if result.game_over():
                return (result.winner(), visits)
            else:
                if player == self.player1:
                    player = self.player2
                else:
                    player = self.player1
