package Homework6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class App {
    private static final String API_KEY = "YqmDwNyGMGtAvTh1QKN0Jf1RAht13iBq";

    private static final String FORECAST_TYPE = "daily";

    private static final String FORECAST_PERIOD = "5day";

    private static final String LOCATION_KEY = "294021";

    public static void main(String[] args) throws Exception {
        var client = new OkHttpClient();

        var uri = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(LOCATION_KEY)
                .addQueryParameter("apikey", API_KEY)
                .build();
        System.out.println(uri);

        var request = new Request.Builder()
                .url(uri)
                .build();

        try (var response = client.newCall(request).execute()) {
            var body = response.body();
            if (body != null) {
                var json = body.string();
                System.out.println(json);
            }
        }
    }
}
