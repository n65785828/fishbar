package top.study01.pojo;

import java.util.Date;

//create table filewarehouse(
//        fid varchar(50) primary key,
//        uid int ,
//        fname varchar(50),
//        fdate date,
//        fdesc text
//        fpath text not null
//        );

public class Filewarehouse {

    private String fid ;//uuid
    private Integer uid;
    private String fname;
    private Date fdate;
    private String fdesc;//文件描述
    private String fpath;
    private boolean ispicture;

    public Filewarehouse() {
    }


    @Override
    public String toString() {
        return "Filewarehouse{" +
                "fid='" + fid + '\'' +
                ", uid=" + uid +
                ", fname='" + fname + '\'' +
                ", fdate=" + fdate +
                ", fdesc='" + fdesc + '\'' +
                ", fpath='" + fpath + '\'' +
                ", ispicture=" + ispicture +
                '}';
    }

    public Filewarehouse(String fid, Integer uid, String fname, Date fdate, String fdesc, String fpath, boolean ispicture) {
        this.fid = fid;
        this.uid = uid;
        this.fname = fname;
        this.fdate = fdate;
        this.fdesc = fdesc;
        this.fpath = fpath;
        this.ispicture = ispicture;
    }

    public boolean isIspicture() {
        return ispicture;
    }

    public void setIspicture(boolean ispicture) {
        this.ispicture = ispicture;
    }

    public String getFpath() {
        return fpath;
    }

    public void setFpath(String fpath) {
        this.fpath = fpath;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }
}
