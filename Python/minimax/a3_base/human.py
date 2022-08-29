import game

class HumanPlayer(game.Player):

    def __init__(self, char):
        super().__init__(char)

    def choose_action(self, state):
        for i in range(len(state.actions(self.char))):
            print(f"{i}: {state.actions(self.char)[i]}")

        return state.actions(self.char)[int(input("Please choose an action:"))]
