package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ExamrecordEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 考试记录表 服务类
 */
public interface ExamrecordService extends IService<ExamrecordEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}