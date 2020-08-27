#!/bin/bash
for i in {1..10}; do
    echo i
    python x.py &
    wait
done 2>/dev/null

#https://www.geeksforgeeks.org/mv-command-linux-examples/