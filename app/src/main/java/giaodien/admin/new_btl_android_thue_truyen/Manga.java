package giaodien.admin.new_btl_android_thue_truyen;

/**
 * Created by Admin on 18/04/2017.
 */

public class Manga {
    private String id;
    private String ten="";
    private String tacGia="";
    private String theLoai="";
    private int image;
    private int soChuong=0;
    private String trangThai="";
    private String noiDung="";
    private int xepHang=0;
    private String status;
    private String love = "false";
    private String chuong = "";
    private String ndchuong;

    public Manga(String id, String ten, String tacGia, String theLoai, int image, int soChuong, String trangThai, String noiDung, int xepHang, String status, String love, String chuong, String ndchuong) {
        this.id = id;
        this.ten = ten;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.image = image;
        this.soChuong = soChuong;
        this.trangThai = trangThai;
        this.noiDung = noiDung;
        this.xepHang = xepHang;
        this.status = status;
        this.love = love;
        this.chuong = chuong;
        this.ndchuong = ndchuong;
    }

    public String getNdchuong() {
        return ndchuong;
    }

    public void setNdchuong(String ndchuong) {
        this.ndchuong = ndchuong;
    }

    public Manga() {
    }

    public String getChuong() {
        return chuong;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }

    public Manga(String id, String ten, String tacGia, String theLoai, int image, int soChuong, String trangThai, String noiDung, int xepHang, String status, String love, String chuong) {
        this.ten = ten;
        this.image = image;
        this.id=id;
        this.love = love;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.image = image;
        this.soChuong = soChuong;
        this.trangThai = trangThai;
        this.noiDung = noiDung;
        this.xepHang = xepHang;
        this.status = status;
        this.chuong= chuong;

    }

    public Manga(String id, String ten, String tacGia, int image) {
        this.id=id;
        this.ten = ten;
        this.tacGia = tacGia;
        this.image = image;
    }

    public Manga(String ten, String tacGia, int image) {

        this.ten = ten;
        this.tacGia = tacGia;
        this.image = image;
    }

    public Manga(String ten, String tacGia) {
        this.ten = ten;
        this.tacGia = tacGia;
    }

    public Manga(String tacGia, int soChuong, String trangThai, int xepHang, String theLoai, String noiDung, int image, String chuong, String ndchuong, String ten) {
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.soChuong = soChuong;
        this.trangThai = trangThai;
        this.noiDung = noiDung;
        this.xepHang = xepHang;
        this.image = image;
        this.chuong = chuong;
        this.ndchuong = ndchuong;
        this.ten = ten;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSoChuong() {
        return soChuong;
    }

    public void setSoChuong(int soChuong) {
        this.soChuong = soChuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getXepHang() {
        return xepHang;
    }

    public void setXepHang(int xepHang) {
        this.xepHang = xepHang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String isLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }
}
