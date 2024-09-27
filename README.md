# Bin Packing Algorithm
Language: Java

This program takes in two pieces of user input: a number (int) of items of a randomly generated size to be packed, and a number (int) to indicate the amount of space available in a single bin. The goal is to take all of those items and pack them into the fewest number of bins possible to maximize space- we do this using two functions: firstFit and nextFit. 

- firstFit: places each item in the first bin that has enough remaining space to accommodate it

- nextFit: starting from the most recent bin accessed, searches bins sequentially until one is found which has enough space 

The program prints the results of both functions, showing the contents of each bin and the number of bins used. 
