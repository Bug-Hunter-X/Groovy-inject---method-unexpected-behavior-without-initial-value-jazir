# Groovy inject() method unexpected behavior without initial value

This repository demonstrates an unexpected behavior in Groovy's `inject()` method when used without an initial value.  The method works correctly for numeric lists (producing a sum), but the behavior is not clearly defined in the documentation when used without the initial value, especially with non-numeric types.

The `bug.groovy` file shows the unexpected behavior. The `bugSolution.groovy` shows a suggested improvement to make the method behavior more consistent and predictable.