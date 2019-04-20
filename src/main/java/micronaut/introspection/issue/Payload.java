package micronaut.introspection.issue;

import io.micronaut.core.annotation.Introspected;
import lombok.Value;

@Introspected
@Value
public class Payload {
  private final String id;
}
