package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamquestionEntity;
import com.entity.view.ExamquestionView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 试题表 Dao 接口
 *
 * @author 
 */
public interface ExamquestionDao extends BaseMapper<ExamquestionEntity> {

   List<ExamquestionView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
