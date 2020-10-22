//authors: Olivia Caponigro, Alex Arnell, Natalie Konschnik, Talia Feldman, Josh Lyon

Time Complexity Analysis:

    r = lines in input file
    c = unique cows

    1. Lines 38 - 58 run once for every record in the input file O(r)
        - adding cows to the HashMap takes O(1)
        - updating cows in the HashMap takes O(1)
        - adding cows to the cowList takes O(1)

    2. Collections.sort() runs in O(c * log(c)) time and runs once per
    execution of the program

    3. The only loops in the program are steps 1 and 2, which combined give a
    time complexity of O((c * log(c)) + r). 