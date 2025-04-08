package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ExamrewrongquestionEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 错题表 服务类
 */
public interface ExamrewrongquestionService extends IService<ExamrewrongquestionEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}