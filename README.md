
# ARRAY

- Array
  ⇒ List of Elements of the same type placed in a contiguous memory location.

  Operations

    - create
    - Input
    - Output
    - Update

  create

  syntax ⇒ `dataType arrayName[] = new dataType[size];`

  Examples :

  int marks[] = new int[10];

  int numbers = { 1, 2, 3 };

  int moreNumbers = { 4, 5, 6 };

  String fruits = { “apple”, “mango”, “orange” };

  input

  marks[0] = sc.nextInt()    // 10

  marks[1] = sc.nextInt()    //  20

  marks[2] = sc.nextInt()   // 30

  update

  marks[0] = 40

  marks[1] = 50

  marks[2] = 60

  ⇒ to find the length of the array → arr.length

  Passing arrays as argument

    - pass by value
        - In **pass by value**, **a copy of the actual value is passed** to the method.
        - Changes made to the parameter inside the method **do not affect the original variable**.
    - pass by reference
        - In **pass by reference**, a method receives a **reference (address)** of the original variable, so changes affect the original variable.

  `Java is **always pass by value**.`

  `What changes for objects: the **value that is passed is the reference**.`

  `You **cannot reassign the reference** in the method and expect the original variable to change`

  **`Important:** Java **does not support true pass by reference** for      primitives. But for **objects**, you can modify the object's internal state.`

  | **Problems** | **Time Complexity** |
      | --- | --- |
  | Linear search | $O(n)$ |
  | Largest number | $O(n)$ |
  | Smallest number | $O(n)$ |
  | Binary search | $O(log n)$ |
  | Reverse an array | $O(n)$ |
  | Pairs in an array | O (  $n^2$  ) |
  | Subarrays | $O ( n^3 )$ |
  | MaxSubarraySum | $O (n^3)$ |
  | Kadan’s algorithm | $O (n)$ |
  | Trapped Rain Water | $O(n)$ |
  | Best time to buy and sell stocks | $O(n)$ |

# Sorting

- Sorting
  ⇒ Sorting is the process of arranging data (numbers, strings, objects) in a **specific order** (ascending or descending).


    **Basic Algorithms**
    
    - Bubble sort
    - Selection sort
    - Insertion sort
    - Counting sort ( advanced )
    
    **Bubble Sort** 
    
    - The **biggest bubble** rises to the top with each pass.
    - Similarly, in bubble sort, the **largest element moves to the end** in every round.
    
    ### How It Works (Step by Step)
    
    Example: `[5, 3, 1, 4]`
    
    1. Compare **first two** (5 and 3) → swap → `[3, 5, 1, 4]`
    2. Compare (5 and 1) → swap → `[3, 1, 5, 4]`
    3. Compare (5 and 4) → swap → `[3, 1, 4, 5]`
        
        👉 Now the **largest (5)** is at the end.
        
    
    Next pass:
    
    1. Compare (3 and 1) → swap → `[1, 3, 4, 5]`
    2. Compare (3 and 4) → no swap.
    
    👉 Done! The array is sorted.
    
    `TOC  ⇒ $O(n^2)$`
    
    **Selection Sort**
    
    - In each pass, you **find the smallest element** from the unsorted part.
    - Swap it with the element at the beginning of the unsorted part.
    - After each pass, the **sorted portion grows** from the left.
    
    ---
    
    ## 🔹 Example
    
    Array: `[5, 3, 1, 4]`
    
    1. **Pass 1:** Find min in `[5,3,1,4]` → min=1
        
        Swap with first → `[1,3,5,4]`
        
    2. **Pass 2:** Find min in `[3,5,4]` → min=3
        
        Already in place → `[1,3,5,4]`
        
    3. **Pass 3:** Find min in `[5,4]` → min=4
        
        Swap with 5 → `[1,3,4,5]`
        
    
    ✅ Sorted!
    
    ---
    
    ### Time Complexity
    
    - Best case: **O(n²)**
    - `Worst case: **O(n²)**`
    - Space: **O(1)** (in-place)
    - Stability: ❌ **Not stable** (equal elements may change order).
    
    **Insertion Sort**
    
    - Start with the first card (already “sorted”).
    - Pick the next card and insert it into the correct position among the already sorted cards.
    - Keep doing this until all cards are in the right order.
    
    That’s **Insertion Sort**.
    
    ---
    
    ### 🔹 Example
    
    Array: `[5, 3, 1, 4]`
    
    1. Start with first element `[5]` → already sorted.
    2. Pick 3 → insert before 5 → `[3, 5, 1, 4]`
    3. Pick 1 → insert before 3 → `[1, 3, 5, 4]`
    4. Pick 4 → insert between 3 and 5 → `[1, 3, 4, 5]`
    
    ✅ Sorted!
    
    ---
    
    ### Time Complexity
    
    - Best case (already sorted): **O(n)**
    - Average case: **O(n²)**
    - `Worst case (reverse order): **O(n²)**`
    - Space: **O(1)** (in-place)
    - Stability: ✅ **Stable** (preserves order of equal elements).
    
    **Inbuilt Sort**
    
    - Java provides **ready-to-use sorting methods** in the standard library, which are **much faster and optimized** than manual sorting.
    1. Arrays.sort()
        - Used to sort arrays (primitive types or objects).
        
        ```java
        import java.util.Arrays;
        
        int[] arr = {5, 3, 1, 4};
        Arrays.sort(arr);  // sorts in ascending order by default
        ```
        
        - For descending order (objects like Integer), use **Comparator**:
        
        ```java
        Integer[] arr = {5, 3, 1, 4};
        Arrays.sort(arr, (a, b) -> b - a);  // descending order
        ```
        
    
    - **Time Complexity:**
        - **Primitive arrays:** Dual-Pivot QuickSort → O(n log n) average
        - **Objects:** MergeSort (stable) → O(n log n)
        
    1. Collections.sort()
        - Used to sort **lists** (ArrayList, LinkedList).
        
        ```java
        import java.util.*;
        
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 1, 4));
        Collections.sort(list);  // ascending order
        ```
        
    
    - Descending order
    
    ```java
    Collections.sort(list, Collections.reverseOrder());
    
    // descending order
    Collections.sort(list,si,ei,  Collections.reverseOrder());
    ```
    
    - **Time Complexity:** O(n log n) (MergeSort, stable)
    
    ### Advantages of In-Built Sort
    
    1. Optimized and faster than manual implementation.
    2. Handles **both primitives and objects**.
    3. Provides **stable sort** for objects (important if equal elements must maintain order).
    4. Less code → less chance of bugs.
    
    **Counting Sort**
    
    Counting Sort is **not a comparison-based sort**. Instead of comparing elements, it **counts how many times each element occurs** and then calculates their positions in the sorted array.
    
    It works best when:
    
    - Elements are **integers**
    - The **range of elements is small** compared to the array size
    
    ---
    
    ### 🔹 How It Works (Step by Step)
    
    Example: `[4, 2, 2, 8, 3, 3, 1]`
    
    1. **Find the maximum value** → 8
    2. **Create a count array** of size max+1 → `[0,0,0,0,0,0,0,0,0]`
    3. **Count each element**
        
        ```
        1 → count[1] = 1
        2 → count[2] = 2
        3 → count[3] = 2
        4 → count[4] = 1
        8 → count[8] = 1
        ```
        
        Count array → `[0,1,2,2,1,0,0,0,1]`
        
    4. **Calculate cumulative sum** (positions)
        
        ```
        count[0] = 0
        count[1] = 1
        count[2] = 3
        count[3] = 5
        count[4] = 6
        count[5] = 6
        count[6] = 6
        count[7] = 6
        count[8] = 7
        ```
        
        This tells **where each element should go** in the sorted array.
        
    5. **Place elements in output array** using count array → `[1,2,2,3,3,4,8]` ✅
    
    ---
    
    ### 🔹 Time Complexity
    
    - **Time:** O(n + k) → n = array size, k = range of elements
    - **Space:** O(k)
    - Stable: ✅ **Yes**