package quiz.example.psychologytests.activityTest.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.stateadapter.StateMain;
import quiz.example.psychologytests.tests.EntrepreneurTest;
import quiz.example.psychologytests.tests.IntelectMil;
import quiz.example.psychologytests.tests.IntelectRandom;
import quiz.example.psychologytests.tests.Intelect_One;
import quiz.example.psychologytests.tests.Kindness;
import quiz.example.psychologytests.tests.Observation_tests;
import quiz.example.psychologytests.tests.Temperament;
import quiz.example.psychologytests.tests.honesty_tests;

public class StateAdapterMain extends RecyclerView.Adapter<StateAdapterMain.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<StateMain> states;
    public Context context13;

    public StateAdapterMain(Context context, ArrayList<StateMain> states, Context context12) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        context13 = context12;
    }

    @Override
    public StateAdapterMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapterMain.ViewHolder holder, int position) {
        StateMain state = states.get(position);
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

            nameView1 = view.findViewById(R.id.name1);
            nameView = view.findViewById(R.id.name);


            view.setOnClickListener(view1 -> {
                int positionIndex = getAdapterPosition();

                if (positionIndex == 0) {
                    Intent intent = new Intent(context13, honesty_tests.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vrefwfwfwfeve");
                } else if (positionIndex == 1) {
                    Intent intent = new Intent(context13, Observation_tests.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                } else if (positionIndex == 2) {
                    Intent intent = new Intent(context13, Kindness.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                } else if (positionIndex == 3) {
                    Intent intent = new Intent(context13, EntrepreneurTest.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                } else if (positionIndex == 4) {
                    Intent intent = new Intent(context13, Temperament.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                }
                else if (positionIndex == 5) {
                    Intent intent = new Intent(context13, Intelect_One.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                }
                else if (positionIndex == 6) {
                    Intent intent = new Intent(context13, IntelectMil.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                }
                else if (positionIndex == 7) {
                    Intent intent = new Intent(context13, IntelectRandom.class);
                    context13.startActivity(intent);
                    Log.d("evev", "vreve");
                }

            });

        }
    }
}