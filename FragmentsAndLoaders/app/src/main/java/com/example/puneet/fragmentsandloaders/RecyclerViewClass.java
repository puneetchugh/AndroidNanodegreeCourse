package com.example.puneet.fragmentsandloaders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Recycler View:
 *
 * When we have long lists to display and we use ListViews every item has to be inflated before forming the ListView
 * which not only wastes a lot of memory but also slows down the application. So, this necessitated the need
 * for Recyler Views. At a time we can only display part of list when the list is very huge.
 * For example, at one point of time we can only have 4 items on the screen out of 20 items in the list.
 * So, when we scroll, the item going out of view gives way to new item coming. So, this way we would
 * only inflate 4 views instead of views for all 20 items.
 *
 *
 * RecyclerView class requires creating a static class, ViewHolder that would contain all the views for a single
 * item. The ViewHolder class would extend RecyclerView.ViewHolder and the main RecyclerView class would extend
 * RecyclerView.Adapter<RecyclerView class.ViewHolder Class>
 *
 * Then, we need to implement the mandatory functions "onCreateViewHolder", "onBindViewHolder", "getItemCount"
 *
 * onCreateViewHolder - we need to inflate the view for the item and also reference the TextView, ButtonView
 *                      with the corresponding xml TextView, ButtonView, respectively.
 *
 * onBindViewHolder - this method requires defining the text for different views defined in the ViewHolder class
 *
 * getItemCount - we return the count of items in this method
 */

/**
 * Created by puneet on 2/15/16.
 */
public class RecyclerViewClass extends RecyclerView.Adapter<RecyclerViewClass.PersonViewHolder>{

    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView nameView;
        TextView emailView;
        TextView phoneView;

        PersonViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            nameView = (TextView) itemView.findViewById(R.id.person_name);
            emailView = (TextView) itemView.findViewById(R.id.person_email);
            phoneView = (TextView) itemView.findViewById(R.id.person_phone);
        }

    }

    List<Person> personList;

    RecyclerViewClass(List<Person> personList){
        this.personList = personList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout, viewGroup, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int position) {

        personViewHolder.nameView.setText(personList.get(position).getName());
        personViewHolder.emailView.setText(personList.get(position).getEmail());
        personViewHolder.phoneView.setText(personList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }



}
