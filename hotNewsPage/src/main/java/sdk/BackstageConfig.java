package sdk;

public class BackstageConfig {

    // 填入自己的captcha_id和private_key
    private static final String geetest_id = "002bc30ff1eef93e912f45814945e752";
    private static final String geetest_key = "4193a0e3247b82a26f563d595c447b1a";
    private static final boolean newfailback = true;
    private static final String password = "123456";

    public static String getGeetest_id() {
        return geetest_id;
    }

    public static String getGeetest_key() {
        return geetest_key;
    }

    public static boolean isNewFailBack() {
        return newfailback;
    }

    public static boolean verify(String pwd){
        return pwd.equals(password);
    }
}
