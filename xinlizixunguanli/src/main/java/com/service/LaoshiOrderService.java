package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshiOrderEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 心理咨询老师预约 服务类
 */
public interface LaoshiOrderService extends IService<LaoshiOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}