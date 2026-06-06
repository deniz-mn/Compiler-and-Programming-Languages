# Phase 2 - AST Construction & Visitor for SimpleLang Compiler

This project implements the second phase of the SimpleLang compiler project.

The goal of this phase is to parse SimpleLang source files, build an Abstract Syntax Tree (AST), and print a structural summary of the program using the Visitor design pattern.

This phase does **not** execute the program. It only analyzes the structure of the source code.

---

## Project Structure

```text
Phase_2/
├── src/
│   ├── SimpleLang.java
│   ├── SimpleLangLexer.java
│   ├── SimpleLangParser.java
│   ├── SimpleLangVisitor.java
│   ├── SimpleLangBaseVisitor.java
│   │
│   └── main/
│       ├── ast/
│       │   ├── core/
│       │   ├── declarations/
│       │   ├── expressions/
│       │   ├── statements/
│       │   └── types/
│       │
│       ├── grammar/
│       │   └── SimpleLang.g4
│       │
│       └── visitor/
│           ├── IVisitor.java
│           ├── Visitor.java
│           ├── PrintVisitor.java
│           └── TestVisitor.java
│
├── samples/
├── out/
└── antlr-4.13.1-complete.jar
```

---

## Implemented Parts

### AST Construction

The grammar builds AST nodes using semantic actions inside `SimpleLang.g4`.

Implemented AST categories include:

- Program
- Modules
- Structs
- Fields
- Methods
- Parameters
- Statements
- Expressions
- Locations
- Types
- Literals

All AST nodes inherit from the abstract `Node` class and implement the `accept` method for visitor traversal.

---

### Visitor Pattern

The Visitor pattern is implemented through:

- `IVisitor`
- `Visitor`
- `PrintVisitor`
- `TestVisitor`

`PrintVisitor` traverses the AST and prints the required structural output.

---

### Output Summary

The output includes:

- Number of modules
- Number of structs
- Module names
- Struct names
- Fields
- Methods
- Method parameter types
- Method return types
- Number of direct statements inside each method

Only direct statements inside a method body are counted.  
Statements inside nested blocks such as `if`, `while`, and `for` are not added to the parent method statement count.

Struct output only includes fields.

---

## How to Run

### 1. Generate ANTLR Files

```powershell
java -jar antlr-4.13.1-complete.jar -visitor -o src src/main/grammar/SimpleLang.g4
```

---

### 2. Compile

```powershell
$files = Get-ChildItem -Recurse src -Filter *.java | Where-Object { $_.FullName -notlike "*\\.antlr\\*" }
javac -cp ".;antlr-4.13.1-complete.jar" -d out $files.FullName
```

---

### 3. Run

```powershell
java -cp "out;antlr-4.13.1-complete.jar" SimpleLang samples\sample1.mol
```

Replace `sample1.mol` with any input file from the `samples` directory.

---

## Output Format

```text
program [modules:<module_count> structs:<struct_count>]
module <module_name> [methods:<method_count> fields:<field_count>]
	field <field_name> <field_type>:<access_modifier>
	method <method_name> (<arg_types> -> <return_type>):<access_modifier> [statements:<statement_count>]
struct <struct_name> [fields:<field_count>]
	field <field_name> <field_type>:<access_modifier>
```

Each indentation level must be exactly one tab character.

---

## Notes

This phase does not include:

- Program execution
- Runtime output evaluation
- Type checking
- Semantic analysis
- Code generation

Numeric outputs such as values printed by `output` statements require an interpreter or execution visitor, which is outside the scope of this phase.
