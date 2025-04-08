package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ExamredetailsDao;
import com.entity.ExamredetailsEntity;
import com.entity.view.ExamredetailsView;
import com.service.ExamredetailsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 答题详情表 服务实现类
 */
@Service("examredetailsService")
@Transactional
public class ExamredetailsServiceImpl extends ServiceImpl<ExamredetailsDao, ExamredetailsEntity> implements ExamredetailsService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ExamredetailsView> page =new Query<ExamredetailsView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
