package com.tutu.tallybook.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author tutu
 * @time 2018/1/15
 */

public class SFZAuthBean {


    /**
     * image_id : FzVQXwfq9ib9zhYSaA4ufw==
     * request_id : 1516010602,79631c1d-ff9b-44af-ab53-83c279029394
     * cards : [{"name":"侯平","gender":"男","id_card_number":"430424199308026455","birthday":"1993-08-02","race":"汉","legality":{"Edited":0,"Photocopy":0,"ID Photo":0.99,"Screen":0.01,"Temporary ID Photo":0},"address":"湖南省衡东县蓬源镇合兴村8组","type":1,"side":"front"}]
     * time_used : 523
     */

    private String image_id;
    private String request_id;
    private int time_used;
    private List<CardsBean> cards;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public List<CardsBean> getCards() {
        return cards;
    }

    public void setCards(List<CardsBean> cards) {
        this.cards = cards;
    }

    public static class CardsBean {
        /**
         * name : 侯平
         * gender : 男
         * id_card_number : 430424199308026455
         * birthday : 1993-08-02
         * race : 汉
         * legality : {"Edited":0,"Photocopy":0,"ID Photo":0.99,"Screen":0.01,"Temporary ID Photo":0}
         * address : 湖南省衡东县蓬源镇合兴村8组
         * type : 1
         * side : front
         */

        private String name;
        private String gender;
        private String id_card_number;
        private String birthday;
        private String race;
        private LegalityBean legality;
        private String address;
        private int type;
        private String side;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getId_card_number() {
            return id_card_number;
        }

        public void setId_card_number(String id_card_number) {
            this.id_card_number = id_card_number;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public LegalityBean getLegality() {
            return legality;
        }

        public void setLegality(LegalityBean legality) {
            this.legality = legality;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public static class LegalityBean {
            /**
             * Edited : 0.0
             * Photocopy : 0.0
             * ID Photo : 0.99
             * Screen : 0.01
             * Temporary ID Photo : 0.0
             */

            private double Edited;
            private double Photocopy;
            @SerializedName("ID Photo")
            private double _$IDPhoto232; // FIXME check this code
            private double Screen;
            @SerializedName("Temporary ID Photo")
            private double _$TemporaryIDPhoto193; // FIXME check this code

            public double getEdited() {
                return Edited;
            }

            public void setEdited(double Edited) {
                this.Edited = Edited;
            }

            public double getPhotocopy() {
                return Photocopy;
            }

            public void setPhotocopy(double Photocopy) {
                this.Photocopy = Photocopy;
            }

            public double get_$IDPhoto232() {
                return _$IDPhoto232;
            }

            public void set_$IDPhoto232(double _$IDPhoto232) {
                this._$IDPhoto232 = _$IDPhoto232;
            }

            public double getScreen() {
                return Screen;
            }

            public void setScreen(double Screen) {
                this.Screen = Screen;
            }

            public double get_$TemporaryIDPhoto193() {
                return _$TemporaryIDPhoto193;
            }

            public void set_$TemporaryIDPhoto193(double _$TemporaryIDPhoto193) {
                this._$TemporaryIDPhoto193 = _$TemporaryIDPhoto193;
            }
        }
    }
}
