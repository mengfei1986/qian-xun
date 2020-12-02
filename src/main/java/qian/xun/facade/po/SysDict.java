package qian.xun.facade.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysDict    implements Serializable {

  private Integer id;
  private String dictName;
  private String dictCode;
  private String remark;
  private Integer status;
  private String createBy;
  private String createTime;
  private String updateBy;
  private String updateTime;

}
