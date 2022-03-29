# dsa-array-java

This repository contains **Array** problems implemented in **Java**.

Some information in the problems can be found duplicated with respect to other problems but that redundant information is useful while revisiting.

### Resources and Links
1. *Book:- DATA STRUCTURES AND ALGORITHMS MADE EASY IN JAVA By Narasimha Karumanchi*
2. *Book:- CRACKING the CODING INTERVIEW 6TH EDITION By GAYLE LAAKMANN MCDOWELL*
3. *[GeeksforGeeks Array Practice Problems](https://practice.geeksforgeeks.org/explore?page=1&category[]=Arrays&sortBy=submissions)*
4. *[Hackerrank Array Practice Problems](https://www.hackerrank.com/domains/data-structures?filters%5Bsubdomains%5D%5B%5D=arrays)*
5. *[Leetcode Array Problems](https://leetcode.com/tag/array/)*
6. *[Codechef Array Problems](https://www.codechef.com/tags/problems/array)*
7. *[iq.opengenus.org Array Problems](https://iq.opengenus.org/list-of-array-problems/)*

### Each code file contains:
	- Problem Statement
		- Resource Name / URL [Book / Website Link]
	- Input/Output Contraints
	- Discussion and Solution
		- Algorithm
		- Data Structure used
		- Complexity
	- Implementation
		- Code 
        - Output
        - Comments to explain the code [for revision purpose]
	- Notes
		- [If any]

**Connect to me on [LinkedIn](https://www.linkedin.com/in/rahulrajpandey/)** :relaxed:

***

# Notes on Array Data Structure
**The Time Complexity of different operations in an array is:**

| Array Operation                 | Assumed Time Complexity | Space Complexity |
|---------------------------------|-------------------------|------------------|
| Access i-th element             | O(1)                    | O(1)             |
| Override element at i-th index  | O(1)                    | O(1)             |
| Traverse all elements           | O(n)                    | O(1)             |
| Insert element                  | O(n)                    | O(1)             |
| Delete element                  | O(n)                    | O(1)             |

-- O(1) complexity means Constant Time
-- O(n) complexity in the above table, refers `n` as the length of the array. 

**Array --> Subarray, Subsequence, Subset**
- *Lets assume an array:- {1,2,3,4}*
- *Subarray: contiguous sequence in an array i.e. {1,2},{1,2,3}*
- *Subsequence: Need not to be contiguous, but maintains order i.e. {1,2,4}*
- *Subset: Same as subsequence additionally it has empty set i.e. {1,3},{}*

- *Given an array/sequence of size n, possible*
    - Subarray = n*(n+1)/2
    - Subseqeunce = (2^n) -1 (non-empty subsequences)
    - Subset = 2^n

- *Brian Kernighan’s Algorithm - Count Set Bits in a Number : O(log N)*
    - If we subtract a number by 1 and do it bitwise & with itself (n & (n-1)), we unset the rightmost set bit. 
    - If we do n & (n-1) in a loop and count the number of times the loop executes, we get the set bit count.
    - The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer.
    - In Java, Integer.bitCount() does the same.