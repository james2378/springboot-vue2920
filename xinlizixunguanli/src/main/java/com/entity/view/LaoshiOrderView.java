package com.entity.view;

import com.entity.LaoshiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 心理咨询老师预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laoshi_order")
public class LaoshiOrderView extends LaoshiOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 预约状态的值
		*/
		private String laoshiOrderYesnoValue;



		//级联表 xuesheng
			/**
			* 学生编号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

		//级联表 laoshi
			/**
			* 心理咨询老师编号
			*/
			private String laoshiUuidNumber;
			/**
			* 心理咨询老师姓名
			*/
			private String laoshiName;
			/**
			* 心理咨询老师手机号
			*/
			private String laoshiPhone;
			/**
			* 心理咨询老师头像
			*/
			private String laoshiPhoto;
			/**
			* 擅长
			*/
			private String laoshiShanchang;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;
			/**
			* 心理咨询老师介绍
			*/
			private String laoshiText;

	public LaoshiOrderView() {

	}

	public LaoshiOrderView(LaoshiOrderEntity laoshiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, laoshiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 预约状态的值
			*/
			public String getLaoshiOrderYesnoValue() {
				return laoshiOrderYesnoValue;
			}
			/**
			* 设置： 预约状态的值
			*/
			public void setLaoshiOrderYesnoValue(String laoshiOrderYesnoValue) {
				this.laoshiOrderYesnoValue = laoshiOrderYesnoValue;
			}














				//级联表的get和set xuesheng

					/**
					* 获取： 学生编号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学生编号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}


				//级联表的get和set laoshi

					/**
					* 获取： 心理咨询老师编号
					*/
					public String getLaoshiUuidNumber() {
						return laoshiUuidNumber;
					}
					/**
					* 设置： 心理咨询老师编号
					*/
					public void setLaoshiUuidNumber(String laoshiUuidNumber) {
						this.laoshiUuidNumber = laoshiUuidNumber;
					}

					/**
					* 获取： 心理咨询老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 心理咨询老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}

					/**
					* 获取： 心理咨询老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 心理咨询老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}

					/**
					* 获取： 心理咨询老师头像
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 心理咨询老师头像
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}

					/**
					* 获取： 擅长
					*/
					public String getLaoshiShanchang() {
						return laoshiShanchang;
					}
					/**
					* 设置： 擅长
					*/
					public void setLaoshiShanchang(String laoshiShanchang) {
						this.laoshiShanchang = laoshiShanchang;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}

					/**
					* 获取： 心理咨询老师介绍
					*/
					public String getLaoshiText() {
						return laoshiText;
					}
					/**
					* 设置： 心理咨询老师介绍
					*/
					public void setLaoshiText(String laoshiText) {
						this.laoshiText = laoshiText;
					}




}
