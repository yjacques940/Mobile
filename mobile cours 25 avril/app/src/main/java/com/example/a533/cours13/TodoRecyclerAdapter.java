package com.example.a533.cours13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.MyViewHolder> {
    List<Todo> todoList;

    public TodoRecyclerAdapter(List<Todo> todoList){
        this.todoList = todoList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
//créé un élément de la liste
        TextView title;
        TextView description;
        TextView date;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textview_title);
            description = itemView.findViewById(R.id.texteview_description);
            date = itemView.findViewById(R.id.textview_date);
        }
    }

    @NonNull
    @Override
    public TodoRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecyclerAdapter.MyViewHolder holder, int position) {
//être capable de définir chaque carte, quel va être son contenu, peut passer 10 fois mais avec des éléments didfférents
        Todo todoToDisplay = todoList.get(position);
        holder.title.setText(todoToDisplay.title);
        holder.description.setText(todoToDisplay.description);
        holder.date.setText(todoToDisplay.getDateAdded().toString());

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
