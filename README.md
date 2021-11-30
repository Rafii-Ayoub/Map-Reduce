# Map Reduce

![](https://forthebadge.com/images/badges/made-with-java.svg) 


The goal of this project is to reproduce the behavior of Hadoop on the example of
word count seen in class labs. So I must design a distributed word counting platform
based on map-reduce (to be programmed with Sockets or RMI ).This project must not use the platform of
Hadoop, 

-As input:  a set of text files containing words; 
-As output: a dictionary comprising all the words associated with the counter of their number of occurrences.
  
In a first phase, a stain by
file will count the number of occurrences of the words in the file it
received (MAP), secondly a fixed number of spots
"Reduce" will recover from each of the spots map the sub
set of words for which it is "responsible" and count for
each of these words, the total number of occurrences.

To test my platform you can take web pages
any. Test your platform by varying the number of machines
working in parallel and observe (measure) the effects

 [![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)](https://github.com/Naereen/badges/)
 
# Table of content: 

[1. Modeling the problem](Modeling the problem)
[2. Installation](Modeling the problem)
[3. Steps of coding](Steps of coding)

## Modeling the problem

#### We used this diagram as an example of our system
![](images/diagram1.PNG)

#### To start coding I made a UML diagram
![](images/uml1.PNG)

## Installation 


```
$ git clone https://github.com/Rafii-Ayoub/Map-Reduce

```

## Steps of coding

