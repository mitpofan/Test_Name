package mish.lisow.test_name;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lisow on 11.09.2018.
 */

public class Offers {

    private String name;
    private String des;
    private String logo;
    private String des_full;
    private String url;
    private String btn1;
    private String btn2;
    private boolean browser;
    private boolean enabled;

    public Offers(String name, String des, String btn1, String logo, String des_full, String btn2, boolean browser, boolean enabled, String url){
        this.name = name;
        this.des = des;
        this.btn1 = btn1;
        this.logo = logo;
        this.des_full = des_full;
        this.btn2 = btn2;
        this.browser = browser;
        this.enabled = enabled;
        this.url = url;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDes(){
        return this.des;
    }
    public void setDes(String Des){
        this.des = Des;
    }
    public String getDes_full(){
        return this.des_full;
    }
    public void setDes_full(String des_full){
        this.des_full = des_full;
    }
    public String getURL(){
        return this.url;
    }
    public void setURL(String URL){
        this.url = URL;
    }
    public String getBtn1(){
        return this.btn1;
    }
    public void setBtn1(String btn1){
        this.btn1 = btn1;
    }
    public String getBtn2(){
        return this.btn2;
    }
    public void setBtn2(String btn2){
        this.btn2 = btn2;
    }
    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public boolean getBrowser(){
        return this.browser;
    }
    public void setBrowser(boolean name){
        this.browser = browser;
    }
    public boolean getEnabled(){
        return this.enabled;
    }
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
}
