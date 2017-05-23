package edu.libsys.entity;

/**
 * 权重类，保存一套权重信息
 */
public class Weight {
    //此套权重名称
    private String name;
    //图书与图书在作者上的联系
    private int bba;
    //图书与图书在中图法分类号上的联系
    private int bbcid;
    //论文与论文在作者上的联系
    private int ppa;
    //论文与论文在领域名称上的联系
    private int ppf;
    //论文与论文在关键词上的联系
    private int ppi;
    //图书与论文在作者上的联系
    private int bpa;
    //图书的中图法分类名与论文的领域名称的联系
    private int bcnpf;
    //图书的中图法分类名与论文的关键词的联系
    private int bcnpi;

    //构造方法
    public Weight(String name, int bba, int bbcid, int ppa, int ppf, int ppi, int bpa, int bcnpf, int bcnpi) {
        this.name = name;
        this.bba = bba;
        this.bbcid = bbcid;
        this.ppa = ppa;
        this.ppf = ppf;
        this.ppi = ppi;
        this.bpa = bpa;
        this.bcnpf = bcnpf;
        this.bcnpi = bcnpi;
    }

    public Weight(int weightId) {
        if (weightId == 1) {
            //多样性
            this.name = "Diversity";
            this.bba = 1;
            this.bbcid = 10;
            this.ppa = 1;
            this.ppf = 5;
            this.bpa = 2;
            this.bcnpf = 10;
            this.bcnpi = 10;
        } else if (weightId == 2) {
            this.name = "Precision";
            this.bba = 1;
            this.bbcid = 10;
            this.ppa = 1;
            this.ppf = 5;
            this.bpa = 2;
            this.bcnpf = 10;
            this.bcnpi = 10;
        } else if (weightId == 3) {
            this.name = "Normal";
            this.bba = 1;
            this.bbcid = 10;
            this.ppa = 1;
            this.ppf = 5;
            this.bpa = 2;
            this.bcnpf = 10;
            this.bcnpi = 10;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBba() {
        return bba;
    }

    public void setBba(int bba) {
        this.bba = bba;
    }

    public int getBbcid() {
        return bbcid;
    }

    public void setBbcid(int bbcid) {
        this.bbcid = bbcid;
    }

    public int getPpa() {
        return ppa;
    }

    public void setPpa(int ppa) {
        this.ppa = ppa;
    }

    public int getPpf() {
        return ppf;
    }

    public void setPpf(int ppf) {
        this.ppf = ppf;
    }

    public int getPpi() {
        return ppi;
    }

    public void setPpi(int ppi) {
        this.ppi = ppi;
    }

    public int getBpa() {
        return bpa;
    }

    public void setBpa(int bpa) {
        this.bpa = bpa;
    }

    public int getBcnpf() {
        return bcnpf;
    }

    public void setBcnpf(int bcnpf) {
        this.bcnpf = bcnpf;
    }

    public int getBcnpi() {
        return bcnpi;
    }

    public void setBcnpi(int bcnpi) {
        this.bcnpi = bcnpi;
    }
}
