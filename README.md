# Bug

## Gradle

Try to run with:

```
./gradlew test -i
```

Output:

```
micronaut.introspection.issue.BadControllerTest > canPost FAILED
    io.micronaut.http.client.exceptions.HttpClientResponseException: Failed to convert argument [body] for value [null] due to: Cannot construct instance of `micronaut.introspection.issue.Payload`, problem: Null argument specified for [arg0]. If this argument is allowed to be null annotate it with @Nullable
     at [Source: UNKNOWN; line: -1, column: -1]
```

```
micronaut.introspection.issue.PayloadTest > parameterNameViaBeanIntrospection FAILED
    org.junit.ComparisonFailure: expected:<[id]> but was:<[arg0]>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at micronaut.introspection.issue.PayloadTest.parameterNameViaBeanIntrospection(PayloadTest.java:22)
```

`Micronaut` does not see the correct parameter names being produced by `lombok`.

It seems to be using generated values like `arg0`, `arg1`, etc.

## Maven

Try to run with:

```
./mvnw test
```

It will fail with similar exceptions to `gradle`.

## Eclipse

It works.
