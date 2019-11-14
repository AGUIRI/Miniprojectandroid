package miniprojetraguiri.com.repository;

import miniprojetraguiri.com.model.SearchResult;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Repository {
    public void getPhotos(Callback<SearchResult> callback) {
    String url = "https://www.flickr.com";
    Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(MoshiConverterFactory.create()).build();
    FlickrAPI service = retrofit.create(FlickrAPI.class);
    service.getInterstingPhotos("flickr.interestingness.getList", "34b3c6c1b435ac9b6b4206e3ca8bc32d", "20")
            .enqueue(callback);
    }
}
