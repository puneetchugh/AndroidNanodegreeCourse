package com.example.puneet.movieout;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by puneet on 3/7/16.
 */
public class OneMovieData implements Parcelable{

    private String originalTitle;
    private String moviePoster;
    private String overview;
    private Double userRating;
    private String releaseDate;
    private int id;


    public OneMovieData(String originalTitle, String moviePoster, String overview, Double userRating, String releaseDate, int id){

        this.originalTitle = originalTitle;
        this.moviePoster = moviePoster;
        this.overview = overview;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        this.id = id;
    }
    public static final Parcelable.Creator<OneMovieData> CREATOR = new Parcelable.Creator<OneMovieData>() {
        public OneMovieData createFromParcel(Parcel p) {
            return new OneMovieData(p);
        }

        public OneMovieData[] newArray(int size) {
            return new OneMovieData[size];
        }
    };

    public OneMovieData(Parcel p) {

        this.originalTitle = p.readString();
        this.moviePoster = p.readString();
        this.overview = p.readString();
        this.userRating = p.readDouble();
        this.releaseDate = p.readString();
        this.id = p.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(originalTitle);
        dest.writeString(moviePoster);
        dest.writeString(overview);
        dest.writeDouble(userRating);
        dest.writeString(releaseDate);
        dest.writeInt(id);
    }

    public String getOriginalTitle(){
        return originalTitle;
    }

    public String getMoviePoster(){
        return moviePoster;
    }

    public String getOverview(){
        return overview;
    }

    public Double getUserRating(){
        return userRating;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public int getId(){
        return id;
    }


}
