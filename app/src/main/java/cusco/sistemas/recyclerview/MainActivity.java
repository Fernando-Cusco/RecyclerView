package cusco.sistemas.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = this.getAllNames();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerId);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mAdapter = new MyAdapter(names, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int pos) {
                Toast.makeText(getApplicationContext(), "Nombre: "+name+" Pos: "+pos, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    private List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Fernando");
            add("Ana");
            add("Maria");
            add("Antonio");
            add("Fernando Cusco");
        }};
    }
}
