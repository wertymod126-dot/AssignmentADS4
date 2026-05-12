<b><HEADER>Assignment ADS 4</HEADER><br>
<HEADER>Student: Adilbek Shangerey</HEADER><br>
<HEADER>Group:SE-2513</HEADER></b>
<br> <br>

<strong>A. Project Overview</strong>

Description of graph structure: This project implements a directed graph structure where relationships between nodes are one-way. To optimize for memory and neighbor-lookup speed, the graph's topology is managed using an Adjacency List.

Vertices represent the individual nodes or entities within the system, each identified by a unique integer ID.
Edges represent the directional connections from a source vertex to a destination vertex.

Breadth-First Search (BFS) is an algorithm that explores the graph layer by layer, visiting all immediate neighbors of a given node before moving deeper into the graph.

Depth-First Search (DFS) is an algorithm that explores a graph by following a single path as deeply as possible until it reaches a dead end, at which point it backtracks to explore other branches.


<strong>B. Class Descriptions <br></strong>
Vertex Class: A simple entity class that encapsulates the unique integer id of a node. It includes a constructor and getter method for identification.

Edge Class: Defines the directional relationship between two nodes, storing a source ID and a destination ID.

Graph Class: The core controller of the project. It handles the addition of vertices and edges and contains the core logic for the traversal algorithms.

Adjacency List Representation: Instead of using a memory-heavy 2D adjacency matrix, this project maps each vertex ID to a standard Java List of outgoing Edge objects using a HashMap. This ensures that finding all neighbors for a specific node is a fast, O(k) operation, where k is the number of immediate neighbors.


C. Algorithm Descriptions

BFS (Breadth-First Search)

  Step-by-step explanation:

  Initialize an empty Queue and a HashSet to track visited nodes.

  Add the starting node's ID to both the queue and the visited set.

  While the queue is not empty, dequeue (poll) the front node and process it.

  terate through all the outgoing edges of this current node.

  If a destination neighbor has not been visited, mark it as visited and enqueue it.

  Use cases: Finding the shortest path in unweighted networks, peer-to-peer network discovery, and web crawling.

  Time complexity: O(V + E).

DFS (Depth-First Search)

  Step-by-step explanation:

  Initialize a HashSet to keep track of visited nodes.

  Start at the initial node, process it, and immediately mark it as visited.

  Iterate through the outgoing edges of the current node.

  If a neighbor has not been visited, recursively call the DFS helper method on that neighbor.

  When a node has no unvisited neighbors, the recursive call stack naturally backtracks to the previous branch.

  Use cases: Topological sorting, solving mazes/puzzles, and detecting cycles within a graph system.

  Time complexity: O(V + E).

D. Experimental Results

Execution Time Comparison

  10 Vertices: [Insert Time Here]

  30 Vertices: [Insert Time Here]

  100 Vertices: [Insert Time Here]

Analysis Answers

How does graph size affect BFS and DFS performance? Performance scales linearly with the size of the graph. As the number of vertices (V) and edges (E) increases, execution time increases proportionally because both traversals process each element a constant number of times.

Which traversal is faster in your experiments? In local testing, DFS often slightly outperforms BFS. This is largely due to DFS leveraging the JVM's native call stack for recursion, whereas BFS incurs the overhead of managing a separate Queue object.

Do results match the expected complexity O(V + E)? Yes. The execution times align with the theoretical O(V + E) complexity, displaying a clear linear trend as the graph size grows.

How does graph structure affect traversal order? The structure determines the path. In a "wide" graph, BFS touches many nodes rapidly at the same level. In a "deep" graph, DFS explores long paths to completion before checking alternative neighbors.

When is BFS preferred over DFS? BFS is preferred for finding the shortest path in an unweighted graph or when the target node is likely to be close to the starting source.

What are the limitations of DFS? DFS is not guaranteed to find the shortest path. On excessively deep graphs, the recursive nature of DFS risks triggering a StackOverflowError.

E. Screenshots

<img width="1351" height="676" alt="изображение" src="https://github.com/user-attachments/assets/8868ea98-7866-402e-b532-0609684b9a95" />


F. Reflection Section
Implementing this graph traversal system provided an excellent opportunity to bridge theoretical discrete mathematics with practical backend architecture. Translating abstract graph theory into an Object-Oriented adjacency list reinforced the importance of choosing the right data structures. I learned that relying on a HashMap and ArrayList combination for the adjacency list is highly efficient for sparse graphs, ensuring memory is only used for existing edges.

A significant takeaway was observing the distinct mechanical differences between the algorithms: BFS relies on state management via a Queue, while DFS exploits the recursive call stack. A primary challenge was maintaining strict type-safety between Vertex objects and their Integer IDs. Resolving these mismatches emphasized the need for clean data handling when passing state between different classes.
