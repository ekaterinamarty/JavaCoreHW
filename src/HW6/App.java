package HW6;

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

        var url = HttpUrl.parse("http://dataservice.accuweather.com/forecasts/v1").newBuilder()
             .addPathSegment(FORECAST_TYPE)
             .addPathSegment(FORECAST_PERIOD)
             .addPathSegment(LOCATION_KEY)
             .addQueryParameter("apikey", API_KEY)
             .build();
        System.out.println(url.toString());

        var request = new Request.Builder()
            .url(url)
            .build();

        var response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
