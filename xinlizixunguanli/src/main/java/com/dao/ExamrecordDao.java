package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamrecordEntity;
import com.entity.view.ExamrecordView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 考试记录表 Dao 接口
 *
 * @author 
 */
public interface ExamrecordDao extends BaseMapper<ExamrecordEntity> {

   List<ExamrecordView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
