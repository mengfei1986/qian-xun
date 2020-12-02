package qian.xun.facade.po;

 import lombok.Data;

 import java.io.Serializable;
 @Data
public class SysDictItem    implements Serializable {

  private Integer id;
  private String dictCode;
  private String itemKey;
  private String itemVal;
  private Integer status;
  private String createBy;
  private String createTime;
  private String updateBy;
  private String updateTime;

}
