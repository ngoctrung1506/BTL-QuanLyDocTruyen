package giaodien.admin.new_btl_android_thue_truyen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 29/04/2017.
 */

public class SQLiteManga  extends SQLiteOpenHelper {

    ManageManga manageManga;

    public SQLiteManga(Context context) {
        super(context, "BTL_UDThueTruyen", null, 1);
    }
    public static void getDatabase(Context context){

    }
    public void insert(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ct = new ContentValues();
        String sql="DELETE FROM tblManga";
        db.execSQL(sql);
        ArrayList<Manga> mangaArrayList = new ArrayList<>();
        mangaArrayList = ManageManga.add();
        Iterator<Manga> iterator = mangaArrayList.iterator();
        while(iterator.hasNext()) {
            Manga manga = iterator.next();
            ct.put("id", manga.getId());
            ct.put("ten", manga.getTen());
            ct.put("tacGia", manga.getTacGia());
            ct.put("theLoai", manga.getTheLoai());
            ct.put("image", manga.getImage());
            ct.put("soChuong", manga.getSoChuong());
            ct.put("trangThai", manga.getTrangThai());
            ct.put("noiDung", manga.getNoiDung());
            ct.put("xepHang", manga.getXepHang());
            ct.put("status", manga.getStatus());
            ct.put("love", manga.isLove());
            ct.put("chuong", manga.getChuong());
            ct.put("nd", manga.getNdchuong());
            db.insert("tblManga", null, ct);
        }

        db.close();
    }


    public ArrayList<Manga> getListManga(String s) {
        ArrayList<Manga> listManga = new ArrayList<>();
        String[] list = {"ten", "tacGia", "image"};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = null;
        if (s.equals("full")){
            cs = db.query("tblManga", list, null, null, null, null, null);
        }
         else if(s.equals("hot")||s.equals("new")) {
            cs = db.rawQuery("Select ten,tacGia,image from tblManga where status = ?", new String[]{String.valueOf(s)});
        }
        else if(s.equals("love")) {
            cs = db.rawQuery("Select ten,tacGia,image from tblManga where love = ?", new String[]{"true"});
        }
        else  cs = db.rawQuery("Select ten,tacGia,image from tblManga where ten LIKE '%" + s +"%'", null);


        try {
            while (cs.moveToNext()) {
                String a = cs.getString(0);
                String b = cs.getString(1);
                int c    = cs.getInt(2);
                listManga.add(new Manga(a,b,c));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        cs.close();
        return listManga;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
           String sql="CREATE TABLE tblManga(id TEXT PRIMARY KEY  NOT NULL  DEFAULT (null),ten text DEFAULT (null), tacGia TEXT DEFAULT (null),theLoai TEXT DEFAULT (null) ,image INTEGER DEFAULT (null),soChuong INTEGER,trangThai TEXT, noiDung TEXT,xepHang INTEGER,status TEXT DEFAULT (null) ,love text, chuong text, nd text)";
           sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + tblManga);
//    onCreate(sqLiteDatabase);
}

    public Manga findMangabyName(String name) {
        Manga m = new Manga();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery("Select tacGia,soChuong,trangThai,xepHang,theLoai,noiDung,image,chuong,nd,ten from tblManga where ten LIKE ? ", new String[]{String.valueOf(name)});
        try {
        while (cs.moveToNext()) {
            String a = cs.getString(0);
            int b =  cs.getInt(1);
            String c    = cs.getString(2);
            int d    = cs.getInt(3);
            String e    = cs.getString(4);
            String f    = cs.getString(5);
            int g = cs.getInt(6);
            String h = cs.getString(7);
            String i = cs.getString(8);
            String k = cs.getString(9);
            m = new Manga(a,b,c,d,e,f,g,h,i,k);
        }
    } catch (SQLException e) {
        e.printStackTrace();

    }
        cs.close();
        return m;
    }

    public void suaYeuThich(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("love","true");
        db.update("tblManga",values,"ten=?", new String[]{name});
    }
}
