package quiz.example.psychologytests.activityTest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;
import quiz.example.psychologytests.activityTest.stateadapter.StateFamily;

public class StateAdapterFamily extends RecyclerView.Adapter<StateAdapterFamily.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<StateFamily> states;
    public Context context13;

    public StateAdapterFamily(Context context, List<StateFamily> states, Context context12) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        context13 = context12;
    }

    @Override
    public StateAdapterFamily.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapterFamily.ViewHolder holder, int position) {
        StateFamily state = states.get(position);
        holder.nameView.setText(state.getName());

    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        final TextView nameView;

        public ViewHolder(View view) {

            super(view);

            nameView = view.findViewById(R.id.name);


            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int positionIndex = getAdapterPosition();

                    switch (positionIndex) {
                        case 0: {
                            Intent intent = new Intent(context13, MainActivity.class);
                            context13.startActivity(intent);
                        }

                        case 1: {
                            Intent intent = new Intent(context13, MainActivity.class);
                            context13.startActivity(intent);
                        }
                    }
                }
            });
        }
    }
}