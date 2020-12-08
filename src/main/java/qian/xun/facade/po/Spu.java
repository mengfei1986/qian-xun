package qian.xun.facade.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Spu implements Serializable {

  private Integer id;
  private String spuId;
  private String name;
  private String modelNo;
  private String specs;
  private String headUrl;
  private String seller;
  private String dataSource;
  private Integer basePrice;
  private Integer status;
  private String createBy;
  private String createTime;
  private String updateBy;
  private String updateTime;

}
