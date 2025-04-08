package com.dao;

import com.entity.LaoshiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshiOrderView;

/**
 * 心理咨询老师预约 Dao 接口
 *
 * @author 
 */
public interface LaoshiOrderDao extends BaseMapper<LaoshiOrderEntity> {

   List<LaoshiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
