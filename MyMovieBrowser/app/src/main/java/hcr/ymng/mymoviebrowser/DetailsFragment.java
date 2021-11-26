package hcr.ymng.mymoviebrowser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {


    private static final String MOVIE = "movie";

    private Movie movie;


    public DetailsFragment() {
        // Required empty public constructor
    }


    public static DetailsFragment newInstance(Movie movie) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(MOVIE, movie);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = getArguments().getParcelable(MOVIE);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setMovie(view, movie);
    }


    public void setMovie(View view, Movie movie) {

        TextView textName =(TextView) view.findViewById(R.id.txtMovieName);
        textName.setText(movie.getName());

        TextView textYear = (TextView) view.findViewById(R.id.txtYear);
        textYear.setText(Integer.toString(movie.getYear()));

        TextView textDirector = (TextView) view.findViewById(R.id.txtDirector);
        textDirector.setText(movie.getDirector());

        TextView textDescription = (TextView) view.findViewById(R.id.txtDescription);
        textDescription.setText(movie.getDescription()); textDescription.setEnabled(false);

        ListView listStars = (ListView) view.findViewById(R.id.lstStars);
        listStars.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.array_adapter, movie.getStars().toArray(new String[1]) ));
    }
}