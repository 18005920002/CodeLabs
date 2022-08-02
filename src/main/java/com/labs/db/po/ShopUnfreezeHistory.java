package com.labs.db.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class ShopUnfreezeHistory implements Serializable {
    private Long id;
    private Long unfreezeId;
    private Integer status;
    private Integer orign;
    private String remark;
    private Long operatorId;
    private String operatorDeptName;
    private Date createdTime;
    private String unfreezeNo;
    private Integer autoFinish;
    private Double unfreezeDuration;
    private Integer saleDayFlag;
    private Date startTime;
    private Long startBy;
    private Date endTime;
    private Long endBy;
    private Date planEndTime;
    private Date setUpTime;
    private Integer shopStatus;

}
