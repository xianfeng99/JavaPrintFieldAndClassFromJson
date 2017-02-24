# JavaPrintFieldAndClassFromJson

  *介绍：根据给出的json来打印（生成）出自命名的类
  *可以根据json_to_field方法打印（生成）java属性
  *可以根据json_to_class方法打印（生成）包含解析的java类，但目前只支持int和String类型

  *运行(run) json_to_field(jsonStr):
------jsonStr is------
{"is_yellow_year_vip": "0",
"ret": 0,
"figureurl_qq_1":
"http://q.qlogo.cn/qqapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/40",
"figureurl_qq_2":
"http://q.qlogo.cn/qqapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/100",
"nickname": "小罗",
"yellow_vip_level": "0",
"msg": "",
"figureurl_1":
"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/50",
"vip": "0",
"level": "0",
"figureurl_2":
"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/100",
"is_yellow_vip": "0",
"gender": "男",
"figureurl":
"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/30"}
------GeneralField------
public String is_yellow_year_vip;
public int ret;
public String figureurl_qq_1;
public String figureurl_qq_2;
public String nickname;
public String yellow_vip_level;
public String msg;
public String figureurl_1;
public String vip;
public String level;
public String figureurl_2;
public String is_yellow_vip;
public String gender;
public String figureurl;

  *运行(run) json_to_class(jsonStr, "QQUser"):
------jsonStr is------
{"is_yellow_year_vip": "0",
"ret": 0,
"figureurl_qq_1":
"http://q.qlogo.cn/qqapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/40",
"figureurl_qq_2":
"http://q.qlogo.cn/qqapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/100",
"nickname": "小罗",
"yellow_vip_level": "0",
"msg": "",
"figureurl_1":
"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/50",
"vip": "0",
"level": "0",
"figureurl_2":
"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/100",
"is_yellow_vip": "0",
"gender": "男",
"figureurl":
"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/30"}
------GeneralClass------
public class QQUser {
        public String is_yellow_year_vip;
        public int ret;
        public String figureurl_qq_1;
        public String figureurl_qq_2;
        public String nickname;
        public String yellow_vip_level;
        public String msg;
        public String figureurl_1;
        public String vip;
        public String level;
        public String figureurl_2;
        public String is_yellow_vip;
        public String gender;
        public String figureurl;
        public static QQUser parse(String jsonString) {
                try {
                        JSONObject jsonObject = new JSONObject(jsonString);
                        QQUser mQQUser = new QQUser();
                        mQQUser.is_yellow_year_vip = jsonObject.getString("is_ye
llow_year_vip");
                        mQQUser.ret = jsonObject.getInt("ret");
                        mQQUser.figureurl_qq_1 = jsonObject.getString("figureurl
_qq_1");
                        mQQUser.figureurl_qq_2 = jsonObject.getString("figureurl
_qq_2");
                        mQQUser.nickname = jsonObject.getString("nickname");
                        mQQUser.yellow_vip_level = jsonObject.getString("yellow_
vip_level");
                        mQQUser.msg = jsonObject.getString("msg");
                        mQQUser.figureurl_1 = jsonObject.getString("figureurl_1"
);
                        mQQUser.vip = jsonObject.getString("vip");
                        mQQUser.level = jsonObject.getString("level");
                        mQQUser.figureurl_2 = jsonObject.getString("figureurl_2"
);
                        mQQUser.is_yellow_vip = jsonObject.getString("is_yellow_
vip");
                        mQQUser.gender = jsonObject.getString("gender");
                        mQQUser.figureurl = jsonObject.getString("figureurl");
                        return mQQUser;
                } catch (JSONException e) {
                        //e.printStackTrace();
                        return null;
                }
        }
        public static QQUser parse(JSONObject jsonObject) {
                try {
                        QQUser mQQUser = new QQUser();
                        mQQUser.is_yellow_year_vip = jsonObject.getString("is_ye
llow_year_vip");
                        mQQUser.ret = jsonObject.getInt("ret");
                        mQQUser.figureurl_qq_1 = jsonObject.getString("figureurl
_qq_1");
                        mQQUser.figureurl_qq_2 = jsonObject.getString("figureurl
_qq_2");
                        mQQUser.nickname = jsonObject.getString("nickname");
                        mQQUser.yellow_vip_level = jsonObject.getString("yellow_
vip_level");
                        mQQUser.msg = jsonObject.getString("msg");
                        mQQUser.figureurl_1 = jsonObject.getString("figureurl_1"
);
                        mQQUser.vip = jsonObject.getString("vip");
                        mQQUser.level = jsonObject.getString("level");
                        mQQUser.figureurl_2 = jsonObject.getString("figureurl_2"
);
                        mQQUser.is_yellow_vip = jsonObject.getString("is_yellow_
vip");
                        mQQUser.gender = jsonObject.getString("gender");
                        mQQUser.figureurl = jsonObject.getString("figureurl");
                        return mQQUser;
                } catch (JSONException e) {
                        //e.printStackTrace();
                        return null;
                }
        }
}
