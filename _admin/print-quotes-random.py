import random

with open('pair-programming-quotes.csv') as f:
    quotes = [ l.strip().split(',')[1] for l in f.readlines()]
    random.shuffle(quotes)
    for q in quotes:
        print(q)
