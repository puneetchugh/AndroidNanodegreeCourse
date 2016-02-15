package com.example.puneet.fragmentsandloaders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

;

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
