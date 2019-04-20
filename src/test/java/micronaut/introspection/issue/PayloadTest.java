package micronaut.introspection.issue;

import java.lang.reflect.Parameter;

import org.junit.Assert;
import org.junit.Test;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.type.Argument;

public class PayloadTest {
  @Test
  public void parameterNameViaReflection() {
    Parameter[] args = Payload.class.getConstructors()[0].getParameters();
    Assert.assertEquals("id", args[0].getName());
  }

  @Test
  public void parameterNameViaBeanIntrospection() {
    Argument<?>[] args = BeanIntrospection.getIntrospection(Payload.class)
      .getConstructorArguments();
    Assert.assertEquals("id", args[0].getName());
  }
}
