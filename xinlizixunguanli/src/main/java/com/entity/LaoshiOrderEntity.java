package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 心理咨询老师预约
 *
 * @author 
 * @email
 */
@TableName("laoshi_order")
public class LaoshiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaoshiOrderEntity() {

	}

	public LaoshiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 预约流水号
     */
    @TableField(value = "laoshi_order_uuid_number")

    private String laoshiOrderUuidNumber;


    /**
     * 心理咨询老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 当天的号
     */
    @TableField(value = "laoshi_order_hao")

    private String laoshiOrderHao;


    /**
     * 预约状态
     */
    @TableField(value = "laoshi_order_yesno_types")

    private Integer laoshiOrderYesnoTypes;


    /**
     * 审核状态
     */
    @TableField(value = "laoshi_order_yesno_text")

    private String laoshiOrderYesnoText;


    /**
     * 咨询结果
     */
    @TableField(value = "zixunjieguo_text")

    private String zixunjieguoText;


    /**
     * 心理咨询报告文件
     */
    @TableField(value = "laoshi_order_file")

    private String laoshiOrderFile;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约流水号
	 */
    public String getLaoshiOrderUuidNumber() {
        return laoshiOrderUuidNumber;
    }
    /**
	 * 获取：预约流水号
	 */

    public void setLaoshiOrderUuidNumber(String laoshiOrderUuidNumber) {
        this.laoshiOrderUuidNumber = laoshiOrderUuidNumber;
    }
    /**
	 * 设置：心理咨询老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }
    /**
	 * 获取：心理咨询老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 获取：预约日期
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：当天的号
	 */
    public String getLaoshiOrderHao() {
        return laoshiOrderHao;
    }
    /**
	 * 获取：当天的号
	 */

    public void setLaoshiOrderHao(String laoshiOrderHao) {
        this.laoshiOrderHao = laoshiOrderHao;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getLaoshiOrderYesnoTypes() {
        return laoshiOrderYesnoTypes;
    }
    /**
	 * 获取：预约状态
	 */

    public void setLaoshiOrderYesnoTypes(Integer laoshiOrderYesnoTypes) {
        this.laoshiOrderYesnoTypes = laoshiOrderYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */
    public String getLaoshiOrderYesnoText() {
        return laoshiOrderYesnoText;
    }
    /**
	 * 获取：审核状态
	 */

    public void setLaoshiOrderYesnoText(String laoshiOrderYesnoText) {
        this.laoshiOrderYesnoText = laoshiOrderYesnoText;
    }
    /**
	 * 设置：咨询结果
	 */
    public String getZixunjieguoText() {
        return zixunjieguoText;
    }
    /**
	 * 获取：咨询结果
	 */

    public void setZixunjieguoText(String zixunjieguoText) {
        this.zixunjieguoText = zixunjieguoText;
    }
    /**
	 * 设置：心理咨询报告文件
	 */
    public String getLaoshiOrderFile() {
        return laoshiOrderFile;
    }
    /**
	 * 获取：心理咨询报告文件
	 */

    public void setLaoshiOrderFile(String laoshiOrderFile) {
        this.laoshiOrderFile = laoshiOrderFile;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LaoshiOrder{" +
            "id=" + id +
            ", laoshiOrderUuidNumber=" + laoshiOrderUuidNumber +
            ", laoshiId=" + laoshiId +
            ", xueshengId=" + xueshengId +
            ", yuyueTime=" + yuyueTime +
            ", laoshiOrderHao=" + laoshiOrderHao +
            ", laoshiOrderYesnoTypes=" + laoshiOrderYesnoTypes +
            ", laoshiOrderYesnoText=" + laoshiOrderYesnoText +
            ", zixunjieguoText=" + zixunjieguoText +
            ", laoshiOrderFile=" + laoshiOrderFile +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
