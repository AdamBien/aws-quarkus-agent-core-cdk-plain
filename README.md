# A minimalistic AWS Bedrock Agent Runtime implemented with Quarkus and deployed via AWS CDK.



## Modules

- **[agent](agent)**: Quarkus application implementing AWS Bedrock Agent Runtime HTTP protocol
- **[agent-st](agent-st)**: System tests for the agent
- **[cdk](cdk)**: AWS CDK infrastructure deploying the agent as AgentCore Runtime

## Prerequisites

- Java 25
- Maven
- AWS credentials configured (via `aws configure` or environment variables)
- CDK bootstrapped in target account and region: `cdk bootstrap`

## Build and Deploy

```bash
./buildAndDeployDontAsk.sh
```

## Agent Runtime Protocol

The agent implements [AWS Bedrock Agent Runtime HTTP contract](https://docs.aws.amazon.com/bedrock-agentcore/latest/devguide/runtime-http-protocol-contract.html):
- `POST /invocations` - agent invocation endpoint
- `GET /ping` - health check endpoint

## Stack Outputs

- **AgentRuntimeId**: Identifier of the deployed agent runtime
- **AgentArn**: ARN of the deployed agent runtime

- [BCE Architecture Design Pattern](https://bce.design/) - This project organizes code using the Boundary-Control-Entity pattern
- This project is a member of [Constructions Cloud](https://constructions.cloud/).
See you at: [airhacks.live](https://airhacks.live)
