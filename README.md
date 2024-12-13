# Kotlin 101

## Basic syntax

The program starts at the `main()` function:
```kotlin
fun main() {
    // The execution starts here, each line will be executed sequentially
    println("Hello, world!")
}
```

The `println` function prints a line of text to the screen.
Using `print` instead doesn't go to the next line, so we can keep printing things on the same line:
```kotlin
print("Hello")
println("World!")
// prints "Hello, World!" to the screen on the same line, and then goes to the next line
```

Any text after `//` is considered a comment and ignored by the compiler (until the end of the line).
```kotlin
// this way we can explain things!

/*
For long text on multiple lines,
we can do this instead.
 */
```

Declare a variable with the `var` keyword, and assign values with `=`:
```kotlin
var x = 42  // we declare the variable with the `var` keyword
x = 15      // we can then assign new values to it later
x = 12 + 5  // values can be expressions
x = x + 1   // we can even reuse the current value of the variable itself
x += 5      // equivalent to x = x + 5
x++         // equivalent to x = x + 1
```

Declare a read-only variable (a simple *value*) with the `val` keyword:
```kotlin
val x = 42

x = 13 // ERROR: this is forbidden, variables declared with 'val' are read-only
```

Variables can hold values of other types than integers:

```kotlin
val decimal = 42.0
val character = 'C'      // note the single quotes around it
val string = "some text" // note the double quotes around it
```

The types of these variables were inferred so far, but we can specify them explicitly:

```kotlin
val integer: Int = 42
val decimal: Double = 42.0 // "Double" stands for "Double-precision floating point"
val character: Char = 'C'
val string: String = "some text"
```

This is how to declare a function named `add()` with the parameters `a` and `b` which are both integers (type `Int`).
It also *returns* an integer value, hence the `: Int` at the end of the first line.
The braces delimit the body of the function
```kotlin
//      parameters     return type
//       /      \         |  
fun add(a: Int, b: Int): Int {
    val result = a + b
    return result // exit point of the function
}

// now we can call the function this way
val r1 = add(42, 12)
// we can also name the arguments for clarity
val r2 = add(a = 42, b = 12)
```

## Types
```kotlin
val integer = 42
val char = 'C'
val string = "some text" // or rather: string of characters. This is just text
```
