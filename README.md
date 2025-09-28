# JAVA DSA

# ARRAY

- Array
    
    **Definition**  
    
    List of Elements of the same type placed in a contiguous memory location.
    
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