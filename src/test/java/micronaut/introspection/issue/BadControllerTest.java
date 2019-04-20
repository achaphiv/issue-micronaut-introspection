package micronaut.introspection.issue;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;

public class BadControllerTest {
  private static EmbeddedServer server;
  private static HttpClient client;

  @BeforeClass
  public static void setupServer() {
    server = ApplicationContext.run(EmbeddedServer.class);
    client = server.getApplicationContext()
      .createBean(HttpClient.class, server.getURL());
  }

  @AfterClass
  public static void stopServer() {
    client.stop();
    server.stop();
  }

  @Test
  public void canPost() {
    String id = "123";
    String result = client.toBlocking().retrieve(
      HttpRequest.POST("/bad", "{ \"id\": \"" + id + "\" }"),
      String.class
    );
    assertEquals(result, id);
  }
}
