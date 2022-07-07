"""
NAME:
"""

# Simple Calculator Program
# using tkinter GUI module
from tkinter import *
import tkinter.messagebox as mb
 
def add_numbers():
    """Add two numbers"""
    if not is_valid():
        return
    res=float(e1.get()) + float(e2.get())
    res = round(res,4)
    label_text.set(res)

def subtract_numbers():
    """Subtract two numbers"""
    if not is_valid():
        return
    res=float(e1.get()) - float(e2.get())
    res = round(res,4)
    label_text.set(res)

def multiply_numbers():
    """Multiply two numbers"""
    if not is_valid():
        return
    res=float(e1.get()) * float(e2.get())
    res = round(res,4)
    label_text.set(res)

def divide_numbers():
    """Divide two numbers"""
    if not is_valid():
        return
    
    # Prevent ZeroDivisionError
    if int(e2.get()) == 0:
       mb.showerror('Error!', "Cannot divide by zero")
       return
    res=float(e1.get()) / float(e2.get())
    res = round(res,4)
    label_text.set(res)

def exit():
    """Exit from calculator"""
    window.destroy()

def reset():
    """Reset the input entry boxes"""
    e1.delete(0, 'end')
    e2.delete(0, 'end')
    label_text.set("")

def is_valid():
    """Check if two numbers are entered(only numbers)"""
    
    # Check if first number and second number are entered
    if not e1.get() or not e2.get():
        mb.showerror('Error!', "Please Enter two numbers")
        return False
    
    # Check if numbers are enetered
    try:
        res=float(e1.get())+ float(e2.get())
    except:
        mb.showerror('Error!', "Only numbers are allowed")
        return False
    
    return True

 
window = Tk()
window.geometry("550x400")
window.title("Calculator")
label_text=StringVar()
Label(window, text="Enter First Number:").grid(row=0, column=0,sticky=W)
Label(window, text="Enter Second Number:").grid(row=1,column=0, sticky=W)
Label(window, text="Result:").grid(row=2,column=0, sticky=W)
result=Label(window, text="", textvariable=label_text, fg="red", font=("yu gothic ui", 20, "bold")).grid(row=2,column=1, sticky=W)
 
# Create entry buttons
e1 = Entry(window)
e2 = Entry(window)
 
e1.grid(row=0, column=1)
e2.grid(row=1, column=1)

# Create buttons
b1 = Button(window, text="Add", width=10,command=add_numbers)
b1.grid(row=0, column=2, padx=5, pady=5,sticky=W)
 
b2 = Button(window, text="Subtract", width=10,command=subtract_numbers)
b2.grid(row=0, column=3, padx=5, pady=5,sticky=W)

b3 = Button(window, text="Multiply", width=10,command=multiply_numbers)
b3.grid(row=1, column=2, padx=5, pady=5,sticky=W)

b4 = Button(window, text="Divide", width=10, command=divide_numbers)
b4.grid(row=1, column=3, padx=5, pady=5,sticky=W)

b5 = Button(window, text="Reset", width=10, command=reset)
b5.grid(row=0, column=4, padx=5, pady=5,sticky=W)

b6 = Button(window, text="Exit", width=10, command=exit)
b6.grid(row=1, column=4, padx=5, pady=5,sticky=W)
 
window.mainloop()
