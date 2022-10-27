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
import quiz.example.psychologytests.activityTest.stateadapter.StateIntelect;
import quiz.example.psychologytests.tests.Observation_tests;

public class StateAdapterIntelect extends RecyclerView.Adapter<StateAdapterIntelect.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<StateIntelect> states;
    public Context context13;

    public StateAdapterIntelect(Context context, ArrayList<StateIntelect> states, Context context12) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        context13 = context12;
    }

    @Override
    public StateAdapterIntelect.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapterIntelect.ViewHolder holder, int position) {
        StateIntelect state = states.get(position);
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
                        Intent intent = new Intent(context13, Observation_tests.class);
                        context13.startActivity(intent);
                    }
                }
            });

        }
    }
}