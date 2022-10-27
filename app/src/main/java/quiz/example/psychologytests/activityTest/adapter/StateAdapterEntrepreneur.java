package quiz.example.psychologytests.activityTest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.stateadapter.StateEntrepreneur;

public class StateAdapterEntrepreneur extends RecyclerView.Adapter<StateAdapterEntrepreneur.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<StateEntrepreneur> states;
    public Context context13;

    public StateAdapterEntrepreneur(Context context, ArrayList<StateEntrepreneur> states, Context context12) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        context13 = context12;
    }

    @Override
    public StateAdapterEntrepreneur.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapterEntrepreneur.ViewHolder holder, int position) {
        StateEntrepreneur state = states.get(position);

    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {

            super(view);


            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int positionIndex = getAdapterPosition();

                    switch (positionIndex) {
                        case 0: {

                        }
                    }
                }
            });
        }
    }
}