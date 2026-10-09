# Compiler and Programming Languages - SimpleLang Compiler

## Project Summary

This repository contains the four phases of a compiler-design course project for the MOL language, called SimpleLang in the implementation.

The project progresses from lexical and syntax analysis to Abstract Syntax Tree (AST) construction, semantic analysis, and JVM code generation. Each phase has its own Java sources, ANTLR grammar, samples, and assignment description.

---

## Project Structure

```text
Compiler-and-Programming-Languages/
├── Phase_1/
│   ├── src/
│   ├── samples/
│   ├── document-mol.pdf
│   └── PLC-Phase-1.pdf
├── Phase_2/
│   ├── src/
│   ├── samples/
│   ├── README.md
│   └── PLC_Phase2.pdf
├── phase_3/
│   ├── PLC/
│   │   ├── src/
│   │   └── samples/
│   ├── README.md
│   └── PLC-CA3-Spring05.pdf
├── Phase_4/
│   ├── src/
│   ├── Sample/
│   ├── run-all-tests.ps1
│   ├── README.md
│   └── PLC-Spring05-Phase4.pdf
└── README.md
```

---

## Implemented Phases

### Phase 1 - Lexical and Syntax Analysis

Defines the language grammar and uses ANTLR to recognize source programs. This phase includes the lexer, parser, sample inputs, and the original language specification.

- [Source code](Phase_1/src)
- [Language specification](Phase_1/document-mol.pdf)
- [Project explanation](Phase_1/PLC-Phase-1.pdf)

### Phase 2 - AST Construction & Visitor

Builds an AST through grammar semantic actions and traverses it with the Visitor pattern. The output summarizes modules, structs, fields, method signatures, and direct statement counts.

- [Phase 2 README](Phase_2/README.md)
- [Project explanation](Phase_2/PLC_Phase2.pdf)

### Phase 3 - Name & Type Analysis

Uses symbol tables and AST visitors to check declarations, scope, access permissions, initialization, assignment types, conditions, return values, mutability, and method arguments. It also reports unreachable modules and structs.

- [Phase 3 README](phase_3/README.md)
- [Project explanation](phase_3/PLC-CA3-Spring05.pdf)

### Phase 4 - Code Generation

Generates Jasmin assembly for modules and structs, including expressions, control flow, input/output, constructors, and method calls. Jasmin assembles the generated files into JVM classes, with `Main.main(String[])` as the entry point.

- [Phase 4 README](Phase_4/README.md)
- [Project explanation](Phase_4/PLC-Spring05-Phase4.pdf)

---

## Compiler Stages

```text
MOL source (.mol)
    -> Lexer and Parser
    -> Abstract Syntax Tree
    -> Name and Type Analysis
    -> Jasmin assembly (.j)
    -> JVM classes (.class)
    -> Program execution
```

This diagram shows the stages covered across the project. The phase folders are separate implementations and should be built independently. Phase 3 runs the semantic analyzers; the Phase 4 entry point runs code generation directly.

---

## Requirements

- JDK 11 or newer, with `java` and `javac` available in `PATH`
- ANTLR `antlr-4.13.1-complete.jar`
- `jasmin.jar` for Phase 4
- Windows PowerShell for the commands and test script

JAR files are excluded by `.gitignore`, so a fresh clone requires these dependencies to be supplied separately. Place them as follows for the documented commands:

| Phase | Dependency location |
| --- | --- |
| Phase 2 | `Phase_2/antlr-4.13.1-complete.jar` |
| Phase 3 | `phase_3/PLC/utilities/antlr-4.13.1-complete.jar` |
| Phase 4 | `Phase_4/utilities/antlr-4.13.1-complete.jar` and `Phase_4/jasmin.jar` |

Verify the Java installation with:

```powershell
java -version
javac -version
```

---

## How to Run

Clone the repository and enter its directory:

```powershell
git clone https://github.com/deniz-mn/Compiler-and-Programming-Languages.git
Set-Location .\Compiler-and-Programming-Languages
```

For AST output, follow the [Phase 2 instructions](Phase_2/README.md) from `Phase_2`. For semantic diagnostics, follow the [Phase 3 instructions](phase_3/README.md) from `phase_3/PLC`.

To build and execute the Phase 4 samples after supplying the required JAR files:

```powershell
Set-Location .\Phase_4
powershell.exe -NoProfile -ExecutionPolicy Bypass -File .\run-all-tests.ps1
```

The script regenerates the parser, compiles Java sources, generates and assembles Jasmin files, and executes the seven sample programs. It recreates the `gen`, `out`, and `codeGenOutput` directories when running.

See the [Phase 4 README](Phase_4/README.md) for manual compilation and execution of a single source file.

---

## Samples and Output

- `Phase_1/samples/`: parsing examples, including `.mol` inputs and reference outputs under `samples/`.
- `Phase_2/samples/`: AST examples and structural output files.
- `phase_3/PLC/samples/`: general examples and dedicated `Name` and `Type` diagnostic cases.
- `Phase_4/Sample/`: programs covering arithmetic, loops, primitive types, input/output, structs, and module inclusion.

Phases 2 and 3 analyze source programs without executing them. Runtime output is produced by the JVM programs generated in Phase 4.
