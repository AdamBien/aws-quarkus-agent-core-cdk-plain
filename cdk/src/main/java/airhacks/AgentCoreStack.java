package airhacks;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.bedrock.agentcore.alpha.AgentRuntimeArtifact;
import software.amazon.awscdk.services.bedrock.agentcore.alpha.RuntimeNetworkConfiguration;
import software.amazon.awscdk.services.bedrock.agentcore.alpha.Runtime;
import software.constructs.Construct;

public class AgentCoreStack extends Stack {
            
    public AgentCoreStack(Construct scope, String appName, StackProps stackProps) {
        super(scope, ConventionalDefaults.stackName(appName, "agent-core"), stackProps);
        var agentArtifact = AgentRuntimeArtifact.fromAsset(ConventionalDefaults.dockerFilePath.toString());
        var runtime = Runtime.Builder.create(this, "AgentRuntime")
                .runtimeName("QuarkusAgentRuntime")
                .agentRuntimeArtifact(agentArtifact)
                .networkConfiguration(RuntimeNetworkConfiguration.usingPublicNetwork())
                .build();
        var agentRuntimeId = runtime.getAgentRuntimeId();
        CfnOutput.Builder.create(this, "AgentRuntimeId").value(agentRuntimeId).build();
        var agentArn = runtime.getAgentRuntimeArn();
        CfnOutput.Builder.create(this, "AgentArn").value(agentArn).build();
    }
}
