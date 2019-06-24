# PacMan
Simulating PacMan 
the basic idea is that pacMan is to eat all the points(black dots on the screen) while avoiding the ghosts(obvious) and advance to the next level when all the points have been eaten by the pacMan. Now I have only added only 2 rounds. each time a ghost catches pacMan game stops and asks for reset or exit. 
also internally it is a array of 1000x700 which i still think is not the best way to do it . The occupied class is used to put something on the screen and make it an object which dont allows the pacMan or the ghosts to pass.
For the ghosts and pacMan i Have used 4 different threads. All the code is written in java. Except the Play.exe and install.exe which are written in cPP just for compiling and executing the code directly and not from the terminal. 
The Ghost uses simple way to catch the PacMan which is if the upper left corner pixels x or y coordinates match then it turns in the direction of pacMan. This can also be improved i guess. another thread is used to repaint all the items (pacMan, 3 ghosts, and the score unit on the uper right corner)
Previosly i also added a var for speed controlling of the pacMan with which speed of pacMan could be changes while playing, but later i removed it for certain bugs. also i should have used some sort of gui interface such as 'qt' or something else but i wanted the whole thing to be writter in java .
Further I am thinking of adding more ghosts and a improved algorithm for following pacman. 
Also the code is a bit messy. I will try to indentate it properly.
Peace out.
