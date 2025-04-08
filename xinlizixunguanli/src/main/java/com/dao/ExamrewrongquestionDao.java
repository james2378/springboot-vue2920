package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamrewrongquestionEntity;
import com.entity.view.ExamrewrongquestionView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 错题表 Dao 接口
 *
 * @author 
 */
public interface ExamrewrongquestionDao extends BaseMapper<ExamrewrongquestionEntity> {

   List<ExamrewrongquestionView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
