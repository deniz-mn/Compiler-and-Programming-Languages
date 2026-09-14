# Phase 4 - SimpleLang Code Generator

## Project Summary

In this phase, we completed the code-generation part of the SimpleLang compiler. The compiler parses `.mol` source files, builds an Abstract Syntax Tree (AST), and converts the program into Jasmin bytecode. Jasmin then produces executable JVM `.class` files.

## Main Objectives

- Generate separate Jasmin files for modules and structs.
- Generate a valid JVM entry point: `Main.main(String[])`.
- Manage local-variable slots with a limit of 128.
- Support primitive types: `int`, `float`, `double`, `char`, and `bool`.
- Support arithmetic, comparison, logical, and unary expressions.
- Generate labels and jumps for `if`, `while`, and `for` statements.
- Support `break` and `continue`.
- Support input and output operations.
- Support structs, constructors, fields, and methods.
- Support modules and `includes`.
- Convert generated Jasmin files into JVM `.class` files.

## Fixes Applied

The `CodeGenerator` was corrected to:

- Allow a source module named `Main`.
- Generate the static JVM `main` method correctly.
- Resolve calls such as `this.process(...)` from included modules.
- Recognize calls such as `BaseModule()` as constructor calls.
- Remove duplicated conditions, statements, and braces.

## Testing Method

The project uses an automated end-to-end smoke-test script. For every `.mol` file inside the `Sample` directory, it performs the following pipeline:

```text
MOL source -> Parser -> AST -> Jasmin -> JVM class -> Program execution
```

The test suite covers:

- Arithmetic and operator precedence
- Boolean expressions and conditions
- `while` and `for` loops
- `break` and `continue`
- Primitive types
- Input and output
- Structs, constructors, fields, and methods
- Modules and includes

All seven tests passed successfully:

```text
Passed: 7
Failed: 0
```

## Requirements

- JDK 11 or newer
- `java` and `javac` available in `PATH`
- `antlr-4.13.1-complete.jar`
- `jasmin.jar`
- Windows PowerShell
- `run-all-tests.ps1` in the project root
- Test `.mol` files inside the `Sample` directory

Verify the Java installation with:

```powershell
java -version
javac -version
```

## Running All Tests

Open PowerShell and run the following commands:

```powershell
Set-Location "C:\Users\Surface Laptop 6\Downloads\UT\6\Compiler-and-Programming-Languages\Phase_4"

java -version
javac -version

Get-ChildItem .\Sample -Filter *.mol

powershell.exe -NoProfile -ExecutionPolicy Bypass -File ".\run-all-tests.ps1"
```

The expected final result is:

```text
Passed: 7
Failed: 0
```

The test script automatically regenerates the ANTLR lexer and parser, compiles the Java project, processes every `.mol` file, assembles the generated Jasmin files, and executes each resulting program.

## Running a Single Source File Manually

From the project root, locate the required JAR files:

```powershell
$antlrJar = Get-ChildItem . -Recurse -File -Filter "antlr-4.13.1-complete.jar" |
    Select-Object -First 1 -ExpandProperty FullName

$jasminJar = Get-ChildItem . -Recurse -File -Filter "jasmin.jar" |
    Select-Object -First 1 -ExpandProperty FullName
```

Generate and compile the parser and Java sources:

```powershell
Remove-Item -Recurse -Force .\gen, .\out, .\codeGenOutput -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force .\gen, .\out | Out-Null

java -jar "$antlrJar" -Dlanguage=Java -no-listener -Xexact-output-dir `
    -o .\gen .\src\main\grammar\SimpleLang.g4

$javaFiles = Get-ChildItem .\src, .\gen -Recurse -File -Filter *.java |
    ForEach-Object { $_.FullName }

javac -cp "$antlrJar" -d .\out $javaFiles
```

Compile a SimpleLang source file into Jasmin:

```powershell
java -cp ".\out;$antlrJar" SimpleLang .\Sample\sample.mol
```

Assemble and run the generated JVM program:

```powershell
Push-Location .\codeGenOutput

$jasminFiles = Get-ChildItem -File -Filter *.j |
    ForEach-Object { $_.FullName }

java -jar "$jasminJar" $jasminFiles
java -cp . Main

Pop-Location
```

For `Sample/sample.mol`, the expected output is:

```text
20
20
```
