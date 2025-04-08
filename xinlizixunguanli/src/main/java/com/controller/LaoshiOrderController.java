
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 心理咨询老师预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoshiOrder")
public class LaoshiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(LaoshiOrderController.class);

    @Autowired
    private LaoshiOrderService laoshiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private LaoshiService laoshiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("心理咨询老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = laoshiOrderService.queryPage(params);

        //字典表数据转换
        List<LaoshiOrderView> list =(List<LaoshiOrderView>)page.getList();
        for(LaoshiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LaoshiOrderEntity laoshiOrder = laoshiOrderService.selectById(id);
        if(laoshiOrder !=null){
            //entity转view
            LaoshiOrderView view = new LaoshiOrderView();
            BeanUtils.copyProperties( laoshiOrder , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(laoshiOrder.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(laoshiOrder.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LaoshiOrderEntity laoshiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoshiOrder:{}",this.getClass().getName(),laoshiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("心理咨询老师".equals(role))
            laoshiOrder.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("学生".equals(role))
            laoshiOrder.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        laoshiOrder.setInsertTime(new Date());
        laoshiOrder.setCreateTime(new Date());
        laoshiOrderService.insert(laoshiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaoshiOrderEntity laoshiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoshiOrder:{}",this.getClass().getName(),laoshiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("心理咨询老师".equals(role))
//            laoshiOrder.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("学生".equals(role))
//            laoshiOrder.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaoshiOrderEntity> queryWrapper = new EntityWrapper<LaoshiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshiOrderEntity laoshiOrderEntity = laoshiOrderService.selectOne(queryWrapper);
        if("".equals(laoshiOrder.getLaoshiOrderFile()) || "null".equals(laoshiOrder.getLaoshiOrderFile())){
                laoshiOrder.setLaoshiOrderFile(null);
        }
        if(laoshiOrderEntity==null){
            laoshiOrderService.updateById(laoshiOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 后端修改
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody LaoshiOrderEntity laoshiOrder, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,laoshiOrder:{}",this.getClass().getName(),laoshiOrder.toString());

        if(laoshiOrder.getLaoshiOrderYesnoTypes() ==2){

            LaoshiOrderEntity laoshiOrderEntity = laoshiOrderService.selectById(laoshiOrder.getId());


            List<LaoshiOrderEntity> laoshiOrderEntities = laoshiOrderService.selectList(
                    new EntityWrapper<LaoshiOrderEntity>()
                            .eq("laoshi_id", laoshiOrderEntity.getLaoshiId())
                            .eq("yuyue_time", new SimpleDateFormat("yyyy-MM-dd").format(laoshiOrderEntity.getYuyueTime()))
                            .eq("laoshi_order_yesno_types",2)
                    .orderDesc(Arrays.asList(new String[]{"laoshi_order_hao"}))
            );

            if(laoshiOrderEntities.size()>0){
                LaoshiOrderEntity laoshiOrderEntity1 = laoshiOrderEntities.get(0);
                Integer integer = Integer.valueOf(String.valueOf(laoshiOrderEntity1.getLaoshiOrderHao()))+1;
                laoshiOrder.setLaoshiOrderHao(String.valueOf(integer));
            }else{
                laoshiOrder.setLaoshiOrderHao(String.valueOf(1));
            }
        }



        laoshiOrderService.updateById(laoshiOrder);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laoshiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LaoshiOrderEntity> laoshiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LaoshiOrderEntity laoshiOrderEntity = new LaoshiOrderEntity();
//                            laoshiOrderEntity.setLaoshiOrderUuidNumber(data.get(0));                    //预约流水号 要改的
//                            laoshiOrderEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //心理咨询老师 要改的
//                            laoshiOrderEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            laoshiOrderEntity.setYuyueTime(sdf.parse(data.get(0)));          //预约日期 要改的
//                            laoshiOrderEntity.setLaoshiOrderHao(data.get(0));                    //当天的号 要改的
//                            laoshiOrderEntity.setLaoshiOrderYesnoTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            laoshiOrderEntity.setLaoshiOrderYesnoText(data.get(0));                    //审核状态 要改的
//                            laoshiOrderEntity.setZixunjieguoText(data.get(0));                    //咨询结果 要改的
//                            laoshiOrderEntity.setLaoshiOrderFile(data.get(0));                    //心理咨询报告文件 要改的
//                            laoshiOrderEntity.setInsertTime(date);//时间
//                            laoshiOrderEntity.setCreateTime(date);//时间
                            laoshiOrderList.add(laoshiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //预约流水号
                                if(seachFields.containsKey("laoshiOrderUuidNumber")){
                                    List<String> laoshiOrderUuidNumber = seachFields.get("laoshiOrderUuidNumber");
                                    laoshiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laoshiOrderUuidNumber = new ArrayList<>();
                                    laoshiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("laoshiOrderUuidNumber",laoshiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约流水号
                        List<LaoshiOrderEntity> laoshiOrderEntities_laoshiOrderUuidNumber = laoshiOrderService.selectList(new EntityWrapper<LaoshiOrderEntity>().in("laoshi_order_uuid_number", seachFields.get("laoshiOrderUuidNumber")));
                        if(laoshiOrderEntities_laoshiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaoshiOrderEntity s:laoshiOrderEntities_laoshiOrderUuidNumber){
                                repeatFields.add(s.getLaoshiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        laoshiOrderService.insertBatch(laoshiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = laoshiOrderService.queryPage(params);

        //字典表数据转换
        List<LaoshiOrderView> list =(List<LaoshiOrderView>)page.getList();
        for(LaoshiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LaoshiOrderEntity laoshiOrder = laoshiOrderService.selectById(id);
            if(laoshiOrder !=null){


                //entity转view
                LaoshiOrderView view = new LaoshiOrderView();
                BeanUtils.copyProperties( laoshiOrder , view );//把实体数据重构到view中

                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(laoshiOrder.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(laoshiOrder.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody LaoshiOrderEntity laoshiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,laoshiOrder:{}",this.getClass().getName(),laoshiOrder.toString());
            LaoshiEntity laoshiEntity = laoshiService.selectById(laoshiOrder.getLaoshiId());
            if(laoshiEntity == null){
                return R.error(511,"查不到该心理咨询老师");
            }
            // Double laoshiNewMoney = laoshiEntity.getLaoshiNewMoney();




            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            laoshiOrder.setXueshengId(userId); //设置订单支付人id

        LaoshiOrderEntity laoshiOrderEntity = laoshiOrderService.selectOne(new EntityWrapper<LaoshiOrderEntity>().eq("xuesheng_id", laoshiOrder.getXueshengId()).eq("laoshi_id", laoshiOrder.getLaoshiId()).notIn("laoshi_order_yesno_types", 3).eq("yuyue_time",new SimpleDateFormat("yyyy-MM-dd").format(laoshiOrder.getYuyueTime())));

        if(laoshiOrderEntity != null){
            if(laoshiOrderEntity.getLaoshiOrderYesnoTypes() ==1){
                return R.error("您已经预约了当天的心理咨询老师,无法重复预约,状态是已预约");
            }

            if(laoshiOrderEntity.getLaoshiOrderYesnoTypes() ==2){
                return R.error("您已经预约了当天的心理咨询老师,无法重复预约,状态是预约成功");
            }
        }


        laoshiOrder.setLaoshiOrderUuidNumber(String.valueOf(new Date().getTime()));
            laoshiOrder.setInsertTime(new Date());
            laoshiOrder.setCreateTime(new Date());
                laoshiOrderService.insert(laoshiOrder);//新增订单
            return R.ok();
    }



}
