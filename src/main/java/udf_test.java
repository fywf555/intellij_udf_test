import net.ipip.ipdb.City;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.Arrays;

public class udf_test extends UDF {
    public String evalueate(String ip)
    {
        String ip_info = "";
        try {
            // City类可用于IPDB格式的IPv4免费库，IPv4与IPv6的每周高级版、每日标准版、每日高级版、每日专业版、每日旗舰版
            City db = new City("Resource/mydatavipday3.ipdb");
            ip_info = Arrays.toString(db.find(ip, "CN"));
        }
        catch (Exception e) {
//            e.printStackTrace();
        }
        return ip_info;
    }
    public static void main(String[] args) {
        udf_test udf = new udf_test();
        System.out.println(udf.evalueate("218.22.113.103"));
    }
}
