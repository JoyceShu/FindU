package com.example.findu;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> implements View.OnClickListener{


    private LayoutInflater layoutInflater;
    private List<Post> posts;
    private OnPostListener onPostListener;
    private Context context;


    PostAdapter(Context context, List<Post> posts, OnPostListener onPostListener) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.posts = posts;
        this.onPostListener = onPostListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.post_view, viewGroup, false);
        return new ViewHolder(view, onPostListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Post post = posts.get(i);
        viewHolder.name.setText(post.getName());
        viewHolder.age.setText(String.valueOf(post.getAge()));
        viewHolder.note.setText(post.getNote());
        viewHolder.setPhoto(post.getImage());
        // TODO viewHolder.photo


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, age, gender, note;
        ImageView photo;
        OnPostListener onPostListener;

        public ViewHolder(@NonNull View itemView, OnPostListener onPostListener) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_name);
            age = itemView.findViewById(R.id.textView_age);
            gender = itemView.findViewById(R.id.textView_gender);
//
            note = itemView.findViewById(R.id.textView_note);
            this.onPostListener = onPostListener;
            itemView.setOnClickListener(this);
        }

        // TODO
        public void setPhoto(String urlPost) {
            photo = itemView.findViewById(R.id.imageView_post);
            Glide.with(context).load(urlPost).into(photo);
        }

        @Override
        public void onClick(View view) {
            onPostListener.onPostClick(getAdapterPosition());
        }
    }
    public interface OnPostListener {
        void onPostClick(int position);
    }
}
