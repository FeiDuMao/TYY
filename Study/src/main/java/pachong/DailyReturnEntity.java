package pachong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname DailyReturnEntity
 * @Date 2022/3/31 11:03
 * @Created by taoyuanyuan
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DailyReturnEntity implements Serializable {

    private String fsrq;
    private String dwjz;
    private String ljjz;
    private String sdate;
    private String actualsyi;
    private String navtype;
    private String jzzzl;
    private String sgzt;
    private String shzt;
    private String fhfcz;
    private String fhfcbz;
    private String dtype;
    private String fhsp;


}
