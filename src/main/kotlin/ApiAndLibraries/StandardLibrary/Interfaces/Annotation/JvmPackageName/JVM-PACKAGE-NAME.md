# `@JvmPackageName`
`@JvmPackageName` is a JVM only annotation that lets you specify a different package name for the compiled JVM bytecode than the one declared in your Kotlin source code. 
## What it does
- Kotlin's Viewpoint: Your source file still declares `package com.examle.utils`, and from Kotlin's perspective, that's where your code lives
- JVM's viewpoint: the compiled `.class` files are placed into the package specified in the annotation (e.g., `com.example.internal`)  
It essentially decouples the logical package (what Kotlin sees) from the physical package in the compiled JAR (what Java/other JVM tools sees)
## Key Facts
- File-Level Only: It must be applied to a file using the `@file:` prefix, and it must be placed before the `package` declaration
- Primary Use Case: it's mainly use to solve the "split package" problem on the Java 9+ module path, where you want declarations from the same Kotlin package to end up in different JVM packages
  - Metadata: the Kotlin compiler stores the mapping in the module's metadata (`.kotlin_module` file) so it can resolve the correct JVM package if needed