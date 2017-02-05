package nl.arnedeboth.qsec.badgeterminal.configuration;

import java.util.Arrays;

/**
 * Created by quantu on 04/02/2017.
 */
// TODO: Use apache commons cli to build a cleaner solution

public class Configuration {
    private String userServiceUrl;

    private Configuration(String userServiceUrl)
    {
        this.userServiceUrl = userServiceUrl;
    }

    public String getUserServiceUrl() {
        return userServiceUrl;
    }

    public static Configuration fromArgs(String[] args)
    {
        // TODO: remove this ulgy piece of code.
        return new Configuration(args[0]);
    }
}
