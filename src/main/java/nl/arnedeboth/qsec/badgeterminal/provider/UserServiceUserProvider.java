package nl.arnedeboth.qsec.badgeterminal.provider;

import com.google.gson.Gson;
import nl.arnedeboth.qsec.badgeterminal.identification.User;
import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;
import nl.arnedeboth.qsec.badgeterminal.logger.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by quantu on 04/02/2017.
 */
public class UserServiceUserProvider implements IUserProvider {

    private static final String GET_USER_URL = "/user/badge/";

    private static Gson gson = new Gson();

    private String baseUrl;

    private OkHttpClient client = new OkHttpClient();

    public UserServiceUserProvider(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    public User getUserWithBadgeId(String badgeId) throws UserProviderException
    {
        Request request = new Request.Builder()
                .url(baseUrl + GET_USER_URL + badgeId)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            User user = gson.fromJson(json, User.class);

            return user;

        } catch (IOException ioe)
        {
            //Logger.log("ERROR", "An error while requesting the user from the userservice.");
            throw new UserProviderException("Error while connecting to the UserService");
        }
    }
}
