Gatling performance tests for my [localstack](https://github.com/slawekradzyminski/awesome-localstack)

## Running

```commandline
./mvnw clean gatling:test -Dgatling.simulationClass=com.awesome.testing.BasicSimulation
```

## User cleanup

```commandline
./mvnw clean gatling:test -Dgatling.simulationClass=com.awesome.testing.CleanupSimulation
```

## Good resources

[Gatling complete guide](https://www.james-willett.com/gatling-load-testing-complete-guide/)