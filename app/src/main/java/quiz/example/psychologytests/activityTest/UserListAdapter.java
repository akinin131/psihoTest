package quiz.example.psychologytests.activityTest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
import quiz.example.psychologytests.tests.Kindness;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    AppDatabase database;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvFirstName.setText(this.userList.get(position).firstName);
        holder.tvLastName.setText(this.userList.get(position).lastName);
        database = AppDatabase.getDbInstance(context);


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User d = userList.get(holder.getAdapterPosition());
                database.userDao().delete(d);

                int position = holder.getAdapterPosition();
                userList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,userList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;
        View delete;

        public MyViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.first_name);
            tvLastName = view.findViewById(R.id.last_name);
            delete = view.findViewById(R.id.delete);

            tvFirstName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvFirstName.getText().toString().equals("Тест на доброту")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Kindness Test")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Wealth test")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Тест на богатство")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Тест на честность")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Honesty test")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Mindfulness Test")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Тест на внимательность")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Temperament Test")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                    else if (tvFirstName.getText().toString().equals("Тест на темперамент")){
                        Intent intent = new Intent(context, Kindness.class);
                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}
