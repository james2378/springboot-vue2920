package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ExamrewrongquestionDao;
import com.entity.ExamrewrongquestionEntity;
import com.entity.view.ExamrewrongquestionView;
import com.service.ExamrewrongquestionService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 错题表 服务实现类
 */
@Service("examrewrongquestionService")
@Transactional
public class ExamrewrongquestionServiceImpl extends ServiceImpl<ExamrewrongquestionDao, ExamrewrongquestionEntity> implements ExamrewrongquestionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ExamrewrongquestionView> page =new Query<ExamrewrongquestionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
