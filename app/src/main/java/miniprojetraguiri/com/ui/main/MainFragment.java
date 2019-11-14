package miniprojetraguiri.com.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import miniprojetraguiri.com.R;
import miniprojetraguiri.com.model.Photo;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View layout= inflater.inflate(R.layout.main_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        mViewModel.mldPhoto.observe(this, new Observer<Photo>() {
            @Override
            public void onChanged(@Nullable Photo photo) {
                TextView text= layout.findViewById(R.id.textView);
                ImageView img =layout.findViewById(R.id.photo);
                String url = "https://farm" +photo.getFarm()
                        + ".staticflickr.com/" + photo.getServer()
                        + "/" + photo.getId()
                        +"_"+photo.getSecret()
                        + ".jpg";

                Glide.with(getActivity()).load(url).into(img);
                text.setText(photo.getTitle());
                System.out.println(photo.getTitle());
            }


        });
        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }


   /* public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState ){
         view.findViewById(R.id.button4).setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.versListeFragment);
        });
    }*/
}
