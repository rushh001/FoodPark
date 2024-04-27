package com.example.foodpark;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Items {

        @PrimaryKey(autoGenerate = true)
        public int pid;

        @ColumnInfo(name = "dishname")
        public String dishname;

        @ColumnInfo(name = "dishprotein")
        public String dishprotein;

        @ColumnInfo(name = "dishcarb")
        public String dishcarb;

        @ColumnInfo(name = "dishfat")
        public String dishfat;

        @ColumnInfo(name = "dishprice")
        public int dishprice;

        @ColumnInfo(name = "dishqty")
        public int dishqty;




        public Items(int pid, String dishname, String dishprotein, String dishcarb, String dishfat, int dishprice, int dishqty) {
                this.pid = pid;
                this.dishname = dishname;
                this.dishprotein = dishprotein;
                this.dishcarb = dishcarb;
                this.dishfat = dishfat;
                this.dishprice = dishprice;
                this.dishqty = dishqty;
        }


        public int getPid() {
                return pid;
        }

        public void setPid(int pid) {
                this.pid = pid;
        }

        public String getDishname() {
                return dishname;
        }

        public void setDishname(String dishname) {
                this.dishname = dishname;
        }

        public String getDishprotein() {
                return dishprotein;
        }

        public void setDishprotein(String dishprotein) {
                this.dishprotein = dishprotein;
        }

        public String getDishcarb() {
                return dishcarb;
        }

        public void setDishcarb(String dishcarb) {
                this.dishcarb = dishcarb;
        }

        public String getDishfat() {
                return dishfat;
        }

        public void setDishfat(String dishfat) {
                this.dishfat = dishfat;
        }

        public int getDishprice() {
                return dishprice;
        }

        public void setDishprice(int dishprice) {
                this.dishprice = dishprice;
        }

        public int getDishqty() {
                return dishqty;
        }

        public void setDishqty(int dishqty) {
                this.dishqty = dishqty;
        }
}
