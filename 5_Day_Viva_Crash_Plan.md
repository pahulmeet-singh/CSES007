# 5-Day DSA Viva Crash Plan
**Today:** Sat, Aug 1, 5 PM &nbsp;|&nbsp; **Deadline:** Thu, Aug 6, 9 AM &nbsp;|&nbsp; **Real study time:** ~4.5 days

## The core strategy
Based on the pattern you're seeing — "explain reverse linked list," "write code for Armstrong number" — this is **simple-to-medium fundamentals, tested two ways**: verbal explanation of logic AND clean code written on the spot. Not deep algorithmic mastery. That changes how you prep:

1. **Explain AND code, every topic.** For each concept: say the approach out loud, then actually write the function by hand (paper or editor, no autocomplete). If you can't code it cleanly without help, you don't know it yet — talking about it isn't enough.
2. **Cover the full syllabus, but go deep only on the "core function" version of each topic.** You don't need every variant — you need to reliably write the canonical version (reverse a list, check Armstrong, find max in array) under pressure.
3. **One clean example per topic, ready to narrate** while you code (e.g., array `[3,1,4,1,5]`) — prep that once per topic and reuse it.
4. **Say the complexity out loud every time**, even if not asked. It signals understanding.
5. **Simple math/logic problems count as DSA too** — Armstrong number, palindrome number, prime check, GCD/LCM, swap without temp — these are exactly the "write code" style questions. Don't skip Day 0/Day 1 math topics thinking they're too basic to be asked.

---

## Day 0 — Sat 5 PM–10 PM (~5 hrs): Arrays, Strings, Searching, Sorting
*Foundation — almost guaranteed to come up.*

- [ ] Arrays: traverse, max/2nd max, remove duplicates, reverse, rotate (in-place), prefix sum, spiral matrix
- [ ] Strings: reverse words/vowels, palindrome check, anagram check, substrings vs subsequences
- [ ] Searching: linear vs binary, upper/lower bound, search insert position
- [ ] Sorting: bubble/selection/insertion (know how they work, don't need to code fast) + **be able to state Big-O for each and WHY**
- [ ] Complexity basics: O, Ω, Θ — be ready to define each in one sentence with an example

**Write from scratch (no notes, no autocomplete):**
- [ ] Reverse an array in-place
- [ ] Find max and second max in one pass
- [ ] Remove duplicates from a sorted array
- [ ] Reverse a string / reverse words in a string
- [ ] Check if a string is a palindrome
- [ ] Binary search (iterative AND recursive)
- [ ] Bubble sort or insertion sort, from memory

**Verbal drill before bed:** explain rotate-array 3 different ways (extra array, reversal trick, cyclic replacement) and their complexities.

---

## Day 1 — Sun (~6 hrs): Hashing, Two Pointers, Sliding Window, Recursion basics
*Second most commonly asked cluster.*

- [ ] Hashing: what is it, collision handling, map vs set vs multiset, O(1) average lookup — *why* average not worst case
- [ ] Frequency counter, distinct elements, pair sum, longest subarray with sum k
- [ ] Two pointers: two sum (sorted), merge sorted array, sort colors, trapping rain water
- [ ] Sliding window: max subarray of size k, longest substring without repeating chars, Kadane's algorithm
- [ ] Recursion: base case + recursive case framing, factorial, fibonacci, climbing stairs, Pow(x,n) — **know recursion tree / call stack visualization**, this is a favorite verbal question
- [ ] Math basics (very commonly asked as standalone "write the code" questions): Armstrong number, palindrome number, prime check, Sieve of Eratosthenes, GCD & LCM, swap two numbers without a temp variable
- [ ] Bit manipulation basics: check odd/even using bits, count set bits, check power of two, find the missing number

**Write from scratch:**
- [ ] Armstrong number checker
- [ ] Prime number checker + Sieve of Eratosthenes
- [ ] GCD (Euclidean algorithm) and LCM
- [ ] Factorial (iterative and recursive)
- [ ] Fibonacci (iterative and recursive) — be ready to explain why recursive is exponential without memoization
- [ ] Two-sum on a sorted array using two pointers
- [ ] Kadane's algorithm

**Verbal drill:** explain Kadane's algorithm start to finish with a live example, no notes.

---

## Day 2 — Mon (~6 hrs): Linked List, Stack, Queue, Trees
- [ ] Linked list: traversal, reversal, detect/remove loop (Floyd's cycle), middle of list, merge two sorted lists
- [ ] Stack: valid parenthesis, next greater element — know the "why stack" intuition
- [ ] Queue/Deque: implementation basics, sliding window maximum (conceptual, not full code)
- [ ] Trees: structure, preorder/inorder/postorder (know the *order* by heart), level order = BFS, height of tree
- [ ] Tree extras: left/right view, LCA (concept), balanced tree check

**Write from scratch:**
- [ ] Reverse a singly linked list (iterative AND recursive — a very common pair of asks)
- [ ] Find the middle of a linked list (slow/fast pointer)
- [ ] Detect a loop in a linked list (Floyd's algorithm)
- [ ] Merge two sorted linked lists
- [ ] Check for balanced parentheses using a stack
- [ ] Tree traversals: preorder, inorder, postorder (recursive)
- [ ] Level order traversal (BFS using a queue)
- [ ] Height of a binary tree

**Verbal drill:** explain why detecting a cycle needs two pointers (slow/fast) and prove why they must meet.

---

## Day 3 — Tue (~6 hrs): BST, Heap, Greedy, Backtracking, Graphs (core)
- [ ] BST: search/insert/delete logic, validate BST, kth smallest (in-order gives sorted order — key insight)
- [ ] Heap: what makes it a heap, heap sort idea, priority queue use cases, kth largest element
- [ ] Greedy: activity selection, fractional knapsack — be ready to explain *why greedy works here but not always*
- [ ] Backtracking: concept vs plain recursion (the "undo" step), N-Queens or Sudoku at a high level
- [ ] Graphs: representations (adjacency list vs matrix — tradeoffs), BFS vs DFS (when to use which), cycle detection, topological sort (Kahn's) at a conceptual level

**Skip unless you have spare time:** Dijkstra/Bellman-Ford/Floyd-Warshall/MST — know *one sentence* on what each solves, that's often enough for a viva if it comes up at all.

**Write from scratch:**
- [ ] BST insert and search (recursive)
- [ ] Validate BST
- [ ] Build a max-heap conceptually / know how sift-up/sift-down works (full heap sort code is lower priority — understand it, code it if time allows)
- [ ] BFS and DFS on a graph (adjacency list)
- [ ] Cycle detection in a graph (at least the undirected case with a visited set)

---

## Day 4 — Wed (~6 hrs): DP essentials + Full Review
- [ ] DP core idea: overlapping subproblems + optimal substructure — this exact phrase gets asked
- [ ] Memoization (top-down) vs tabulation (bottom-up) — be ready to convert one to the other verbally
- [ ] House Robber, 0-1 Knapsack, Coin Change, LCS, LIS — know the *state definition* for each (this is what interviewers probe)
- [ ] Afternoon: **speed-run review** — go topic by topic from Day 0, and for each, say out loud: problem → approach → complexity, in under 90 seconds each
- [ ] Evening: pick your 5 weakest topics and re-drill only those

**Write from scratch:**
- [ ] Fibonacci with memoization (top-down) and tabulation (bottom-up) — the classic "convert this to DP" ask
- [ ] 0-1 Knapsack (tabulation)
- [ ] Longest Common Subsequence (LCS)

**Final gut-check for every topic covered since Day 0:** can you write the function AND explain it out loud without looking at your notes? If not, it's not ready — flag it for the evening re-drill.

---

## Thu 9 AM — Viva
Sleep well Wednesday night over cramming till 2 AM — tired recall kills verbal clarity far more than a gap in knowledge.

## During the viva itself
- If you don't know a topic, say what you *do* know adjacent to it (e.g., "I haven't gone deep on Floyd-Warshall, but I know Dijkstra solves single-source shortest path using a greedy + priority queue approach...")
- Always state brute force first, then optimize — shows process, not just an answer
- Narrate as you think, even mid-mistake — silence looks worse than a visible correction
