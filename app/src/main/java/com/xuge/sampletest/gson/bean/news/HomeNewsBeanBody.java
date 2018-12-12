package com.xuge.sampletest.gson.bean.news;

public class HomeNewsBeanBody {
    private HomeNewsPageBean pagebean;
    private String ret_code;
    public HomeNewsPageBean getPagebean() {
        return pagebean;
    }
    public void setPagebean(HomeNewsPageBean pagebean) {
        this.pagebean = pagebean;
    }
    public String getRet_code() {
        return ret_code;
    }
    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    /*@Override
    public String toString() {
        return "HomeNewsBeanBody [pagebean=" + pagebean + ", ret_code="
                + ret_code + "]";
    }*/
}
