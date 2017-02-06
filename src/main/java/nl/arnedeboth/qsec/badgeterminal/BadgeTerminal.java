package nl.arnedeboth.qsec.badgeterminal;

import nl.arnedeboth.qsec.badgeterminal.configuration.Configuration;
import nl.arnedeboth.qsec.badgeterminal.identification.IdentificationHandler;
import nl.arnedeboth.qsec.badgeterminal.listeners.http.HttpBadgeListener;
import nl.arnedeboth.qsec.badgeterminal.provider.IUserProvider;
import nl.arnedeboth.qsec.badgeterminal.provider.UserServiceUserProvider;
import nl.arnedeboth.qsec.badgeterminal.reader.BadgeReader;

public class BadgeTerminal {

  public BadgeTerminal(String[] args)
  {
    Configuration configuration = Configuration.fromArgs(args);

    // Create the UserServiceUserProvider from the url in the configuration.
    IUserProvider userProvider = new UserServiceUserProvider(configuration.getUserServiceUrl());
    IdentificationHandler identificationHandle = new IdentificationHandler(userProvider);

    identificationHandle.addBadgeListener(new HttpBadgeListener());

    new BadgeReader(identificationHandle).run();
  }


}
