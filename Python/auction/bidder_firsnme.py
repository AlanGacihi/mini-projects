import numpy as np
import random


"""A Bidder class"""
class Bidder:

    """Set balance """
    balance = 0
    
    def __init__(self, num_users, num_rounds):
        """num_users contains the number of User objects in the game
        num_rounds contains the total number of rounds to be played"""
        self.price = None
        self.clicked = None
        self.balance = 0
        self.user_ids = []
        self.auction_winner = []

    def bid(self, user_id):
        """Bid on a user"""
        # Append user id to user_ids object
        self.user_ids.append(user_id)
        # Get a random bid amount
        bid_amount = random.randint(0, np.inf)
        # deduct the bid mount from user balance
        self.balance = self.balance - bid_amount
        # Return the bid amount
        # (returns a non-negative amount of money, in dollars.)
        return self.float_to_int(bid_amount)

    def notify(self, auction_winner, price, clicked=None):
        """Notifys the bidder"""
        # auction_winner is a boolean to represent whether the given Bidder won
        # the auction ( True ) or not ( False ).
        # price is the amount of the second bid, which the winner pays
        # clicked will contain a boolean value to
        # represent whether the user clicked on the ad. If the given Bidder did not win the auction,
        # clicked will always contain None .
        if clicked is not None:
            # Update balance if bidder won
            self.balance = self.balance - price
            # self.auction <= winner
            # Append auction winner to list
            self.auction_winner.append(auction_winner)
            self.price = price
            self.clicked = clicked

        # Return notification
        return "Won auction: " + auction_winner + " Price: " + price + " Clicked: " + clicked

    def float_to_int(x):
        """Convert float to int"""
        if x == float('inf') or x == float('-inf'):
            return float('nan')
        return int(x)

