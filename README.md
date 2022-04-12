# 2022-Spring-CS104-LOGIC
The assignments for Intruduction to Mathematic Logic in 2022 spring
I will introduce how to use my code and the meaning of each method in the following paragraphs.

***Input***: A number, which denotes how many letters are used to construct the truth-table. For example, if the input is number 3, which means we need to construct a truth-table of letters 'A', 'B', and 'C'.

***Output:*** A table showing the truth value of a simple formula consists of letters like 'A' and logic connectives like '→'. The first row denotes the formulas the truth-table generates. The remaining rows consist 'T' and 'F' to denote whether the corresponding formula is true or false.

***int pow(int n)***: This method is used to calculate the power of 2. The output is an int number 2^n where *n* is the input int number. 

***int factorial(int n):*** This method is used to calculate the factorial of a number. The output is an int number n! where *n* is the input int number.

***int com(int n):*** This method is used to calculate the combinatorial *C(n, 2)*. The output is an int number *C(n, 2) = n! / (2 \* (n-2)!)*.

***void init():*** This method is used to initialize the truth value of the formulas which only consist of a letter.

***void gray(int size, int i):*** It is a recursive method that is used to generate the gray code to specify the truth value of corresponding letters. The gray code is a string of binary code which only consists 0 and 1. The gray code is used to specify the truth value of the formulas which only consist of a letter. The input variable *size* denotes the number of bits in the gray code. For example, if the input number size = 3, there are 8 possible gray codes that have 3 bits including '000', '001', '011', '010', '110', '111', '101', '100'. If the gray code is '101', then formula A is true, formula B is false, and formula C is true. The input int number i is used in recursion.

***void set():*** This method is used to generate the truth value of formulas consisting of letters and logic connectives based on the truth value of primitive letters and the meaning of logic connectives.  

Example:
![image](https://user-images.githubusercontent.com/82224175/162928866-a8187879-0522-41c9-b594-5a56b212f2af.png)
