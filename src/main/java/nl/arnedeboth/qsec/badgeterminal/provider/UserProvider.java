package nl.arnedeboth.qsec.badgeterminal.provider;

import com.google.gson.Gson;
import nl.arnedeboth.qsec.badgeterminal.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by quantu on 04/02/2017.
 */
public class UserProvider {

    private static final String GET_USER_URL = "/user/badge/";

    private static Gson gson = new Gson();

    private String baseUrl;

    private OkHttpClient client = new OkHttpClient();

    public UserProvider(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    public User getUserWithBadgeId(String badgeId)
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
            return null;
            //logger.warning("An error while requesting the user from the userservice.");
        }
    }
}
