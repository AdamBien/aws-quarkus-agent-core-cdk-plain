# Agent System Tests

Black box tests for the deployed agent runtime.

## Configuration

```bash
export AGENT_ARN=[AgentArn from CDK deployment output]
```

## Run

```bash
mvn clean test-compile failsafe:integration-test
```