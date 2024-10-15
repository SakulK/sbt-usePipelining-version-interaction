This is a demo of an interaction between sbt option `usePipelining` and `version` messing with incremental compilation.

Steps to reproduce:
1. run `sbt compile`
2. change the `version` key in `build.sbt`
3. run `sbt compile` again

In the debug output you can see something like this:

```
[debug] Found differing options:
[debug] a: scala=-Ypickle-java,-Ypickle-write,<redacted>/sbt-usePipelining-version-interaction/target/scala-3.5.1/early/sbt-usepipelining-version-interaction_3-0.1.0-SNAPSHOT.jar java=
[debug] b: scala=-Ypickle-java,-Ypickle-write,<redacted>/sbt-usePipelining-version-interaction/target/scala-3.5.1/early/sbt-usepipelining-version-interaction_3-0.2.0-SNAPSHOT.jar java=
```

The `earlyOutput` path used by `-Ypickle-write` includes the `version` and ends up causing a full recompilation. This is especially unfortunate when using `GitVersioning` plugin.
