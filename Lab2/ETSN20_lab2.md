# ETSN20 Lab 2: Black-Box Testing

## Preparation

### Assignment 1
Read the documentation for the Triangle program available at the course homepage. Do not read the source code.

### Assignment 2
Specify unit-level test cases for the Triangle program using equivalence partitioning (EP) and boundary-value analysis (BVA). Specify test cases for each class method, but exclude the `main` method.

#### a) Equivalence classes
First define the equivalence classes for the inputs, including both valid and invalid classes.

> **Svar:**
>V1: Equilateral triangles (3,3,3)
>V2: Isosceles triangles (3,3,2)
>V3: Right angled triangles (3,4,5)
>V4: Scalene triangles (4,5,6)
>I1: Non triangles (3,9,3)
>I2: No-area triangles (3,3,6)
>I3: One side zero triangles (0,3,3)
>I4: Negative length triangles (-1,3,3)

#### b) Test cases using equivalence partitioning (EP)
Based on the equivalence classes, specify EP test cases. Make sure the test cases cover both valid and invalid equivalence classes. For each test case, specify the test inputs, execution conditions, and expected output.

> **Svar:**
> V1: (3,3,3)   -> equilateral, (3,3,3), 3.897, 9
> V2: (3,3,2)   -> isosceles, (3,3,2), 2.828, 8
> V3: (3,4,5)   -> right-angled, (3,4,5), 6, 12
> V4: (4,5,6)   -> scalene, (4,5,6), 9.922, 15
> I1: (3,9,3)   -> impossible, (3,9,3), -1.0, -1
> I2: (3,3,6)   -> impossible, (3,3,6), 0, 6
> I3: (0,3,3)   -> impossible, (0,3,3), -1.0, -1
> I4: (-1,3,3)  -> impossible, (-1,3,3), -1.0, -1

#### c) Test cases using boundary-value analysis (BVA)
Based on the equivalence classes, specify BVA test cases. Make sure the test cases cover both valid and invalid equivalence classes. For each test case, specify the test inputs, execution conditions, and expected output.

> **Svar:**
> B1: (0,3,3) -> impossible, (0,3,3), -1.0, -1    Under minimum
> B2: (1,3,3) -> isosceles, (1,3,3), 1.479, 7     Minimum
> B3: (2,3,3) -> isosclees, (2,3,3), 2.828, 8     Above minimum
> 
> B4: (3,3,5) -> isosceles, (3,3,5), 4.146, 11    Below boundary of valid triangle
> B5: (3,3,6) -> impossible, (3,3,6), 0, 12       On the boundary for a valid triangle
> B6: (3,3,7) -> impossible, (3,3,7), -1.0, -1    Above the boundary for a valid triangle
> 
> B7: (3,4,4) -> isoceles, (3,4,4), 5.56, 11      Below the boundary of a right-angle triangle
> B8: (3,4,5) -> right-angle, (3,4,5), 6, 12      On the boundary for a right triangle
> B9: (3,4,6) -> scalene, (3,4,6), 5.33, 13       Above the boundary for a right triangle
