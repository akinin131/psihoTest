package quiz.example.psychologytests.activityTest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.stateadapter.StateHaracter;
import quiz.example.psychologytests.tests.Kindness;
import quiz.example.psychologytests.tests.Temperament;
import quiz.example.psychologytests.tests.honesty_tests;

public class StateAdapterHaracter extends RecyclerView.Adapter<StateAdapterHaracter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<StateHaracter> states;
    public Context context13;

    public StateAdapterHaracter(Context context, ArrayList<StateHaracter> states, Context context12) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        context13 = context12;
    }

    @Override
    public StateAdapterHaracter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapterHaracter.ViewHolder holder, int position) {
        StateHaracter state = states.get(position);
        holder.nameView.setText(state.getName());
        holder.nameView1.setText(state.getName1());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        final TextView nameView;
        final TextView nameView1;

        public ViewHolder(View view) {

            super(view);

            nameView = view.findViewById(R.id.name);
            nameView1 = view.findViewById(R.id.name1);


            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int positionIndex = getAdapterPosition();

                    if (positionIndex == 0) {
                        Intent intent = new Intent(context13, honesty_tests.class);
                        context13.startActivity(intent);
                    } else if (positionIndex == 1) {
                        Intent intent = new Intent(context13, Kindness.class);
                        context13.startActivity(intent);
                    } else if (positionIndex == 2) {
                        Intent intent = new Intent(context13, Temperament.class);
                        context13.startActivity(intent);
                    }
                }
            });
        }
    }
}