package airhacks;

import java.util.Map;

import jakarta.json.Json;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * https://docs.aws.amazon.com/bedrock-agentcore/latest/APIReference/API_InvokeAgentRuntime.html
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingAgent {

    /**
     * https://docs.aws.amazon.com/bedrock-agentcore/latest/devguide/runtime-http-protocol-contract.html
     * 
     * @return
     */
    @POST
    @Path("invocations")
    public Response hello() {
        var message = "Hello from Agentic Quarkus";
        var payload = Json.createObjectBuilder()
                .add("response", message)
                .add("status", "success")
                .build();
        return Response.ok(payload).build();
    }
}
