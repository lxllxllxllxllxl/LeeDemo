package com.lee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class Dict {

  @TableId(value = "id",type = IdType.INPUT)
  private String id;

  @NotBlank(message = "类别不能为空")
  private String category;

  @NotBlank(message = "名称不能为空")
  private String name;

  @NotBlank(message = "值不能为空")
  private String value;

  private String comment;

}
