package org.openapitools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OpenApiGeneratorApplicationTests {

    @Test
    void contextLoads() throws IOException, InterruptedException {
        var req = HttpRequest.newBuilder(URI.create("http://localhost:8066/v2/issue"))
            .POST(HttpRequest.BodyPublishers.ofString("listOfStrings=hello"))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build();

        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        Assertions.assertThat(response.statusCode()).isEqualTo(200);

    }

}
