<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <!-- bootstrap样式，地图插件使用 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<body style="background: #EEEEEE; ">


<div id="app">

    <!-- 轮播图 -->
    <div class="layui-carousel" id="swiper">
        <div carousel-item id="swiper-item">
            <div v-for="(item,index) in swiperList" v-bind:key="index">
                <img class="swiper-item" :src="item.img">
            </div>
        </div>
    </div>
    <!-- 轮播图 -->

    <div class="data-add-container">

        <form class="layui-form layui-form-pane" lay-filter="myForm">
            <!-- 级联表的 -->
            <div class="layui-form-item" pane>
                <label class="layui-form-label">心理咨询老师编号：</label>
                <div class="layui-input-block">
                    <input v-model="laoshi.laoshiUuidNumber" type="text"  readonly="readonly" name="laoshiUuidNumber" id="laoshiUuidNumber" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" pane>
                <label class="layui-form-label">心理咨询老师姓名：</label>
                <div class="layui-input-block">
                    <input v-model="laoshi.laoshiName" type="text"  readonly="readonly" name="laoshiName" id="laoshiName" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

<!-- 手机号 -->
            <div class="layui-form-item" pane>
                <label class="layui-form-label">心理咨询老师手机号：</label>
                <div class="layui-input-inline">
                    <input v-model="laoshi.laoshiPhone" type="text" readonly="readonly" name="laoshiPhone" id="laoshiPhone"  lay-verify="phone|required"   placeholder="心理咨询老师手机号" autocomplete="off" class="layui-input">
                </div>
            </div>
                
            <div class="layui-form-item" pane>
                <label class="layui-form-label">心理咨询老师头像：</label>
                <div v-if="laoshi.laoshiPhoto" class="layui-input-block">
                    <img id="laoshiPhotoImg"
                         style="width: 100px;height: 100px;border-radius: 50%;border: 2px solid #EEEEEE;"
                         :src="laoshi.laoshiPhoto">
                    <input type="hidden" :value="detail.laoshiPhoto" readonly="readonly" id="laoshiPhoto" name="laoshiPhoto"/>
                </div>
            </div>
                            <div class="layui-form-item" pane>
                <label class="layui-form-label">擅长：</label>
                <div class="layui-input-block">
                    <input v-model="laoshi.laoshiShanchang" type="text"  readonly="readonly" name="laoshiShanchang" id="laoshiShanchang" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

<!-- 邮箱 -->
            <div class="layui-form-item" pane>
                <label class="layui-form-label">电子邮箱：</label>
                <div class="layui-input-inline">
                    <input v-model="laoshi.laoshiEmail" type="text" readonly="readonly" name="laoshiEmail" id="laoshiEmail"  lay-verify="email|required"   placeholder="电子邮箱" autocomplete="off" class="layui-input">
                </div>
            </div>


            <!-- 当前表的 -->
<!-- 唯一uuid -->
            <%--<div class="layui-form-item" pane>
                <label class="layui-form-label">预约流水号：</label>
                <div class="layui-input-inline">
                    <input  type="text" name="laoshiOrderUuidNumber" id="laoshiOrderUuidNumber"  lay-verify="required"   placeholder="预约流水号" autocomplete="off" class="layui-input" readonly="readonly">
                </div>
            </div>--%>
            <!-- 级联表的表id -->
            <input type="hidden" :value="laoshi.id" id="laoshiId" name="laoshiId"/>
            <div class="layui-form-item" pane>
                <label class="layui-form-label">预约日期：</label>
                <div class="layui-input-block">
                    <input <%--v-model="detail.yuyueTime"--%> type="text" name="yuyueTime" id="yuyueTime" placeholder="预约日期" lay-verify="required" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <%--<div class="layui-form-item" pane>
                <label class="layui-form-label">当天的号：</label>
                <div class="layui-input-block">
                    <input &lt;%&ndash;v-model="detail.laoshiOrderHao"&ndash;%&gt; type="text" name="laoshiOrderHao" id="laoshiOrderHao" placeholder="当天的号" lay-verify="required" autocomplete="off"
                           class="layui-input">
                </div>
            </div>--%>

<!-- text后缀 -->
            <%--<div class="layui-form-item layui-form-text input">
                <label class="layui-form-label">咨询结果：</label>
                <div class="layui-input-inline">
                    <textarea v-model="detail.zixunjieguoText" name="zixunjieguoText" id="zixunjieguoText"  lay-verify="required"   placeholder="咨询结果" autocomplete="off" ></textarea>
                </div>
            </div>--%>
                <div class="layui-form-item">
                <div class="layui-input-block" style="text-align: right;margin-right: 30px;">
                    <button class="layui-btn btn-submit" lay-submit lay-filter="thisSubmit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 组件配置信息 -->
<script src="../../js/config.js"></script>
<!-- 扩展插件配置信息 -->
<script src="../../modules/config.js"></script>
<!-- 工具方法 -->
<script src="../../js/utils.js"></script>
<!-- 校验格式工具类 -->
<script src="../../js/validate.js"></script>
<!-- 地图 -->
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.AMapPositionPicker.js"></script>

<script>
    var jquery = $;

    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [{
                img: '../../img/banner.jpg'
            }],
            // 当前表数据
            detail: {
                laoshiOrderUuidNumber: '',
                laoshiId: '',
                xueshengId: '',
                yuyueTime: '',
                laoshiOrderHao: '',
        laoshiOrderYesnoTypes: '',
        laoshiOrderYesnoValue: '',
                laoshiOrderYesnoText: '',
                zixunjieguoText: '',
                laoshiOrderFile: '',
                insertTime: '',
                createTime: '',
            },

            // 级联表的
            laoshi: {},

            // 下拉框
            laoshiOrderYesnoTypesList: [],
            centerMenu: centerMenu
        },
        updated: function () {
            layui.form.render('select', 'myForm');
        },
        computed: {},
        methods: {
            jump(url) {
                jump(url)
            }
        }
    })


    layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload', 'laydate', 'tinymce'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var form = layui.form;
        var upload = layui.upload;
        var laydate = layui.laydate;
        var tinymce = layui.tinymce

        // 获取轮播图 数据
        http.request('config/list', 'get', {
            page: 1,
            limit: 5
        }, function(res) {
            if (res.data.list.length > 0) {
                var swiperItemHtml = '';
                for (let item of res.data.list) {
                    if (item.value != "" && item.value != null) {
                        swiperItemHtml +=
                                '<div>' +
                                '<img class="swiper-item" src="' + item.value + '">' +
                                '</div>';
                    }
                }
                jquery('#swiper-item').html(swiperItemHtml);
                // 轮播图
                carousel.render({
                    elem: '#swiper',
                    width: swiper.width,height:swiper.height,
                    arrow: swiper.arrow,
                    anim: swiper.anim,
                    interval: swiper.interval,
                    indicator: "none"
                });
            }
        });


        vue.detail.laoshiOrderUuidNumber = new Date().getTime();
        // 级联表数据查询
        initializationlaoshi(localStorage.getItem('laoshiId'));


        // 下拉框
        // 预约状态的查询和初始化
       laoshiOrderYesnoTypesSelect();

        // 上传文件
        // 日期效验规则及格式
        dateTimePick();
        // 表单效验规则
        form.verify({
            // 正整数效验规则
            integer: [
                /^[1-9][0-9]*$/
                ,'必须是正整数'
            ]
            // 小数效验规则
            ,double: [
                /^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/
                ,'最大整数位为6为,小数最大两位'
            ]
        });

        // session独取
        let table = localStorage.getItem("userTable");
        http.request(table+"/session", 'get', {}, function (data) {
            // 表单赋值
            //form.val("myForm", data.data);
            // data = data.data;
            for (var key in data) {
                vue.detail[table+"Id"] = data.id
            }
        });


        // 提交
        form.on('submit(thisSubmit)', function (data) {
            data = data.field;
            data["xueshengId"]= localStorage.getItem("userid");
            data["laoshiOrderYesnoTypes"]= 1;
            // 提交数据
            http.requestJson('laoshiOrder/add', 'post', data, function (res) {
                if(res.code == 0){
                    layer.msg('预约成功', {
                        time: 2000,
                        icon: 6
                    }, function () {
                        vue.jump("../laoshiOrder/list.jsp");
                        // back();
                    });

                }else{
                    layer.msg(res.msg, {
                        time: 5000,
                        icon: 5
                    });
                }
            });
            return false
        });


        // 日期框初始化
        function dateTimePick(){
            var myDate = new Date();  //获取当前时间
            /*
                ,change: function(value, date, endDate){
                    value       得到日期生成的值，如：2017-08-18
                    date        得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                    endDate     得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            */
            // 预约日期的开始时间和结束时间的效验及格式
            var yuyueTime = laydate.render({
                elem: '#yuyueTime'
	            ,type: 'date'
                ,min:myDate.toLocaleString()
            });
        }




       // 预约状态的查询
       function laoshiOrderYesnoTypesSelect() {
           //填充下拉框选项
           http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=laoshi_order_yesno_types", "GET", {}, (res) => {
               if(res.code == 0){
                   vue.laoshiOrderYesnoTypesList = res.data.list;
               }
           });
       }




        function initializationlaoshi(id){
            // 详情赋值
            http.request("laoshi/detail/" + id, 'get', {}, function (res) {
                if(res.code ==0){
                    vue.laoshi = res.data;
                }
            });
        }
    });
</script>
</body>
</html>