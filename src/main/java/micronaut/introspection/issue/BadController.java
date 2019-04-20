package micronaut.introspection.issue;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/bad")
public class BadController {
  @Post
  public String create(@Body Payload body) {
    return body.getId();
  }
}
