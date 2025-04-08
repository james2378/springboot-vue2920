package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ExampaperEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 试卷表 服务类
 */
public interface ExampaperService extends IService<ExampaperEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}