package airhacks.agentcore.greetings.boundary;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.bedrockagentcore.BedrockAgentCoreClient;
import software.amazon.awssdk.services.bedrockagentcore.model.InvokeAgentRuntimeRequest;

@QuarkusTest
public class GreetingAgentIT {


    @Inject
    @ConfigProperty(name = "agent.arn")
    String agentArn;
        
    
    @Test
    void invokeAgent() throws IOException {
        var client = BedrockAgentCoreClient.create();        
        var message = """
                    {
                        "message": "hello, duke",
                        "context": {}
                    }""";

        var request = InvokeAgentRuntimeRequest.builder()
                .agentRuntimeArn(this.agentArn)
                .payload(SdkBytes.fromUtf8String(message))
                .contentType("application/json")
                .build();

        var response = client.invokeAgentRuntime(request);
        var content = new String(response.readAllBytes());
        assertThat(content).isNotEmpty();
        System.out.println(content);
        var runtimeSessionId = response.response().runtimeSessionId();
        assertThat(runtimeSessionId).isNotEmpty();
    }
}