package identification;

import nl.arnedeboth.qsec.badgeterminal.identification.*;
import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.DeniedResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.ErrorResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.GrantedResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdentificationHandlerTest {

  private static IdentificationHandler identificationHandler;
  private static IdentificationHandler exceptionIdentificationHandler;
  private static TestUserProvider testUserProvider = new TestUserProvider();
  private static ExceptionUserProvider exceptionUserProvider = new ExceptionUserProvider();

  @BeforeAll
  public static void initAll()
  {
    identificationHandler = new IdentificationHandler(testUserProvider);
    exceptionIdentificationHandler = new IdentificationHandler(exceptionUserProvider);
  }

  @Test
  public void identifyTestUserGranted()
  {
    // Create the expected Granted result with the user with ID 1. This user has the badgeID 12345 which is used in the identify.
    GrantedResult expected = new GrantedResult(testUserProvider.getUserById(1));

    BadgeResult result = identificationHandler.identify("12345");

    assertEquals(expected, result, "Unexpected BadgeResult");
  }

  @Test
  public void identifyTestUserDenied()
  {
    // Create the expected DeniedResult with the user with ID 2. This user has the badgeID 23451 which is used in the identify.
    DeniedResult expected = new DeniedResult(testUserProvider.getUserById(2));

    BadgeResult result = identificationHandler.identify("23451");

    assertEquals(expected, result, "Unexpected BadgeResult");
  }


  @Test
  public void identifyTestUserDoesNotExist()
  {
    // Create the expected DeniedResult with no user.
    DeniedResult expected = new DeniedResult();

    BadgeResult result = identificationHandler.identify("somenonexistingbadgeidstring");

    assertEquals(expected, result, "Unexpected BadgeResult");
  }

  @Test
  public void identifyTestProviderException()
  {
    // Create the expected ErrorResult.
    ErrorResult expected = new ErrorResult("test exception");

    BadgeResult result = exceptionIdentificationHandler.identify("12345");

    assertEquals(expected, result, "Unexpected BadgeResult");
  }
}
