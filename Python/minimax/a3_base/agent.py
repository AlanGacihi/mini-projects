import game
import random

class RandomPlayer(game.Player):
    
    def __init__(self, char):
        super().__init__(char)

    def choose_action(self, state):
        return random.choice(state.actions(self.char))
        

class MinimaxPlayer(game.Player):
    
    def __init__(self, char):
        super().__init__(char)

    def choose_action(self, state):
        if self.char == "X":
            for action in state.actions(self.char):
                if self.min_value(self.result(state, action)) == self.max_value(state):
                    return action
                
        else:
            for action in state.actions(self.char):
                if self.max_value(self.result(state, action)) == self.min_value(state):
                    return action

    def utility(self, state):
        """
        Returns 1 if X has won the game, -1 if O has won, 0 otherwise.
        """
        if state.winner() == "X":
                return 1
        elif state.winner() == "O":
                return -1
        else:
                return 0
        

    def result(self, state, action):
        """
        Returns a state after executing an action
        """
        return state.clone().execute(action)

    def max_value(self, state):
        """
        Returns the maximum value of a state
        """
        if state.game_over():
            return self.utility(state)
        v = -1
        for action in state.actions("X"):
            v = max(v, self.min_value(self.result(state,action)))
            if v == 1:
                return v
        return v


    def min_value(self, state):
        """
        Return the minimum value of a state
        """
        if state.game_over():
            return self.utility(state)
        v = 1
        for action in state.actions("O"):
            v = min(v, self.max_value(self.result(state, action)))
            if v == -1:
                return v
            
        return v
