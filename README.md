Programming Language Generator
============

This generate simple Programming Language like brainf*ck

```
import com.krrrr38.programming.language.generator._

val runtime = new PLGRuntime

val hoge = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.+++++++.--------.--."

val bfparser = Factory.create(List("+"), List("-"), List(">"), List("<"), List("."), List(","))

runtime.exec(bfparser.parse(hoge).get) // -> hoge
```

Usage
==============
Add Dependency into your sbt setting
```
lazy val yourProject = Project(
  ...
).dependsOn(plg)

lazy val plg = uri("git://github.com/krrrr38/ProgrammingLanguageGenerator.git")
```
