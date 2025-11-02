# Agent

Quarkus application implementing [AWS Bedrock Agent Runtime HTTP protocol](https://docs.aws.amazon.com/bedrock-agentcore/latest/devguide/runtime-http-protocol-contract.html).

## Endpoints

- `POST /invocations` - agent invocation
- `GET /ping` - health check

## Build

```bash
mvn clean package
```

## Run locally

```bash
mvn quarkus:dev
```
