package giaodien.admin.new_btl_android_thue_truyen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MangaDetailActivity extends AppCompatActivity {
    private TabHost tabHost;
    private TextView txtTacgia, txtSoChuong, txtTrangThai, txtXepHang, txtTheLoai,txtNoiDung,txtChuong;
    private ImageView imgManga1;
    SQLiteManga sqLiteManga = new SQLiteManga(this);
    private ListView lstResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        addControls();
        addTabs();
        loadView();
        addListView();
    }

    private void addListView() {
        ArrayList<String> nd= new ArrayList<>();
        final Intent intent = getIntent();
        String name = intent.getExtras().getString("NAME");
        final Manga manga = sqLiteManga.findMangabyName(name);
        String chuong = manga.getChuong();
        try {
            FileInputStream in= openFileInput(chuong+".txt");
            BufferedReader reader=new
                BufferedReader(new InputStreamReader(in));
            String data="";
            while((data=reader.readLine())!=null)
            {
                nd.add(data);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nd);
        lstResult.setAdapter(arrayAdapter);

        lstResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(MangaDetailActivity.this, ChapterDetailActivity.class);
                in.putExtra("NAME",manga.getTen());
                startActivityForResult(in,2);
            }
        });

    }

    private void addControls() {
        txtTacgia = (TextView) findViewById(R.id.tab1_txtTacgia);
        txtSoChuong = (TextView) findViewById(R.id.tab1_txtSochuong);
        txtTrangThai = (TextView) findViewById(R.id.tab1_txtTrangthai);
        txtXepHang = (TextView) findViewById(R.id.tab1_txtXephang);
        txtTheLoai = (TextView) findViewById(R.id.tab1_txtTheloai);
        txtNoiDung = (TextView) findViewById(R.id.tab1_txtNoidung);
        imgManga1 = (ImageView) findViewById(R.id.tab1_imgManga);

        lstResult = (ListView) findViewById(R.id.lstResult);

    }


    public void loadView() {

        final Intent intent = getIntent();
        String name = intent.getExtras().getString("NAME");

        Manga manga = sqLiteManga.findMangabyName(name);

        txtTacgia.setText(manga.getTacGia());
        txtSoChuong.setText(String.valueOf(manga.getSoChuong()));
        txtTrangThai.setText(manga.getTrangThai());
        txtXepHang.setText(String.valueOf(manga.getXepHang()));
        txtTheLoai.setText(manga.getTheLoai());
        imgManga1.setImageResource(manga.getImage());
        readData(manga.getNoiDung());
    }
    public void readData(String nd)
    {
        try {
            FileInputStream in= openFileInput(nd+".txt");
            BufferedReader reader=new
                BufferedReader(new InputStreamReader(in));
            String data="";
            StringBuilder builder=new StringBuilder();
            while((data=reader.readLine())!=null)
            {
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            txtNoiDung.setText(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTabs() {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        //Tab1
        TabHost.TabSpec tab1, tab2;
        tab1 = tabHost.newTabSpec("tag1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("THÔNG TIN");
        tabHost.addTab(tab1);

        //Tab2
        tab2 = tabHost.newTabSpec("tag2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("CHƯƠNG TRUYỆN");
        tabHost.addTab(tab2);
    }

    public void onClickThem(View view){
        final Intent intent = getIntent();
        String name = intent.getExtras().getString("NAME");
        sqLiteManga.suaYeuThich(name);
    }

}