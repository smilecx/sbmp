package com.ziyun.cloud.module.operator.vo;

import com.ziyun.cloud.module.operator.entity.Mobile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/1 16:00
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MobileVo extends Mobile {

    private Integer page;
    private Integer limit;

    private String startNum;
    private String endNum;

    @Override
    public String toString() {
        return "MobileVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", startNum='" + startNum + '\'' +
                ", endNum='" + endNum + '\'' +
                "} " + super.toString();
    }
}
