package qian.xun.facade.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sku implements Serializable {

  private Integer id;
  private String spuId;
  private String headUrl;
  private String colorNo;
  private String colorDesc;
  private Integer price;
  private Integer status;
  private String createBy;
  private String createTime;
  private String updateBy;
  private String updateTime;

}
