package miniprojetraguiri.com.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import miniprojetraguiri.com.model.Photo;
import miniprojetraguiri.com.model.SearchResult;
import miniprojetraguiri.com.repository.Repository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public List<Photo> photos;
    public Repository repPhoto=new Repository();
    public MutableLiveData<Photo> mldPhoto= new MutableLiveData<>();
    public SearchResult sr;
    private int position;

    public MainViewModel(){

        repPhoto.getPhotos(new Callback<SearchResult>(){
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response){
               photos = response.body().getPhotos().getPhoto();
               mldPhoto.postValue(photos.get(0));
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {

            }
        });
    }

    public void nextPhoto(){
        position=photos.indexOf(mldPhoto);
        if (position == photos.size() - 1) {
            mldPhoto.postValue(photos.get(0));
        }
        else{
            mldPhoto.postValue(photos.get(position+1));
        }
    }

}
