import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.puneet.movieout.R;

import java.util.List;

/**
 * Created by puneet on 2/20/16.
 */
public class RecyclerViewClass extends RecyclerView.Adapter<RecyclerViewClass.MoviePosterHolder> implements View.OnClickListener{

    private List<String> movieNames;

    public RecyclerViewClass(List<String> movieNames){

        this.movieNames = movieNames;
    }

    @Override
    public void onClick(View v) {

    }

    public static class MoviePosterHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView moviePoster;

        MoviePosterHolder(View itemView){

            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            moviePoster = (ImageView) itemView.findViewById(R.id.movie_photo);
        }
    }

    @Override
    public int getItemCount(){
        return movieNames.size();
    }

    @Override
    public RecyclerViewClass.MoviePosterHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        MoviePosterHolder moviePosterHolder = new MoviePosterHolder(v);
        return moviePosterHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewClass.MoviePosterHolder moviePosterHolder, int position) {

        //moviePosterHolder.moviePoster.setImageResource();
    }


}
