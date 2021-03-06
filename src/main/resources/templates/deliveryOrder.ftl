<#--<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>个人中心 提货单 </title>

    <link href="${rc.contextPath}/components/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${rc.contextPath}/components/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">
    <script src="${rc.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>


    <script src="${rc.contextPath}/components/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container" style="margin-bottom:80px; margin-top:10px">


<ol class="breadcrumb">
    <li class="active">堆场管理</li>
    <li class="active">装车信息</li>
</ol>

<div class="row">
    <div class="col-lg-6 ">



        <table class="table" data-show-header="false">
            <thead>
            <tr>
                <th colspan="4">提煤单信息</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td class="active">状态：</td>
                <td colspan="3">
                ${deliveryOrderMap.status}

                </td>
            </tr>
            <tr>
                <td class="active">提货单编号：</td>
                <td colspan="3">

                ${deliveryOrderMap.no}
                </td>
            </tr>

            <tr>
                <td class="active">下单时间：</td>
                <td colspan="3">

                ${deliveryOrderMap.createDate}
                </td>
            </tr>

                <#if deliveryOrderMap.status?? && deliveryOrderMap.status =="Valid">
                <tr>
                    <td class="active">提货密码：</td>
                    <td colspan="3"><strong>${deliveryOrderMap.accessCode!''}</strong></td>
                </tr>
                </#if>
            <tr>
                <td class="active">生产商：</td>
                <td colspan="3">${deliveryOrderMap.producerNo!''}</td>
            </tr>
            <tr>
                <td class="active">分销商：</td>
                <td colspan="3"><a href="${deliveryOrderMap.distributorUrl!''}">${deliveryOrderMap.distributorNo!}</a></td>
            </tr>

            <tr>
                <td class="active">货物：</td>
                <td><a href="${deliveryOrderMap.productUrl!''}" > ${deliveryOrderMap.productName!''}  ${deliveryOrderMap.productNo}</a></td>
            </tr>

            <tr>
                <td class="active">堆场</td>
                <td colspan="3">${deliveryOrderMap.storageNo!''}</td>
            </tr>





            <tr>
                <th>车辆信息</th>
                <th></th>
            </tr>




            <tr id="tr-id-1" class="tr-class-1">
                <td id="td-id-1" class="td-class-1 success">
                    车牌号
                </td>
                <td>${deliveryOrderMap.license!''}</td>
            </tr>
            <#--        <tr id="tr-id-1" class="tr-class-1">
                        <td id="td-id-1" class="td-class-1">
                            载重
                        </td>
                        <td>${transferMap.carryingCapacity!''}</td>
                    </tr>-->

            <#--        <tr id="tr-id-1" class="tr-class-1">
                        <td id="td-id-1" class="td-class-1 success">
                            类型
                        </td>
                        <td>${transferMap.vehicleType!'未定义'}</td>
                    </tr>-->





            <tr>
                <th>司机信息</th>
                <th></th>
            </tr>




            <tr id="tr-id-1" class="tr-class-1">
                <td id="td-id-1" class="td-class-1 success">
                    名字
                </td>
                <td><a href=""> ${deliveryOrderMap.consigneeName!'---'}</a></td>
            </tr>

            <tr id="tr-id-1" class="tr-class-1">
                <td id="td-id-1" class="td-class-1 success">
                    电话
                </td>
                <td><a href="tel:${deliveryOrderMap.consigneePhone!''}">${deliveryOrderMap.consigneePhone!''}</a>
                </td>
            </tr>

            <tr>
                <th>操作员</th>
                <th></th>
            </tr>




            <tr id="tr-id-1" class="tr-class-1">
                <td id="td-id-1" class="td-class-1 success">
                    名字
                </td>
                <td><a href=""> ${deliveryOrderMap.operatorName!'---'}</a></td>
            </tr>

            <tr id="tr-id-1" class="tr-class-1">
                <td id="td-id-1" class="td-class-1 success">
                    电话
                </td>
                <td><a href="tel:${deliveryOrderMap.operatorPhone!''}">${deliveryOrderMap.operatorPhone!''}</a>
                </td>
            </tr>

            </tbody>
        </table>



    </div>

<#if deliveryOrderMap??>

<#else>
<div class="col-lg-12">
    <form id="longitudeLatitudeForm" class="navbar-form" role="search" action="${getUrl}">
        <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <input class="input-lg" type="text" class="form-control" name="code" placeholder="" value="">
    </div>
<#--            <div class="form-group">
                <input type="text" class="form-control" name="latitude" placeholder="latitude 纬度" value="${destinationLatAndLng.bd09Lat!''}">
            </div>-->
    <button id="longitudeLatitudeFormFormBtn" type="button" class="btn btn-primary  btn-lg">提取</button>
</form>

    <script  type="text/javascript">

        $("#longitudeLatitudeFormFormBtn").click(function() {
            alert($('#longitudeLatitudeForm').serialize());
            var req = $.ajax({
                url:  $('#longitudeLatitudeForm').attr('action'),
                type: 'POST',
                data:  $('#longitudeLatitudeForm').serialize(),
            });
            req.done(function (data) {

                if (data.status) {
                    alert("成功:"+data.message);

                    window.location.href = data.url;
                } else {
                    alert(data.message);
                }
            });
        });
    </script>

</div>

</#if>
<div class="col-lg-6">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">面板标题</h3>
        </div>
        <div class="panel-body">
            <tr>
                <th>分销商账户信息</th>
                <th></th>
            </tr>
            <tr>
                <td class="active">可用余额</td>
                <td colspan="3"><a href="${deliveryOrderMap.inventoryUrl!''}">${deliveryOrderMap.advancedPaymentAmount!''}</a></td>
            </tr>
            <tr>
                <td class="active">库存</td>
                <td colspan="3"><a href="${deliveryOrderMap.distributorUrl!''}">${deliveryOrderMap.inventory!''}</a></td>
            </tr>
        </div>
    </div>


    <button id="addBtn" type="button" class="btn btn-primary btn-lg hidden"  data-toggle="modal" data-target="#addLineModal">
        录入皮重
    </button>

    <script type="text/javascript">


        function refresh() {
            $('#station-table').bootstrapTable('refresh');
        }

        function selectedRow_() {
            var row =  $('#station-table').bootstrapTable('getSelections');
            return row;
        }


        $("#editBtn").click(function() {
            var row = selectedRow_();

            if (row != '') {
                $('#addStationModal').modal();
                alert(JSON.stringify(row[0]));
                $('#addStationModalForm .companyId').val(row[0].id);

            }
        });



    </script>
    <form id="addLineModalForm"   novalidate="novalidate" action="${createUrl}">
        <input style="margin-bottom: 15px;" type="" placeholder="" class="companyId hidden" name="id" value="${deliveryOrderMap.id}"  >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group">
            <label for="username" class="control-label">基本信息</label>
            <input style="margin-bottom: 15px;" type="" placeholder="皮重" disabled class="companyId form-control input-lg" name="tareWeight" value="${deliveryOrderMap.plateNumber!''} / ${deliveryOrderMap.productName!''}"  >


            <span class="help-block"></span>
        </div>




        <div class="form-group">
            <label for="username" class="control-label">皮重</label>
            <input style="margin-bottom: 15px;" type="" placeholder="皮重" class="companyId form-control input-lg" name="tareWeight" value=""  >


            <span class="help-block"></span>
        </div>



        <button id="addLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
    </form>
    <script  type="text/javascript">

        $("#addLineModalFormBtn").click(function() {
         //   alert($('#addLineModalForm').serialize());

            var req = $.ajax({
                url:  $('#addLineModalForm').attr('action'),
                type: 'post',
                data:  $('#addLineModalForm').serialize(),
            });
            req.done(function (data) {
                if (data.status) {
                    //alert("成功:"+data.message);
                    window.location.reload(true);
                } else {
                    alert(data.message);
                }
            });
        });
    </script>
</div>


</div>
<div id="addLineModal" class="modal fade" role="dialog">
    <div id="login-overlay" class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">输入皮重</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                            <form id="addLineModalForm"   novalidate="novalidate" action="${createUrl}">
                                <input style="margin-bottom: 15px;" type="" placeholder="" class="companyId hidden" name="id" value="${deliveryOrderMap.id}"  >

                                <div class="form-group">
                                    <label for="username" class="control-label">基本信息</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="皮重" disabled class="companyId form-control input-lg" name="tareWeight" value="${deliveryOrderMap.plateNumber!''} / ${deliveryOrderMap.productName!''}"  >


                                    <span class="help-block"></span>
                                </div>




                                <div class="form-group">
                                    <label for="username" class="control-label">皮重</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="皮重" class="companyId form-control input-lg" name="tareWeight" value=""  >


                                    <span class="help-block"></span>
                                </div>


      <#--                          <div class="form-group">
                                    <label for="username" class="control-label">净重</label>
                                    <input style="margin-bottom: 15px;" type="" placeholder="Username" class="companyId form-control" name="description" value=""  >
                                    <span class="help-block"></span>
                                </div>
-->

<#--
                                <div class="form-group">
                                    <label for="username" class="control-label">位置</label>

                                    <select class="selectpicker" &lt;#&ndash;data-max-options="2" &ndash;&gt; id="departureStation" name="departureStation" class="form-control" placeholder="特征">
                                    &lt;#&ndash; <select class="form-control select2" id="userType" name="userType"  placeholder="公司类型"  multiple="multiple">&ndash;&gt;

                                    <#if stations??>
                                        <#list stations as feature>
                                            <option value="${feature.id}" >${feature.id!''}--${feature.name!''}--${feature.description!''}</option>

                                        </#list>
                                    </#if>

                                    </select>



                                    </select>
                                    <span class="help-block"></span>
                                </div>

    -->

                                <button id="addLineModalFormBtn"  type="buttom" data-dismiss="modal"   class="btn btn-primary ">确定</button>
                            </form>
                            <script  type="text/javascript">

                                $("#addLineModalFormBtn").click(function() {
                                    alert($('#addLineModalForm').serialize());

                                    var req = $.ajax({
                                        url:  $('#addLineModalForm').attr('action'),
                                        type: 'post',
                                        data:  $('#addLineModalForm').serialize(),
                                    });
                                    req.done(function (data) {
                                        if (data.status) {
                                            alert("成功:"+data.message);
                                            window.location.reload(true);
                                        } else {
                                            alert(data.message);
                                        }
                                    });
                                });
                            </script>
                    </div>
                </div>




            </div>
        </div>
    </div>
</div>







<script type="text/javascript">
    function queryParams(params) {
        params.page = params.pageNumber - 1;
        params.size = params.pageSize;
        var status = $.trim($("#status").val());


        if (status) {
            params.status = status;
        }

        return params;
    }


    function handleResponse(original) {
        var res = {};
        res.rows = original.content;
        res.total = original.totalElements;

        return res;
    }




</script>
</body>
</html>