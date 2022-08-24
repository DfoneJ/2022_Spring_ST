package Util;

public class StringFormatUtil {

    public static String getFormatMoney(String money) {
        String[] sp = money.split("\\.");
        String s = String.format("%,d", Integer.parseInt(sp[0]));
        if (sp.length >= 2)
            s += "." + sp[1];
        return s;
    }
}
