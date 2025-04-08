package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 错题表
 *
 * @author 
 * @email
 */
@TableName("examrewrongquestion")
public class ExamrewrongquestionEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ExamrewrongquestionEntity() {

	}

	public ExamrewrongquestionEntity(T t) {
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
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 试卷（外键）
     */
    @TableField(value = "exampaper_id")

    private Integer exampaperId;


    /**
     * 试题id（外键）
     */
    @TableField(value = "examquestion_id")

    private Integer examquestionId;


    /**
     * 考生作答
     */
    @TableField(value = "examredetails_myanswer")

    private String examredetailsMyanswer;


    /**
     * 记录时间
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
	 * 设置：试卷（外键）
	 */
    public Integer getExampaperId() {
        return exampaperId;
    }
    /**
	 * 获取：试卷（外键）
	 */

    public void setExampaperId(Integer exampaperId) {
        this.exampaperId = exampaperId;
    }
    /**
	 * 设置：试题id（外键）
	 */
    public Integer getExamquestionId() {
        return examquestionId;
    }
    /**
	 * 获取：试题id（外键）
	 */

    public void setExamquestionId(Integer examquestionId) {
        this.examquestionId = examquestionId;
    }
    /**
	 * 设置：考生作答
	 */
    public String getExamredetailsMyanswer() {
        return examredetailsMyanswer;
    }
    /**
	 * 获取：考生作答
	 */

    public void setExamredetailsMyanswer(String examredetailsMyanswer) {
        this.examredetailsMyanswer = examredetailsMyanswer;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
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
        return "Examrewrongquestion{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", exampaperId=" + exampaperId +
            ", examquestionId=" + examquestionId +
            ", examredetailsMyanswer=" + examredetailsMyanswer +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
