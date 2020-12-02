package qian.xun.facade.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class User    implements Serializable {

  private Integer id;
  private String name;
  private Integer sex;
  private String mobile;
  private String password;
  private String salt;
  private Integer status;
  private String interTime;


}
