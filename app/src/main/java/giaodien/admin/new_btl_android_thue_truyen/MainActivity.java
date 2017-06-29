package giaodien.admin.new_btl_android_thue_truyen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , ClickImage, SearchView.OnQueryTextListener {
    private RecyclerView rv_manga;
    private MangaAdapter mangaAdapter;
    private ArrayList<Manga> mangaArrayList;
    private GridLayoutManager lLayout;
    SQLiteManga db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//////////////////////////////////////////////////////////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        addDatabase();
        addControls();
        addData("full");

    }

    public void addDatabase(){
        db = new SQLiteManga(this);
        db.insert();
    }
    public void addControls(){
        rv_manga=(RecyclerView) findViewById(R.id.rv_manga);
    }
    public void addData(String s){
        mangaArrayList = new ArrayList<Manga>();
        mangaArrayList = db.getListManga(s);
        setMangaAdapter(mangaArrayList);

    }

    public void setMangaAdapter(ArrayList<Manga> list){
        lLayout = new GridLayoutManager(MainActivity.this, 3);
        mangaAdapter = new MangaAdapter(this , getLayoutInflater() ,list);
        rv_manga.setAdapter(mangaAdapter);
        rv_manga.setHasFixedSize(true);
        rv_manga.setLayoutManager(lLayout);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Configure the search info and add any event listeners
         searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_truyentoanbo:
                addData("full");
                break;
            case R.id.editHoten:
                addData("hot");
                break;
            case R.id.nav_truyenmoi:
                addData("new");
                break;
            case R.id.nav_yeuthich:
                Intent intent = new Intent(MainActivity.this, LovedMangaActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.nav_dangnhap:
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(intent1);
                break;
            case R.id.nav_caidat:
                Intent intent2 = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(intent2);
                break;
        }

/////////////////////////////////////////////////////////////
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onClick(String tentruyen) {
        Intent intent = new Intent(this, MangaDetailActivity.class);
        intent.putExtra("NAME",tentruyen);
        startActivityForResult(intent,1);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mangaArrayList = db.getListManga(newText);
        setMangaAdapter(mangaArrayList);
        mangaAdapter.notifyDataSetChanged();
        return false;
    }
}

