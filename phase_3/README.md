# Phase 3 - Name & Type Analysis for SimpleLang Compiler

## Project Summary

This project implements the third phase of the SimpleLang compiler project.

The goal of this phase is to traverse the Abstract Syntax Tree (AST), build symbol tables, and report semantic errors in MOL source files. The implementation follows the name-analysis and type-analysis categories described in the [project explanation](PLC-CA3-Spring05.pdf).

This phase analyzes the program without executing it or generating JVM code.

---

## Project Structure

```text
phase_3/
├── PLC/
│   ├── src/
│   │   ├── SimpleLang.java
│   │   └── main/
│   │       ├── ast/
│   │       │   ├── core/
│   │       │   ├── declarations/
│   │       │   ├── expressions/
│   │       │   ├── statements/
│   │       │   └── types/
│   │       ├── grammar/
│   │       │   └── SimpleLang.g4
│   │       ├── symbolTable/
│   │       │   ├── SymbolTable.java
│   │       │   ├── exceptions/
│   │       │   └── items/
│   │       └── visitor/
│   │           ├── IVisitor.java
│   │           ├── Visitor.java
│   │           ├── nameAnalyzer/NameAnalyzer.java
│   │           └── typeAnalyzer/TypeAnalyzer.java
│   ├── samples/
│   │   ├── Name/
│   │   └── Type/
│   └── utilities/
│       └── antlr-4.13.1-complete.jar
├── PLC-CA3-Spring05.pdf
└── README.md
```

The ANTLR JAR must be supplied locally; JAR files are excluded from Git.

---

## Implemented Parts

### Symbol Tables

`SymbolTable` manages nested scopes and stores entries for modules, structs, methods, and variables. Entries track information such as types, access modifiers, initialization, and mutability.

Name analysis runs in three passes:

1. Declare top-level modules and structs.
2. Declare their members.
3. Analyze method bodies and references.

### Name Analysis

`NameAnalyzer` checks for:

- Undeclared variables, fields, modules, and structs
- Calls to undeclared methods
- Invalid access to private members
- Duplicate declarations
- Use of uninitialized variables and fields

It also tracks dependencies between top-level declarations and prints warnings for modules and structs that are unreachable from the entry module.

### Type Analysis

`TypeAnalyzer` checks for:

- Type mismatches in declarations and assignments
- Conditions that are not `bool` in `if`, `while`, and `for` statements
- Return values that do not match the declared method return type
- Attempts to modify immutable variables
- Incorrect argument counts and argument types in method calls

### Analysis Pipeline

```text
MOL source -> Lexer -> Parser -> AST -> NameAnalyzer -> TypeAnalyzer
```

`SimpleLang.java` invokes name analysis first and type analysis second. Diagnostics are printed to the console with source line numbers.

---

## Requirements

- JDK 11 or newer
- `java` and `javac` available in `PATH`
- `antlr-4.13.1-complete.jar` inside `PLC/utilities/`
- Windows PowerShell for the commands below

Verify the Java installation with:

```powershell
java -version
javac -version
```

---

## How to Run

Run the following command from the repository root:

```powershell
Set-Location .\phase_3\PLC
```

All remaining commands in this README run from `phase_3/PLC`.

### 1. Generate ANTLR Files (Optional)

Generated lexer and parser sources already exist in `src/main/grammar`. If the grammar changes, regenerate them in the same directory:

```powershell
java -jar .\utilities\antlr-4.13.1-complete.jar -visitor -Xexact-output-dir `
    -o .\src\main\grammar .\src\main\grammar\SimpleLang.g4
```

### 2. Compile

```powershell
$files = Get-ChildItem .\src -Recurse -File -Filter *.java
javac -cp ".;utilities\antlr-4.13.1-complete.jar" -d .\out $files.FullName
```

Compile the sources under `src` only. The separate `gen` directory contains another set of generated parser classes and is not needed for this command.

### 3. Run

```powershell
java -cp "out;utilities\antlr-4.13.1-complete.jar" SimpleLang .\samples\Type\typeMismatch.mol
```

Expected output:

```text
Line 5 : Type mismatch in assignment. Cannot assign float to int
```

Replace the input path with any `.mol` file from `samples`, `samples/Name`, or `samples/Type`.

---

## Output Format

Name-analysis diagnostics use the following formats:

```text
Line <LineNumber> : <Name> not declared
Line <LineNumber> : <Name> is private
Line <LineNumber> : <Name> already defined
Line <LineNumber> : <Name> is uninitialized
Warning Line <LineNumber> : <Name> is unreachable
```

Type-analysis diagnostics use the following formats:

```text
Line <LineNumber> : Type mismatch in assignment. Cannot assign <SourceType> to <TargetType>
Line <LineNumber> : Condition type must be bool
Line <LineNumber> : Return type mismatch. Expected <ExpectedType>, got <ActualType>
Line <LineNumber> : Cannot modify immutable variable <Name>
Line <LineNumber> : Argument count mismatch for method <MethodName>. Expected <ExpectedCount>, got <ActualCount>
Line <LineNumber> : Argument type mismatch for method <MethodName>, parameter <ParameterIndex>. Expected <ExpectedType>, got <ActualType>
```

---

## Sample Cases

The `samples/Name` directory includes cases for duplicate declarations, undeclared variables and methods, private access, uninitialized values, and unreachable declarations.

The `samples/Type` directory includes cases for assignment types, condition types, return types, immutable assignments, and invalid method arguments. Reference `.out` files are provided alongside the sample inputs.

To display diagnostics for all dedicated name and type samples:

```powershell
Get-ChildItem .\samples\Name, .\samples\Type -File -Filter *.mol |
    Sort-Object FullName |
    ForEach-Object {
        Write-Host "`nSample: $($_.Name)"
        java -cp "out;utilities\antlr-4.13.1-complete.jar" SimpleLang $_.FullName
    }
```

This command displays results for inspection; it does not automatically compare them with the reference outputs.

---

## Notes

- The assignment includes optional removal of unreachable modules and structs. The current implementation prints reachability warnings; it does not rewrite the input file or emit an optimized source file.
- Both analyzers run on the AST, so a sample can produce diagnostics from both passes.
- Semantic diagnostics are printed without setting a failing process exit code. Inspect the output when checking a sample.
- Program execution and Jasmin/JVM code generation are covered in [Phase 4](../Phase_4/README.md).
