# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```
mvn test                                    # run all tests (also the required "update rule" per README after any change)
mvn test -Dtest=PersonTest                  # run a single test class
mvn test -Dtest=PersonTest#personModelNameTest   # run a single test method (nested class methods: -Dtest=PersonTest$PersonModelTest#personModelNameTest)
mvn compile                                 # compile only
```

Requires JDK 25+ (`maven.compiler.source`/`target` are set to 25).

## Architecture

This is a small teaching/sample project (package `com.hidenari`) that implements the **same "Person" domain model three different ways** to compare Java modeling styles, all sharing validation behavior through sealed interfaces:

- `Person` — public mutable fields (`name`, `age`, `grade`), implements `NameInterface, AgeInterface`.
- `PersonCapsule` — classic JavaBean encapsulation (private fields + getters/setters), implements `NameCapsuleInterface, AgeCapsuleInterface`.
- `PersonRecord` — immutable `record` with a compact-style canonical constructor, implements `NameInterface, AgeInterface`.

Each sealed interface's `permits` clause lists exactly which classes may implement it (e.g. `NameInterface permits Person, PersonRecord`). Adding a new implementing class requires updating the corresponding `permits` clause.

### Validation is duplicated per access style, not shared

There are two parallel interface hierarchies because reflection-based name validation reads different member types:

- `NameInterface` (used by `Person`, `PersonRecord`) validates name length via reflection on the **field** — `Person.class.getField("name")` — reading the `@ValidateNameLength` annotation off that field.
- `NameCapsuleInterface` (used by `PersonCapsule`) validates via reflection on the **method** — `PersonCapsule.class.getMethod("getName")` — reading the annotation off the getter.
- `AgeInterface` and `AgeCapsuleInterface` are functionally identical (`overFifteen`, `INIT_AGE = 15`), just split across the two hierarchies for symmetry with the name interfaces.

When changing validation rules or annotation placement, all four interfaces (or at least the field/method-reflecting pair relevant to the change) need to stay in sync — the reflection targets are hardcoded to specific classes/members, not generic.

### Construction vs. mutation asymmetry

All three constructors normalize the input name to `"Mr." + Capitalized` form and run `validateNameLengthCheck` / `overFifteen` before assignment. After construction:
- `Person`'s public fields can be reassigned directly (`person.name = "jiro"`), bypassing normalization and validation entirely — this is intentional/observed behavior, see `PersonTest`'s `personModelWithParameterNameTest`.
- `PersonCapsule.setName()` re-applies the same normalization as the constructor.
- `PersonRecord` is immutable after construction (no setters).

### GradeEnum

`upGrade`/`downGrade` are instance methods that take a `GradeEnum` parameter and ignore `this`, matching against the passed-in value via `switch`. `GOLD.upGrade(...)` and `BRONZE.downGrade(...)` throw `IllegalStateException`.

### Tests

JUnit 5 (Jupiter). `PersonTest` uses `@Nested` classes grouped by scenario (default construction, parameterized construction, error cases) with `@BeforeEach` setup per nested group; `PersonCapsuleTest` and `PersonRecordTest` are flat test classes covering equivalent scenarios for their respective model style.
