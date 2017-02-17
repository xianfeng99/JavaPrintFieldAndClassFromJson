import java.util.ArrayList;
public class PrintJavaFromJson{
	
	public static void main(String[] args){
		test_json();
	}
	
	public static void test_json(){

        String jsonStr = "{\"is_yellow_year_vip\": \"0\",\n" +
                "\"ret\": 0,\n" +
                "\"figureurl_qq_1\":\n" +
                "\"http://q.qlogo.cn/qqapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/40\",\n" +
                "\"figureurl_qq_2\":\n" +
                "\"http://q.qlogo.cn/qqapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/100\",\n" +
                "\"nickname\": \"小罗\",\n" +
                "\"yellow_vip_level\": \"0\",\n" +
                "\"msg\": \"\",\n" +
                "\"figureurl_1\":\n" +
                "\"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/50\",\n" +
                "\"vip\": \"0\",\n" +
                "\"level\": \"0\",\n" +
                "\"figureurl_2\":\n" +
                "\"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/100\",\n" +
                "\"is_yellow_vip\": \"0\",\n" +
                "\"gender\": \"男\",\n" +
                "\"figureurl\":\n" +
                "\"http://qzapp.qlogo.cn/qzapp/222222/8C75BBE3DC6B0E9A64BD31449A3C8CB0/30\"}";

//        json_to_field(jsonStr);
        json_to_class(jsonStr, "QQUser");

    }

    public static void json_to_field(String jsonStr){
        if(jsonStr.startsWith("{") && jsonStr.endsWith("}")){
            jsonStr = jsonStr.substring(1, jsonStr.length() - 1);
        }

        String[] params = jsonStr.replace("\n", "").split(",");

        for(String param : params){

            String[] map = param.split(":");
            String key = map[0];
            String value = map[1].replace(" ", "");
            //下面是区分int和String的方式，可以使用其他条件来判断（建议），丰富更多类型的时候会替换成条件判断
            try{
                key = key.replace("\"", "");
                Integer.parseInt(value);
                System.out.println("public int " + key + ";");
            }catch (Exception e){
                System.out.println("public String " + key + ";");
            }

        }
    }

    public static void json_to_parse(String jsonStr, String className){
        if(jsonStr.startsWith("{") && jsonStr.endsWith("}")){
            jsonStr = jsonStr.substring(1, jsonStr.length() - 1);
        }
        String[] params = jsonStr.replace("\n", "").split(",");
        ArrayList<String> jsonParses = new ArrayList<>();
        String classObj = "m" + className;
        String jsonObject = "jsonObject";

        for(String param : params){
            String[] map = param.split(":");
            String key = map[0];
            String value = map[1].replace(" ", "");
            try{
                key = key.replace("\"", "");
                Integer.parseInt(value);
                System.out.println("public int " + key + ";");

                value = jsonObject + ".getInt(\"" + key + "\");";
            }catch (Exception e){
                System.out.println("public String " + key + ";");
                value = jsonObject + ".getString(\"" + key + "\" );";

            }
            jsonParses.add(classObj + "." + key + " = " + value);
        }

        System.out.println("public static " + className + " parse(JSONObject " + jsonObject + ") {");
        System.out.println("\tif (null == " + jsonObject + ") {return null;}");
        System.out.println("\t" + className + " " + classObj + " = new " + className + "();");

        for(String jsonParam : jsonParses){
            System.out.println("\t" + jsonParam);
        }

        System.out.println("}");
    }

    public static void json_to_class(String jsonStr, String className){
        if(jsonStr.startsWith("{") && jsonStr.endsWith("}")){
            jsonStr = jsonStr.substring(1, jsonStr.length() - 1);
        }
        String[] params = jsonStr.replace("\n", "").split(",");
        ArrayList<String> jsonParses = new ArrayList<>();

        String classObj = "m" + className;
        String jsonString = "jsonString";
        String jsonObject = "jsonObject";
        //类名开始的结构
        println("public class " + className + " {");
        //属性抽离和打印
        for(String param : params){
            String[] map = param.split(":");
            String key = map[0];
            String value = map[1].replace(" ", "");
            try{
                key = key.replace("\"", "");
                Integer.parseInt(value);
                println_t(1, "public int " + key + ";");
                value = jsonObject + ".getInt(\"" + key + "\");";
            }catch (Exception e){
                println_t(1, "public String " + key + ";");
                value = jsonObject + ".getString(\"" + key + "\");";
            }
            //组合的解析json添加的list中
            jsonParses.add(classObj + "." + key + " = " + value);
        }
        //className parse(String jsonString)方法
        //使用方式：className obj = className.parse(jsonString),如QQUser user = QQUser.parse(jsonString)
        println_t(1, "public static " + className + " parse(String " + jsonString + ") {");
        println_t(2, "try {");
        println_t(3, "JSONObject jsonObject = new JSONObject(" + jsonString + ");");
        println_t(3, className + " " + classObj + " = new " + className + "();");
        for(String jsonParam : jsonParses){
            println_t(3, jsonParam);
        }
        println_t(3, "return " + classObj + ";");
        println_t(2, "} catch (JSONException e) {");
        println_t(3, "//e.printStackTrace();");
        println_t(3, "return null;");
        println_t(2, "}");
        println_t(1, "}");

        //className parse(JSONObject jsonString)方法
        println_t(1, "public static " + className + " parse(JSONObject " + jsonObject + ") {");
        println_t(2, "try {");
        println_t(3, className + " " + classObj + " = new " + className + "();");
        for(String jsonParam : jsonParses){
            println_t(3, jsonParam);
        }
        println_t(3, "return " + classObj + ";");
        println_t(2, "} catch (JSONException e) {");
        println_t(3, "//e.printStackTrace();");
        println_t(3, "return null;");
        println_t(2, "}");
        println_t(1, "}");
        println("}");
    }

    private static void println(String str){
        System.out.println(str);
    }

    private static void println_t(int tableNum, String str){
        String tstr = "";
        for(int i = 0; i < tableNum; i ++){
            tstr += "\t";
        }
        System.out.println(tstr + str);
    }
}