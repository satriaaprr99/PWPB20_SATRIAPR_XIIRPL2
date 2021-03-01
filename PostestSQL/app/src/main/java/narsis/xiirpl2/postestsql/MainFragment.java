package narsis.xiirpl2.postestsql;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainFragment extends Fragment implements View.OnClickListener,RecyclerviewAdapter.OnUserClickListener{

    RecyclerView recyclerView;
    EditText edtjudul,edtdesc;
    Button btnSubmit;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    List<ModelNotes> modelNotesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getActivity();
        recyclerView  = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        edtjudul  = view.findViewById(R.id.judul);
        edtdesc   = view.findViewById(R.id.deskripsi);
        btnSubmit = view.findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        DatabaseHelper db=new DatabaseHelper(context);
        modelNotesList=db.selectUserData();

        RecyclerviewAdapter adapter=new RecyclerviewAdapter(context,modelNotesList,this);
        recyclerView.setAdapter(adapter); adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.submit){
            DatabaseHelper db = new DatabaseHelper(context);
            ModelNotes currentPerson = new ModelNotes();
            String btnStatus=btnSubmit.getText().toString();
            if(btnStatus.equals("Submit")) {
                currentPerson.setJudul(edtjudul.getText().toString());
                currentPerson.setDeskripsi(edtdesc.getText().toString());
                db.insert(currentPerson);
            }
            if(btnStatus.equals("Update")){
                currentPerson.setJudul(edtjudul.getText().toString());
                currentPerson.setDeskripsi(edtdesc.getText().toString());
                db.update(currentPerson);
            }
            setupRecyclerView();
            edtjudul.setText("");
            edtdesc.setText("");
            edtjudul.setFocusable(true);
            btnSubmit.setText("Submit");

        }
    }

    @Override
    public void onUserClick(ModelNotes currentPerson, String action) {
        if(action.equals("Edit")){
            edtjudul.setText(currentPerson.getJudul());
            edtjudul.setFocusable(false);
            edtdesc.setText(currentPerson.getDeskripsi()+"");
            btnSubmit.setText("Update");
        }
        if(action.equals("Delete")){
            DatabaseHelper db=new DatabaseHelper(context);
            db.delete(currentPerson.getJudul());
            setupRecyclerView();
        }
    }
}
