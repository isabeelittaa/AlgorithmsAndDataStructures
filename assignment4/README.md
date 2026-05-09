A. Project Overview
A graph is a group of vertices (nodes) connected by edges (links). In this project, the graph is directed, which means every edge has a direction from one vertex to another.

- Vertex is a node with a unique integer id
- Edge is connection from one vertex to another

The project uses two graph traversal algorithms:
Breadth-First Search (BFS)
BFS visits vertices level by level. It first visits all nearby neighbors before moving deeper into the graph.
It uses a queue (FIFO).

BFS is useful for:
_ shortest path in unweighted graphs
_ finding minimum number of steps
_ level-order traversal

Depth-First Search (DFS)
DFS goes as deep as possible into one path before returning back.
It is implemented using recursion.

DFS is useful for:
_ graph exploration
_ cycle detection
_ topological sorting


B. Class Descriptions
    Class       |                     Description
    Vertex	    |                   Stores vertex id
    Edge	    |               Represents directed edge
    Graph	    |   Stores vertices and adjacency list, implements BFS and DFS
    Experiment	|           Measures BFS and DFS execution time
    Main	    |                   Starts the program

The graph uses an adjacency list, where each vertex stores a list of connected vertices. Space complexity: O(V + E)


C. Algorithm Descriptions
BFS Algorithm
1. Add start vertex to queue
2. Mark it as visited
3. Remove vertex from queue
4. Visit all unvisited neighbors
5. Repeat until queue is empty
Time complexity: O(V + E)

DFS Algorithm
1. Visit current vertex
2. Mark it as visited
3. Recursively visit neighbors
Time complexity: O(V + E)


D. Experimental Results
How to Run
From the project root(terminal):
**javac -d out src/*.java**
**java -cp out Main**

Experimental Results
Execution Time Tables:
Vertices	BFS (ns)	DFS (ns)
   10	     363542	     224042 
   30	     307916 	 174667
   100       367000      300167

Observations
Both BFS and DFS become slower as graph size increases.
Their performance is usually similar because both work in O(V + E) time.
BFS explores the graph level by level.
DFS explores one branch deeply before backtracking.
BFS is better for shortest path problems.
DFS may cause stack overflow on very deep graphs because of recursion.


E. Screenshots in the docs/screenshots/


F. Reflection
This project helped understand how graphs work and how BFS and DFS traverse vertices differently. BFS uses a queue and explores level by level, while DFS uses recursion and explores deeply first. The main challenge was understanding directed graphs and comparing algorithm performance fairly.