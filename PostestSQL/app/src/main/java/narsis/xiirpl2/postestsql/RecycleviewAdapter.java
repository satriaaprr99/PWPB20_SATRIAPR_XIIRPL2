package narsis.xiirpl2.postestsql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> {

    Context context;
    OnUserClickListener listener;
    List<ModelNotes> modelNotesList;

    public RecyclerviewAdapter(Context context, List<ModelNotes> modelNotesList,OnUserClickListener listener) {
        this.context=context;
        this.modelNotesList=modelNotesList;
        this.listener=listener;
    }
    public interface OnUserClickListener{
        void onUserClick(ModelNotes currentPerson, String action);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final ModelNotes currentPerson=modelNotesList.get(position);
        holder.ctxtJudul.setText(currentPerson.getJudul());
        holder.ctxtDesc.setText(currentPerson.getDeskripsi()+"");
    }

    @Override
    public int getItemCount() {
        return modelNotesList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView ctxtJudul,ctxtDesc;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ctxtJudul = itemView.findViewById(R.id.ctxtJudul);
            ctxtDesc  = itemView.findViewById(R.id.ctxtDesc);
        }
    }
}