package airhacks;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.bedrock.agentcore.alpha.AgentRuntimeArtifact;
import software.amazon.awscdk.services.bedrock.agentcore.alpha.RuntimeNetworkConfiguration;
import software.constructs.Construct;

public class AgentCoreStack
        extends Stack {
            

    public AgentCoreStack(Construct scope, String appName, StackProps stackProps) {
        super(scope, ConventionalDefaults.stackName(appName, "agent-core"), stackProps);
        var agentArtifact = AgentRuntimeArtifact.fromAsset(ConventionalDefaults.dockerFilePath.toString());
        var runtime = software.amazon.awscdk.services.bedrock.agentcore.alpha.Runtime.Builder.create(this, "AgentRuntime")
                .runtimeName("quarkus-agent-core")
                .agentRuntimeArtifact(agentArtifact)
                .networkConfiguration(RuntimeNetworkConfiguration.usingPublicNetwork())
                .build();
    }
}
