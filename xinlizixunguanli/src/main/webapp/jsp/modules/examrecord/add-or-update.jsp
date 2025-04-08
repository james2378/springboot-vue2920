<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑考试记录表</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">考试记录表管理</li>
                        <li class="breadcrumb-item active">编辑考试记录表</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">考试记录表信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa exampaper">
                                        <label>试卷表</label>
                                        <div>
                                            <select style="width: 450px" id="exampaperSelect" name="exampaperSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 exampaper">
                                        <label>试卷名称</label>
                                        <input style="width: 450px" id="exampaperName" name="exampaperName" class="form-control"
                                               placeholder="试卷名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6 exampaper">
                                        <label>考试时长(分钟)</label>
                                        <input style="width: 450px" id="exampaperDate" name="exampaperDate" class="form-control"
                                               placeholder="考试时长(分钟)" readonly>
                                    </div>
                                    <div class="form-group col-md-6 exampaper">
                                        <label>试卷状态</label>
                                        <input style="width: 450px" id="exampaperValue" name="exampaperValue" class="form-control"
                                               placeholder="试卷状态" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa laoshi">
                                        <label>心理咨询老师</label>
                                        <div>
                                            <select style="width: 450px" id="laoshiSelect" name="laoshiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>心理咨询老师姓名</label>
                                        <input style="width: 450px" id="laoshiName" name="laoshiName" class="form-control"
                                               placeholder="心理咨询老师姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>身份证号</label>
                                        <input style="width: 450px" id="laoshiIdNumber" name="laoshiIdNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>手机号</label>
                                        <input style="width: 450px" id="laoshiPhone" name="laoshiPhone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>邮箱</label>
                                        <input style="width: 450px" id="laoshiEmail" name="laoshiEmail" class="form-control"
                                               placeholder="邮箱" readonly>
                                    </div>
                                    <div class="form-group col-md-6 laoshi">
                                        <label>照片</label>
                                        <img id="laoshiPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>考试编号</label>
                                        <input style="width: 450px" id="examrecordUuidNumber" name="examrecordUuidNumber" class="form-control"
                                               placeholder="考试编号">
                                    </div>
                                <input id="laoshiId" name="laoshiId" type="hidden">
                                <input id="exampaperId" name="exampaperId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>所得总分</label>
                                        <input style="width: 450px" id="totalScore" name="totalScore" class="form-control"
                                               onchange="totalScoreChickValue(this)"  placeholder="所得总分">
                                    </div>

                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "examrecord";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var exampaperOptions = [];
    var laoshiOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '心理咨询老师'){//当前登录心理咨询老师不为这个
                if($("#laoshiId") !=null){
                    var laoshiId = $("#laoshiId").val();
                    if(laoshiId == null || laoshiId =='' || laoshiId == 'null'){
                        alert("考试心理咨询老师不能为空");
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '试卷表'){//当前登录心理咨询老师不为这个
                if($("#exampaperId") !=null){
                    var exampaperId = $("#exampaperId").val();
                    if(exampaperId == null || exampaperId =='' || exampaperId == 'null'){
                        alert("所属试卷id（外键）不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("examrecord/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addexamrecord');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        <!-- 查询级联表的所有列表 -->
        function exampaperSelect() {
            //填充下拉框选项
            http("exampaper/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    exampaperOptions = res.data.list;
                }
            });
        }

        function exampaperSelectOne(id) {
            http("exampaper/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                exampaperShowImg();
                exampaperShowVideo();
                exampaperDataBind();
            }
        });
        }
        function laoshiSelect() {
            //填充下拉框选项
            http("laoshi/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    laoshiOptions = res.data.list;
                }
            });
        }

        function laoshiSelectOne(id) {
            http("laoshi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                laoshiShowImg();
                laoshiShowVideo();
                laoshiDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

        function initializationexampaperSelect() {
            var exampaperSelect = document.getElementById('exampaperSelect');
            if(exampaperSelect != null && exampaperOptions != null  && exampaperOptions.length > 0 ) {
                for (var i = 0; i < exampaperOptions.length; i++) {
                        exampaperSelect.add(new Option(exampaperOptions[i].exampaperName, exampaperOptions[i].id));
                }

                $("#exampaperSelect").change(function(e) {
                        exampaperSelectOne(e.target.value);
                });
            }

        }

        function initializationlaoshiSelect() {
            var laoshiSelect = document.getElementById('laoshiSelect');
            if(laoshiSelect != null && laoshiOptions != null  && laoshiOptions.length > 0 ) {
                for (var i = 0; i < laoshiOptions.length; i++) {
                        laoshiSelect.add(new Option(laoshiOptions[i].laoshiName, laoshiOptions[i].id));
                }

                $("#laoshiSelect").change(function(e) {
                        laoshiSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        <!--  级联表的下拉框回显  -->
            var exampaperSelect = document.getElementById("exampaperSelect");
            if(exampaperSelect != null && exampaperOptions != null  && exampaperOptions.length > 0 ) {
                for (var i = 0; i < exampaperOptions.length; i++) {
                    if (exampaperOptions[i].id == ruleForm.exampaperId) {//下拉框value对比,如果一致就赋值汉字
                        exampaperSelect.options[i+1].selected = true;
                        $("#exampaperSelect" ).selectpicker('refresh');
                    }
                }
            }
            var laoshiSelect = document.getElementById("laoshiSelect");
            if(laoshiSelect != null && laoshiOptions != null  && laoshiOptions.length > 0 ) {
                for (var i = 0; i < laoshiOptions.length; i++) {
                    if (laoshiOptions[i].id == ruleForm.laoshiId) {//下拉框value对比,如果一致就赋值汉字
                        laoshiSelect.options[i+1].selected = true;
                        $("#laoshiSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function totalScoreChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addexamrecord');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                examrecordUuidNumber: "required",
                laoshiId: "required",
                exampaperId: "required",
                totalScore: "required",
                insertTime: "required",
            },
            messages: {
                examrecordUuidNumber: "考试编号不能为空",
                laoshiId: "考试心理咨询老师不能为空",
                exampaperId: "所属试卷id（外键）不能为空",
                totalScore: "所得总分不能为空",
                insertTime: "考试时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addexamrecord = window.sessionStorage.getItem("addexamrecord");
        if (addexamrecord != null && addexamrecord != "" && addexamrecord != "null") {
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录心理咨询老师id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("examrecord/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        exampaperDataBind();
        laoshiDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#examrecordUuidNumber").val(ruleForm.examrecordUuidNumber);
        $("#laoshiId").val(ruleForm.laoshiId);
        $("#exampaperId").val(ruleForm.exampaperId);
        $("#totalScore").val(ruleForm.totalScore);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function exampaperDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#exampaperId").val(ruleForm.id);

        $("#exampaperName").val(ruleForm.exampaperName);
        $("#exampaperDate").val(ruleForm.exampaperDate);
        $("#exampaperValue").val(ruleForm.exampaperValue);
    }

    function laoshiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#laoshiId").val(ruleForm.id);

        $("#laoshiName").val(ruleForm.laoshiName);
        $("#laoshiIdNumber").val(ruleForm.laoshiIdNumber);
        $("#laoshiPhone").val(ruleForm.laoshiPhone);
        $("#laoshiEmail").val(ruleForm.laoshiEmail);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        exampaperShowImg();
        laoshiShowImg();
    }


    <!--  级联表的图片  -->

    function exampaperShowImg() {
    }


    function laoshiShowImg() {
        $("#laoshiPhotoImg").attr("src",ruleForm.laoshiPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        exampaperShowVideo();
        laoshiShowVideo();
    }


    <!--  级联表的视频  -->

    function exampaperShowVideo() {
    }

    function laoshiShowVideo() {
        $("#laoshiPhotoV").attr("src",ruleForm.laoshiPhoto);
    }



    $(document).ready(function () {
        //设置右上角心理咨询老师名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            exampaperSelect();
            laoshiSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationexampaperSelect();
            initializationlaoshiSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addexamrecord');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
		else if (window.sessionStorage.getItem('role') == '心理咨询老师') {
            // $(".aaaaaa").remove();
            $(".laoshi").remove();//删除当前心理咨询老师的信息
        }
        else{
            // alert("未知情况.......");
            // var replyContentUeditor = UE.getEditor('replyContentEditor');
            // replyContentUeditor.ready(function () {
            //     replyContentUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 心理咨询老师登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>