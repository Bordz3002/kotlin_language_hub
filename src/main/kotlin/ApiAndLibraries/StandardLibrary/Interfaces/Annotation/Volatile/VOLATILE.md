# `@Volatile`
`@Volatile` tells the JVM that a variable can be changed by multiple threads, so it should be always be read from and written to main memory - never cached by thread
### Think of it like: **"always use the latest version of this variable - don't keep an old copy"**
## Why does this matter
In multiple thread programs, each thread has its own copy of the variables for performance.   
This can cause problems:  

| Problems                  | What happens                                       |
| ------------------------- | -------------------------------------------------- |
| Thread A                  | updates a variable                                 |
| Thread B                  | still sees the OLD value (cached)                  |
| Result                    | thread B doesnt know the value is changed          |
`@Volatile` solves this by making all reads and writes go directly to main memory - so all threads see the same, latest value
## What `@Volatile` Does
| it guarantees                   | it does not guarantee                          |
| ------------------------------- | ---------------------------------------------- |
| visibility - all threads see the latest value| atomicity - compound operations aren't safe |
| reads/writes go to main memory | thread safe for multiple operations |

## Where can you use it
| location | example |
| -------- | ------- |
| top-level property | `@Volatile`