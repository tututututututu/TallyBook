package com.tutu.tallybook.data;

import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.ResourceBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tu on 2017/12/20.
 */

public class Constans {
    public static Map<Integer, ResourceBean> resourceMap = new HashMap<>();

    public static ResourceBean getResource(int id) {
        return resourceMap.get(id);
    }

    public static void init() {
        resourceMap.put(1, new ResourceBean(true,"工资", R.mipmap.s1));
        resourceMap.put(2, new ResourceBean(true,"兼职", R.mipmap.s2));
        resourceMap.put(3, new ResourceBean(true,"礼金", R.mipmap.s3));
        resourceMap.put(4, new ResourceBean(true,"其他", R.mipmap.s4));
        resourceMap.put(5, new ResourceBean(true,"收入", R.mipmap.s5));
        resourceMap.put(6, new ResourceBean(true,"金融", R.mipmap.s6));

        resourceMap.put(7, new ResourceBean(false,"办公", R.mipmap.s7));
        resourceMap.put(8, new ResourceBean(false,"餐饮", R.mipmap.s8));
        resourceMap.put(9, new ResourceBean(false,"唱歌", R.mipmap.s9));
        resourceMap.put(10, new ResourceBean(false,"宠物", R.mipmap.s10));
        resourceMap.put(11, new ResourceBean(false,"打车", R.mipmap.s11));
        resourceMap.put(12, new ResourceBean(false,"房租", R.mipmap.s12));
        resourceMap.put(13, new ResourceBean(false,"购物", R.mipmap.s13));
        resourceMap.put(14, new ResourceBean(false,"儿童", R.mipmap.s14));
        resourceMap.put(15, new ResourceBean(false,"喝茶", R.mipmap.s15));
        resourceMap.put(16, new ResourceBean(false,"喝酒", R.mipmap.s16));
        resourceMap.put(17, new ResourceBean(false,"交通", R.mipmap.s17));
        resourceMap.put(18, new ResourceBean(false,"捐款", R.mipmap.s18));
        resourceMap.put(19, new ResourceBean(false,"家居", R.mipmap.s19));
        resourceMap.put(20, new ResourceBean(false,"快递", R.mipmap.s20));
        resourceMap.put(21, new ResourceBean(false,"溜冰", R.mipmap.s21));
        resourceMap.put(22, new ResourceBean(false,"礼物", R.mipmap.s22));
        resourceMap.put(23, new ResourceBean(false,"买书", R.mipmap.s23));
        resourceMap.put(24, new ResourceBean(false,"美容", R.mipmap.s24));
        resourceMap.put(25, new ResourceBean(false,"朋友", R.mipmap.s25));
        resourceMap.put(26, new ResourceBean(false,"日用", R.mipmap.s26));
        resourceMap.put(27, new ResourceBean(false,"社交", R.mipmap.s27));
        resourceMap.put(28, new ResourceBean(false,"生日", R.mipmap.s28));
        resourceMap.put(29, new ResourceBean(false,"水果", R.mipmap.s29));
        resourceMap.put(30, new ResourceBean(false,"数码", R.mipmap.s30));
        resourceMap.put(31, new ResourceBean(false,"停车", R.mipmap.s31));
        resourceMap.put(32, new ResourceBean(false,"通讯", R.mipmap.s32));
        resourceMap.put(33, new ResourceBean(false,"维修", R.mipmap.s33));
        resourceMap.put(34, new ResourceBean(false,"学习", R.mipmap.s34));
        resourceMap.put(35, new ResourceBean(false,"药品", R.mipmap.s35));
        resourceMap.put(36, new ResourceBean(false,"衣服", R.mipmap.s36));
        resourceMap.put(37, new ResourceBean(false,"游戏", R.mipmap.s37));
        resourceMap.put(38, new ResourceBean(false,"游泳", R.mipmap.s38));
        resourceMap.put(39, new ResourceBean(false,"运动", R.mipmap.s39));
        resourceMap.put(40, new ResourceBean(false,"长辈", R.mipmap.s40));
    }
}
