package com.example;

/**
     * 房间模式
     */
    public enum Mode {
        COMMON("common"),                               //普通模式
        KTV("ktv"),                                     //K歌模式
        VIDEO("video"),                                 //7人交友场
        SEVEN_BLIND_DATE("seven_blind_date"),           //7人相亲交友
        AUDIO_BLIND_DATE("audio_blind_date"),           //相亲模式
        SWEET_HEART("sweetheart"),                      //情侣场
        SEVEN_PEOPLE_TRAIN("seven_people_train");       //七人徒弟培训场

//        public String name;
        public String value;

        Mode(String name) {
//            this.name = name;
            this.value = name;
        }
    }