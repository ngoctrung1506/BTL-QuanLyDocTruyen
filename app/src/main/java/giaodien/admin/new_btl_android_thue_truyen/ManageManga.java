package giaodien.admin.new_btl_android_thue_truyen;

import java.util.ArrayList;

;

/**
 * Created by Admin on 13/05/2017.
 */

public class ManageManga {
    public static ArrayList<Manga> add(){
        ArrayList<Manga> mangaArrayList = new ArrayList<Manga>();
        int[] a= {R.drawable.pic_akame, R.drawable.pic_fairy,R.drawable.pic_suicune,R.drawable.pic_boku,R.drawable.pic_btooom,R.drawable.pic_dungeon,R.drawable.pic_nora,R.drawable.pic_onepiece,
                R.drawable.pic_shokugeki,R.drawable.pic_sins,R.drawable.pic_yourname,R.drawable.pic_naruto,R.drawable.pic_narutoo,R.drawable.pic_magi,
                R.drawable.pic_shokugeki,R.drawable.pic_doctorstone,R.drawable.pic_nora,R.drawable.pic_nurarihyon};

        Manga manga =   new Manga("001", "Akamega","Toru Kei, Takahiro","Action, Adventure, Fantasy",0,20,"Đang tiến hành","nd_akame",10,"hot","false","chuong_akame","nd_akame");
        Manga manga1 =  new Manga("002", "Bakuman","Ohba Tsugumi, Obata Takeshi","Comedy, Romance, Shounen",0,30,"Ngưng","nd_bakuman",3,"hot","false","chuong_btoom","nd_btoom");
        Manga manga2 =  new Manga("003", "Beelze","Tamura Ryuuhei","Action, Comedy, Martial Arts",0,21,"Ngưng","nd_bakuman",4,"nd_akame","false","chuong_akame","nd_yourname");
        Manga manga3 =  new Manga("004", "BokuNo","Horikoshi Kouhei","Action, Adventure, Comedy",0,15,"Đang tiến hành","nd_beel",5,"hot","false","chuong_btoom","nd_akame");
        Manga manga4 =  new Manga("005", "Btooom","Inoue Junya","Action, Adventure, Drama",0,32,"Đang tiến hành","nd_akame",7,"new","false","chuong_akame","nd_beel");
        Manga manga5 =  new Manga("006", "Dungeon","Oomori Fujino, Kunieda","Action, Adventure, Comedy",0,12,"Đang tiến hành","nd_akame",8,"hot","false","chuong_btoom","nd_btoom");
        Manga manga6 =  new Manga("007", "Nurari","Shiibashi Hiroshi","Action, Comedy, Drama",0,14,"Ngưng","nd_akame",12,"new","false","chuong_akame","nd_yourname");
        Manga manga7 =  new Manga("008", "OnePiece","Eiichiro Oda","Drama, Fantasy, Shounen",0,54,"Đang tiến hành","nd_akame",2,"new","false","chuong_btoom","nd_akame");
        Manga manga8 =  new Manga("009", "Shokug","Tsukuda Yuuto, Saeki Shun","Martial Arts, Shounen, Supernatural",0,56,"Ngưng","nd_btoom",14,"new","false","chuong_akame","nd_btoom");
        Manga manga9 =  new Manga("010", "SINS","Miura Masataka","Ecchi, Harem, Romance",0,32,"Đang tiến hành","nd_akame",23,"new","false","chuong_akame","nd_yourname");
        Manga manga10 = new Manga("011", "Yourname","Shinkai Makoto, Kotone Ranmaru","Drama, Romance, School Life",0,1,"Đang tiến hành","nd_btoom",1,"new","false","chuong_akame","nd_btoom");
        Manga manga11 = new Manga("012", "Naruto","Mashashi Kishimoto","Action, Adventure",0,700,"Kết thúc","nd_btoom",1,"hot","false","chuong_akame","nd_akame");
        Manga manga12 = new Manga("013", "Boruto","Mashashi Kishimoto","Action, Adventure",0,400,"Đang tiến hành","nd_btoom",1,"new","false","chuong_akame","nd_btoom");
        Manga manga13 = new Manga("014", "Kakashi","Mashashi Kishimoto","Action, Adventure",0,100,"Kết thúc","nd_btoom",4,"hot","false","chuong_akame","nd_yourname");
        Manga manga14 = new Manga("015", "Itachi","Mashashi Kishimoto","Action, Adventure",0,100,"Kết thúc","nd_btoom",4,"hot","false","chuong_akame","nd_yourname");
        Manga manga15 = new Manga("016", "Totoro","Ghibli","Adventure",0,100,"Kết thúc","nd_btoom",4,"hot","false","chuong_akame","nd_beel");
        Manga manga16 = new Manga("017", "Kiki","Motomeru no wa","Action, Adventure",0,10,"Kết thúc","nd_btoom",4,"new","false","chuong_akame","nd_btoom");
        Manga manga17 = new Manga("018", "Uchiha","Tamura Ryuuhei","Action, Adventure",0,40,"Kết thúc","nd_btoom",4,"new","false","chuong_akame","nd_yourname");

        mangaArrayList.add(manga);
        mangaArrayList.add(manga1);
        mangaArrayList.add(manga2);
        mangaArrayList.add(manga3);
        mangaArrayList.add(manga4);
        mangaArrayList.add(manga5);
        mangaArrayList.add(manga6);
        mangaArrayList.add(manga7);
        mangaArrayList.add(manga8);
        mangaArrayList.add(manga9);
        mangaArrayList.add(manga10);
        mangaArrayList.add(manga11);
        mangaArrayList.add(manga12);
        mangaArrayList.add(manga13);
        mangaArrayList.add(manga14);
        mangaArrayList.add(manga15);
        mangaArrayList.add(manga16);
        mangaArrayList.add(manga17);

        for(int i=0;i<a.length;i++){
            Manga man = mangaArrayList.get(i);
            man.setImage(a[i]);
        }
        return mangaArrayList;
    }
}
