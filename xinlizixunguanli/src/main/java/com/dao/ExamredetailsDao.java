package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamredetailsEntity;
import com.entity.view.ExamredetailsView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 答题详情表 Dao 接口
 *
 * @author 
 */
public interface ExamredetailsDao extends BaseMapper<ExamredetailsEntity> {

   List<ExamredetailsView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
