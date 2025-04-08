package com.entity.model;

import com.entity.LaoshiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心理咨询老师预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaoshiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约流水号
     */
    private String laoshiOrderUuidNumber;


    /**
     * 心理咨询老师
     */
    private Integer laoshiId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 当天的号
     */
    private String laoshiOrderHao;


    /**
     * 预约状态
     */
    private Integer laoshiOrderYesnoTypes;


    /**
     * 审核状态
     */
    private String laoshiOrderYesnoText;


    /**
     * 咨询结果
     */
    private String zixunjieguoText;


    /**
     * 心理咨询报告文件
     */
    private String laoshiOrderFile;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：预约流水号
	 */
    public String getLaoshiOrderUuidNumber() {
        return laoshiOrderUuidNumber;
    }


    /**
	 * 设置：预约流水号
	 */
    public void setLaoshiOrderUuidNumber(String laoshiOrderUuidNumber) {
        this.laoshiOrderUuidNumber = laoshiOrderUuidNumber;
    }
    /**
	 * 获取：心理咨询老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：心理咨询老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 设置：预约日期
	 */
    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：当天的号
	 */
    public String getLaoshiOrderHao() {
        return laoshiOrderHao;
    }


    /**
	 * 设置：当天的号
	 */
    public void setLaoshiOrderHao(String laoshiOrderHao) {
        this.laoshiOrderHao = laoshiOrderHao;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getLaoshiOrderYesnoTypes() {
        return laoshiOrderYesnoTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setLaoshiOrderYesnoTypes(Integer laoshiOrderYesnoTypes) {
        this.laoshiOrderYesnoTypes = laoshiOrderYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public String getLaoshiOrderYesnoText() {
        return laoshiOrderYesnoText;
    }


    /**
	 * 设置：审核状态
	 */
    public void setLaoshiOrderYesnoText(String laoshiOrderYesnoText) {
        this.laoshiOrderYesnoText = laoshiOrderYesnoText;
    }
    /**
	 * 获取：咨询结果
	 */
    public String getZixunjieguoText() {
        return zixunjieguoText;
    }


    /**
	 * 设置：咨询结果
	 */
    public void setZixunjieguoText(String zixunjieguoText) {
        this.zixunjieguoText = zixunjieguoText;
    }
    /**
	 * 获取：心理咨询报告文件
	 */
    public String getLaoshiOrderFile() {
        return laoshiOrderFile;
    }


    /**
	 * 设置：心理咨询报告文件
	 */
    public void setLaoshiOrderFile(String laoshiOrderFile) {
        this.laoshiOrderFile = laoshiOrderFile;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
