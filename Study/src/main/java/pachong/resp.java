package pachong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname resp
 * @Date 2022/3/31 11:07
 * @Created by taoyuanyuan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class resp implements Serializable {

    private String Data;
    private String ErrCode;
    private String ErrMsg;
    private String TotalCount;
    private String Expansion;
    private String PageSize;
    private String PageIndex;
}
