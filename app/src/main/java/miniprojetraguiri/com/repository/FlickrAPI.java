package miniprojetraguiri.com.repository;



import miniprojetraguiri.com.model.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPI {

    @GET("/services/rest?format=json&nojsoncallback=1")
    Call<SearchResult> getInterstingPhotos(
            @Query("method") String method,
            @Query("api_key") String key,
            @Query("per_page") String per_page);
}
