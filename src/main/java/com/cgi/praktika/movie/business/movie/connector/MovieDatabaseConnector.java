package com.cgi.praktika.movie.business.movie.connector;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MovieDatabaseConnector {

    public double getMovieRating(int tmdbId) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.themoviedb.org")
                .addPathSegments("3/movie/" + tmdbId + "?language=en-US")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzYTBiNGQyNTVkN2YxMGIzZjYwODdhNjE0ZDE0NTVkZiIsInN1YiI6IjY1ZjQwZmM2YTY5OGNmMDE2M2Y2NDRjYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.T6-Vu68QMNXc2l1nap8F11ziGoK8GEzqHoAsNXY1_rQ")
                .build();

        try (Response response = client.newCall(request).execute()) {
            JSONObject movieJsonResponse = new JSONObject(Objects.requireNonNull(response.body()).string());
            return parseRatingFromJson(movieJsonResponse);
        } catch (IOException | NullPointerException e) {
            throw new IOException(e);
        }
    }

    private double parseRatingFromJson(JSONObject movieJsonResponse) {
        return movieJsonResponse.getDouble("vote_average");
    }
}
