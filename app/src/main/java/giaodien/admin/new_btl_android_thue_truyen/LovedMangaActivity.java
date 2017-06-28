package giaodien.admin.new_btl_android_thue_truyen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LovedMangaActivity extends AppCompatActivity implements ClickImage{
    private RecyclerView rv_love1;
    private MangaAdapter mangaAdapter;
    private ArrayList<Manga> mangaArrayList;
    private GridLayoutManager lLayout;
    SQLiteManga db = new SQLiteManga(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        addControls();
        addData("love");
    }

    private void addData(String love) {
        mangaArrayList = new ArrayList<>();
        mangaArrayList = db.getListManga(love);
        lLayout = new GridLayoutManager(LovedMangaActivity.this, 3);
        mangaAdapter = new MangaAdapter(this , getLayoutInflater() ,mangaArrayList);
        rv_love1.setAdapter(mangaAdapter);
        rv_love1.setHasFixedSize(true);
        rv_love1.setLayoutManager(lLayout);
    }

    public void addControls(){
        rv_love1=(RecyclerView) findViewById(R.id.rv_love1);
    }

    @Override
    public void onClick(String tentruyen) {
        Intent intent = new Intent(this, MangaDetailActivity.class);
        intent.putExtra("NAME",tentruyen);
        startActivity(intent);
    }
}
