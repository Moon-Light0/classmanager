<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>班级信息管理</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="head.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                学生管理
                <small>全部学生信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-pie-chart"></i> 班级管理</a></li>
                <li><a href="all-order-manage-list.html">学生管理</a></li>
                <li class="active">全部学生信息</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#studentAddModal" id="student_add_btn"><i class="fa fa-file-o"></i> 新建</button>
                                    <button type="button" class="btn btn-default" title="删除" id="student_delete_btn"><i class="fa fa-trash-o"></i> 删除</button>
                                    <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="form-group form-inline">
                                <input id="student_input" type="text" class="form-control" placeholder="搜索">
                                <span><button id="student_select_btn" type="button" class="btn btn-info">Go!</button></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="">
                                    <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">学号</th>
                                <th>姓名</th>
                                <th class="sorting">班级</th>
                                <th class="sorting">专业</th>
                                <th class="sorting">晚自习缺勤次数</th>
                                <th class="sorting">请假次数</th>
                                <th class="sorting">
                                    奖&惩次数</th>
                                <th class="text-center">详情</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--                            <c:forEach var="student" items="${pageInfo.list}">--%>
                            <%--                                <tr>--%>
                            <%--                                    <td><input name="ids" type="checkbox" ></td>--%>
                            <%--                                    <td>${student.stuNo}</td>--%>
                            <%--                                    <td>aaa</td>--%>
                            <%--                                    <td>aaa</td>--%>
                            <%--                                    <td><textarea style="width: 100%;border: whitesmoke ;" readonly="readonly">${student.detail}</textarea></td>--%>
                            <%--                                    <td>${student.studentDateStr}</td>--%>
                            <%--                                    <td align="center">--%>
                            <%--                                       <c:if test="${student.isGood == 1}">--%>
                            <%--                                           <i class="glyphicon glyphicon-ok" style="color: #00e765 " >--%>
                            <%--                                       </c:if>--%>
                            <%--                                       <c:if test="${student.isGood != 1}">--%>
                            <%--                                           <i class="glyphicon glyphicon-remove" style="color: #ed5565" >--%>
                            <%--                                       </c:if>--%>
                            <%--                                    </td>--%>
                            <%--                                    <td class="text-center">--%>
                            <%--                                        <button type="button" class="btn bg-olive btn-xs" onclick='location.href="all-order-manage-edit.html"'>编辑</button>--%>
                            <%--                                    </td>--%>
                            <%--                                </tr>--%>
                            <%--                            </c:forEach>--%>
                            </tbody>
                        </table>
                        <!--数据列表/-->
                    </div>
                    <!-- 数据表格 /-->
                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <form id="pageForm" method="post">
                        <div class="pull-left">
                            <div class="form-group form-inline" id="pageData">
                                <span id="page_span"></span>
                                <select class="form-control" id="pageSize_select">
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="15">20</option>
                                </select>
                                <span></span>
                            </div>
                        </div>

                        <div class="box-tools pull-right" style="color: #00e765">
                            <ul class="pagination" id="page_ul">
                            </ul>
                        </div>
                    </form>
                </div>
                <!-- /.box-footer-->
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="foot.jsp"></jsp:include>
    <!-- 底部导航 /-->

</div>

<!-- 模态框，用于增加操作 Modal-->
<div class="modal fade" id="studentAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">学生添加</h4>
            </div>
            <div class="modal-body">
                <!-- 添加表单 -->
                <form class="form-horizontal" id="studentAddForm" method="post">
                    <div class="form-group">
                        <label for="stuNo_add_input" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-9">
                            <input type="text" name="stuNo" class="form-control" id="stuNo_add_input" placeholder="学号">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stuName_add_input" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="stuName_add_input" >
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stuPwd_add_input" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="stuPwd_add_input" >
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="speciality_add_input" class="col-sm-2 control-label">专业</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="speciality_add_input" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btn-close" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="student_save_btn" onclick="save('')">保存</button>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    var PageSize = 5;//当前每页数量
    var PageNum = 1; //当前页码
    $(function () {
        $.ajax({
            url : "../student/findAll",
            type : "post",
            success : function(result){
                var pageinfo = JSON.parse(result);
                write(pageinfo.list);
                // //展示分页栏
                writePages(pageinfo);
                console.log(pageinfo)
            }
        })
        // 选择框
        $(".select2").select2();

        //新增按钮
        $("#student_add_btn").click(function () {
            $("#studentAddModal h4").text("学生添加")
            $("form input").val("");
            $("form input").each(function () {
                $(this).next("span").text("");
                $(this).parent().removeClass("has-error has-success")
            })
        })

        //键盘esc可关闭模态框
        $('#studentAddModal').modal({
            keyboard: true,
            backdrop:false,
            show : false
        })

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });

        // 全选操作
        $("#selall").click(function() {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });

        // datetime picker
        $('#dateTimePicker').datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            autoclose: true,
            todayBtn: true,
            language: 'zh-CN',
        }) ;

        $("form input").on("focus",function () {
            if($(this).parent().hasClass("has-success")){
                return;
            }
            $(this).val("");
            $(this).next("span").text("");
            $(this).parent().removeClass("has-error").addClass("has-success");
        })
        //登录密码input失去焦点验证
        inputBlur("#stuPwd_add_input",'^[a-z0-9_-]{6,18}$',"密码应为6-18位数字或英文");
        //学生姓名input失去焦点验证
        inputBlur("#stuName_add_input","^[\u2E80-\u9FFF]{2,4}$","姓名应为2-4位中文汉字");
        inputBlur("#speciality_add_input","","专业不可为空");
        //学号input失去焦点验证
        $("#stuNo_add_input").blur(function () {
            var stuNo = $(this).val();
            var parent = $(this).parent();
            //验证学号是否正确
            var regex = /^\d{12}$/;
            if(!regex.test(stuNo) || stuNo === "" ){
                parent.removeClass("has-success").addClass("has-error");
                $(this).val("");
                $(this).next("span").text("学号应为12位数字")
            }else{
                //发送请求查询学号
                $.ajax({
                    url : "${pageContext.request.contextPath}/student/findIsStuNoExist?stuNo="+stuNo,
                    type : "get",
                    success : function (result) {
                        console.log(result)
                        if(result == false){
                            parent.removeClass("has-success").addClass("has-error");
                            parent.find("span").text("学号已存在");
                        }else{
                            parent.removeClass("has-error").addClass("has-success");
                            $(this).next("span").text("");
                        }
                    },
                    error : function(result){
                        jumpByStatus(data)
                    }
                });
            }
        });
        //删除按钮
        $("#student_delete_btn").click(function (){
            var checkbox = $("input[name='ids']:checked");
            var students = "";
            for (var i = 0; i < checkbox.length; i++) {
                students += checkbox.eq(i).parent().parent().parent().children().eq(1).text()+',';
            }
            if(students != ""){
                var r = confirm("确定删除？");
                if(r){
                    $.ajax({
                        url : "${pageContext.request.contextPath}/student/removeStudents?students="+students.substring(0,students.length-1),
                        type : "get",
                        success : function (result){
                            if(result){
                                alert("删除成功,"+checkbox.length+"条记录");
                                getPage(PageSize,PageNum);
                            }
                        },
                        error : function (data) {
                            jumpByStatus(data);
                        }
                    });
                }
            }else{
                alert("请先选中一条记录！");
            }
        });

        // 搜索按钮
        $("#student_select_btn").click(function () {
            $("#dataList tbody").empty();
            var str = $("#student_input").val();
            if(str != ""){
                var regex = /^[1-9]\d*$/;
                if(regex.test(str)){
                    //根据学号查找
                    $.ajax({
                        url : "../student/findByStuNo2?stuNo="+str,
                        type: "get",
                        async : "false",
                        success : function (result) {
                            //渲染数据
                            if(result === ""){
                                return ;
                            }
                            var data = JSON.parse(result);
                            write(data.list);
                            writePages(data)
                        }
                    });
                }else{
                    //根据姓名查找
                }
            }
        });

        //每页数量下拉框改变事件
        $("#pageSize_select").change(function () {
            var pageSize = $(this).find("option:selected").val();
            getPage(pageSize,0);
        })
    });
    //显示列表数据，编辑按钮点击事件
    function write(obj){
        $("#dataList tbody").empty();
        $.each(obj,function (index,item) {
            var isGoods = item.isGood === 1? "#00e765":"#ed5565";
            var tubiao = item.isGood === 1? "ok":"remove";
            var data = '  <tr><td><input name="ids" type="checkbox" ></td>' +
                '            <td>'+ item.stuNo +'</td>' +
                '            <td>'+ item.stuName+'</td>' +
                '             <td>'+ item.classes+'</td>' +
                '            <td>'+item.speciality+'</td>' +
                '            <td>'+ item.notComeDates.length+'</td>' +
                '            <td>'+ item.vacations.length+'</td>' +
                '            <td align="center">'+ item.rewards.length +'</td>' +
                '             <td class="text-center">'+
                '                  <button type="button" class="edit btn bg-olive btn-xs" >晚自习</button>' +
                '                  <button type="button" class="edit btn bg-olive btn-xs" >请假</button>' +
                '                  <button type="button" class="edit btn bg-olive btn-xs" >奖惩</button>' +
                '             </td></tr>';
            $("#dataList tbody").append(data);
            // 列表按钮 onclick='location.href="all-order-manage-edit.html"'
            $("#dataList td input[type='checkbox']").iCheck({
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });

            //编辑按钮点击事件
            $(".edit").off("click").on("click",function(){
                var rewardDate =  $(this).parent().parent().children().eq(-3).text();
                $("#studentAddModal").modal("show");
                //根据时间主键查找数据并显示，只可修改奖项或处分和详细介绍
                $.ajax({
                    url : "../student/findByRewardDate",
                    type : "post",
                    data : {rewardDate :  new Date(rewardDate)},
                    success : function (result) {
                        var student = JSON.parse(result);
                        $("#studentAddModal h4").text("奖惩修改")
                        $("[name='stuNo']").val(student.stuNo).attr("readOnly","readOnly");
                        $("#stuName_add_input").val(student.student.stuName);
                        $("[name='isGood']").eq(student.isGood==0?1:0).attr("checked",true);
                        $("[name='rewardDate']").val(student.rewardDateStr);
                        $("[name='detail']").val(student.detail);
                        $("#student_save_btn").click(function () {
                            save("edit")
                        })
                    },
                    error : function (data){
                        jumpByStatus(data)
                    }
                })

            })

        })
    }
    //显示分页数据
    function writePages(pageInfo) {
        var pageData = $("#page_span");
        $("#pageData").find("span").empty();
        var data = '总共 '+pageInfo.pages+' 页，共 '+pageInfo.total+' 条数据。 每页' ;
        pageData.append(data);
        $("#pageSize_select+span").append("条");
        var pages = $("#page_ul");
        pages.empty();
        var pageNum = parseInt(pageInfo.pageNum);
        var pageSize = parseInt(pageInfo.pageSize);
        var first = $("<li onclick='getPage("+pageSize+",1)'><a href='#' aria-label='Previous'>首页</a></li>");
        var pre = $("<li onclick='getPage("+ pageSize +"," + (pageNum-1) +")'><a href='#' ><<</a></li>");
        if(pageNum < 2){
            first.addClass("disabled");
            pre.addClass("disabled");
        }
        pages.append(first).append(pre);
        $.each(pageInfo.navigatepageNums,function (index,item) {
            var li = $("<li></li>");
            li.attr("onclick","getPage("+pageSize+","+item+")").append("<a href='#'>"+item+"</a>");
            if(pageNum === item){
                li.addClass("active");
            }
            pages.append(li);
        })
        var next = $("<li onclick='getPage("+pageSize+","+pageNum+1+")'><a href='#' >>></a></li>");
        var last = $("<li onclick='getPage("+pageSize+","+pageInfo.total+")'><a href='#'>末页</a></li>");
        if(pageNum >= parseInt(pageInfo.pages )){
            next.addClass("disabled");
            last.addClass("disabled");
        }
        pages.append(next).append(last) ;
    }
    //跳转页面（pageNum,页码） || （pageSize,每页数量）
    function getPage(pageSize,pageNum){
        $.ajax({
            url : "../student/findAll",
            type : "get",
            data : {pageSize : pageSize,pageNum : pageNum},
            async : "false",
            success : function (result) {
                var pageinfo = JSON.parse(result);
                write(pageinfo.list);
                //展示分页栏
                writePages(pageinfo);
                PageSize = pageinfo.pageSize;
                PageNum = pageinfo.pageNum;
            },
            error : function(data){
                jumpByStatus(data);
            }
        })
    }
    //保存按钮，添加或者修改
    function save(obj) {
        if(obj === "edit"){
            alert("edit");
            var j = {
                stuNo : $("[name='stuNo']").val(),
                isGood : parseInt($('input[name="isGood"]:checked').val()),
                rewardDate : new Date($("[name='rewardDate']").val()),
                detail : $("[name='detail']").val()
            }
            $.ajax({
                url : "../student/update",
                type : "post",
                data : JSON.stringify(j),
                contentType : "application/json;charset=utf-8",
                success : function (result) {
                    //关闭模态框
                    $('#studentAddModal').modal('hide');
                    //跳转到当前页展示新数据
                    getPage(PageSize,PageNum);
                },
                error : function (data) {
                    jumpByStatus(data);
                }
            })
            return;
        }
        if($("#stuNo_add_input").parent().hasClass("has-success")
            &&$("#stuName_add_input").val()!="" ){ //如果有这个class则发送post请求提交数据
            var j = {
                stuNo : $("#stuNo_add_input").val(),
                stuName : $("#stuName_add_input").val(),
                stuPwd : $("#stuPwd_add_input").val(),
                speciality : $("#speciality_add_input").val()
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/student/add",
                type : "post",
                dataType : "json",
                contentType : "application/json;charset:utf-8",
                data : JSON.stringify(j),
                success : function (result) {
                    //关闭模态框
                    $('#studentAddModal').modal('hide');
                    //跳转到最后一页展示新数据
                    getPage(5,9999);
                },
                error : function () {
                    location.href = "../error.jsp";
                }
            });
        }else{//找不到学号
        }
    }

    //错误，以及权限不足跳转
    function jumpByStatus(data){
        if(data.status === 403){
            alert("访问权限不足！");
        }else if(data.status === 404){
            window.location.href = "${pageContext.request.contextPath}/error.jsp";
        }
    }

    function inputBlur(input,reg,msg){
        $(input).blur(function () {
            var obj = $(input);
            var parent = $(input).parent();
            //验证学号是否正确
            var regex = new RegExp(reg);
            if(obj.val() != "" && regex.test(obj.val())){
                parent.removeClass("has-error").addClass("has-success");
                obj.next("span").text("");
            }else{
                parent.removeClass("has-success").addClass("has-error");
                obj.val("");
                obj.next("span").text(msg)
            }
        });
    }

</script>
</body>

</html>
<!---->