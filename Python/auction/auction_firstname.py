import random


"""Auction class"""
class Auction:
    # Initializer
    def __init__(self, users, bidders):
        """Implement Auction process"""
        # a list of all User objects.
        self.winner = None
        self.users = users
        # a list of all Bidder objects
        self.bidders = bidders
        # An object to contains a dictionary of the current balance of every Bidder 
        self.balances = {}
        for i in range(len(self.bidders)):
            self.balances[self.bidders[i]] = self.bidders[i].balance

    #  A to execute all steps within a single round of the game.
    def execute_round(self):
        """A to execute all steps within a single round of the game."""
        # Generate random user IDs
        user_id = random.randint(0, (len(self.users) - 1))
        # Notify list
        notifylist = []
        max1 = 0
        winning_price = 0
        self.winner = ''
        # Loop through all bidders
        for bidder in self.bidders:
            abid = bidder.bid(user_id)
            if abid > max1:
                winning_price = max1
                max1 = abid
                notifylist.clear()
                notifylist.append(bidder)

            if abid == max1:
                notifylist.append(bidder)

        # Get bid winner
        if len(notifylist) == 1:
            self.winner = notifylist[0]
        else:
            self.winner = notifylist[random.randint(0, (len(notifylist) - 1))]

        # Show ad to user
        val = self.users[user_id].show_ad()

        # Notify bidders
        for bidder in self.bidders:
            if bidder is self.winner:
                # Bidder class need to Bidder imported from bidder_ file
                bidder.notify(self.winner, winning_price, val)
            else:
                bidder.notify(self.winner, winning_price)

        # Update bid balance
        keys = self.bidders
        values = []
        for bidder in self.bidders:
            values.append(bidder.balance)

        val_iterator = 0
        for key in keys:
            self.balances[key] = values[val_iterator]
            val_iterator = val_iterator + 1


"""User Class"""
class User:
    
    """Represents the probability of clicking on an ad."""
    __probability = float(random.randint(0, 1))
    
    """showing an ad to this User."""
    def show_ad(self):
        """return true or false to represent the user clicking on"""
        return True if self.__probability == 1 else False
