<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<html> 
<head>
<title>供货商药品目录控制查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<%@ include file="/WEB-INF/jsp/base/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>

<script type="text/javascript">

var gysypmlcontrolsubmit = function(){
	_confirm('您确定要提交选择的供货状态吗?',null,
	  function(){
		var indexs = [];//删除记录的序号
		var rows = $('#gysypmllist').datagrid('getSelections');
		for(var i=0;i<rows.length;i++){
			var index=$('#gysypmllist').datagrid('getRowIndex',rows[i]);
			indexs.push(index);
		}
		if(rows.length>0){
			$("#indexs").val(indexs.join(','));
			jquerySubByFId('gysypmlcontrolForm', gysypmlcontrolsubmit_callback, null);
		}else{
			alert_warn("请选择要提交的供货状态");
		}
		
	  }
	)
	
};

function gysypmlcontrolsubmit_callback(data) {
	var result = getCallbackData(data);
	_alert(result);
	gysypmlquery();
}


function ypxxinfo(id){
	var sendUrl = "${baseurl}ypml/ypxxview.action?id="+id;
	createmodalwindow("药品信息查看", 900, 500, sendUrl);
}

//工具栏

var toolbar = [ {
	id : 'gysypmladd',
	text : '提交供货状态',
	iconCls : 'icon-add',
	handler : gysypmlcontrolsubmit
	}];

var frozenColumns;

var columns = [ [{
	checkbox:true
},{
	field : 'id',
	hidden : true,
	formatter: function(value,row,index){
		return '<input type="hidden" name="gysypmlCustoms['+index+'].id" value="'+value+'" />';
	}
},{
	field : 'usergysid',
	hidden : true,
	formatter: function(value,row,index){
		return '<input type="hidden" name="gysypmlCustoms['+index+'].usergysid" value="'+row.usergysid+'" />';
	}
},{
	field : 'usergysmc',
	title : '供货企业',
	width : 80
},{
	field : 'controlmc',
	title : '供货状态',
	width : 80
},{
	field : 'control',
	title : '修改供货状态',
	width : 80,
	//select下拉框(供货商药品控制状态列表)
	formatter : function (value,row,index){
		return '<select  name="gysypmlCustoms['+index+'].control" style="width:80px">'
				+'<option value="" checked>请选择</option>'
			<c:forEach items="${controllist}" var="value">
				+'<option value="${value.dictcode}">${value.info}</option>'
			</c:forEach>
				+'</select>';
	}
},{
	field : 'advice',
	title : '审核意见',
	width : 80,
	//select下拉框(供货商药品控制状态列表)
	formatter : function (value,row,index){
		 var val;
		if(value){
			val=value;
		}else{
			val="";
		}  
		//var val = value?value:"";
		return '<input type="text" name="gysypmlCustoms['+index+'].advice" value="'+val+'" />';
	}
},{
	field : 'bm',
	title : '流水号',
	width : 60
},{
	field : 'mc',
	title : '通用名',
	width : 100
},{
	field : 'jx',
	title : '剂型',
	width : 80
},{
	field : 'gg',
	title : '规格',
	width : 100
},{
	field : 'zhxs',
	title : '转换系数',
	width : 50
},{
	field : 'scqymc',
	title : '生产企业',
	width : 150
},{
	field : 'spmc',
	title : '商品名称',
	width : 100
},{
	field : 'zbjg',
	title : '中标价',
	width : 50
},{
	field : 'jyztmc',
	title : '交易状态',
	width : 60
}
,{
	field : 'opt3',
	title : '详细',
	width : 60,
	formatter:function(value, row, index){
		return '<a href=javascript:ypxxinfo(\''+row.ypxxid+'\')>查看</a>';
	}
}]];

function initGrid(){
	$('#gysypmllist').datagrid({
		title : '供应药品列表',
		//nowrap : false,
		striped : true,
		//collapsible : true,
		url : '${baseurl}ypml/querygysypmlcontrol_result.action',
		//sortName : 'code',
		//sortOrder : 'desc',
		//remoteSort : false,
		idField : 'gysypmlid',//结果集主键，影响选中行的处理
		//frozenColumns : frozenColumns,
		columns : columns,
		pagination : true,
		rownumbers : true,
		toolbar : toolbar,
		loadMsg:"",
		pageList:[15,30,50,100],
		onClickRow : function(index, field, value) {
					$('#gysypmllist').datagrid('unselectRow', index);
				},
		//将加载成功后执行：清除选中的行
		onLoadSuccess:function(){
			$('#gysypmllist').datagrid('clearSelections');
		}
		});

	}
	$(function() {
		initGrid();
		
	});

	function gysypmlquery() {
 
		var formdata = $("#gysypmlcontrolForm").serializeJson();
		//alert(formdata);
		$('#gysypmllist').datagrid('unselectAll');
		$('#gysypmllist').datagrid('load', formdata);
	}
</script>
</HEAD>
<BODY>
<div id="ypxxquery_div">
    <form id="gysypmlcontrolForm" name="gysypmlcontrolForm" action="${baseurl}ypml/gysypmlcontrolsubmit.action" method="post">
			<input type="hidden" name="indexs" id="indexs" />
			<TABLE  class="table_search">
				<TBODY>
					<TR>
						
						<TD class="left">通用名：</td>
						<td><INPUT type="text"  name="ypxxCustom.mc" /></TD>
						<TD class="left">剂型：</TD>
						<td ><INPUT type="text" name="ypxxCustom.jx" /></td>
						<TD class="left">规格：</TD>
						<td ><INPUT type="text" name="ypxxCustom.gg" /></td>
						<TD class="left">转换系数：</TD>
						<td ><INPUT type="text" name="ypxxCustom.zhxs" /></td>
					</TR>
					<TR>
						<TD class="left">流水号：</TD>
						<td ><INPUT type="text" name="ypxxCustom.bm" /></td>
						<TD class="left">生产企业：</TD>
						<td ><INPUT type="text" name="ypxxCustom.scqymc" /></td>
						<TD class="left">商品名称：</TD>
						<td ><INPUT type="text" name="ypxxCustom.spmc" /></td>
						 <td class="left">价格范围：</td>
				  		<td>
				      		<INPUT id="ypxxCustom.zbjglower" name="ypxxCustom.zbjglower" style="width:70px"/>
							至
							<INPUT id="ypxxCustom.zbjgupper" name="ypxxCustom.zbjgupper" style="width:70px"/>
							
				 		 </td>
					</tr>
					<tr>
					  
						<TD class="left">药品类别：</TD>
						<td >
							<select id="ypxxCustom.lb" name="ypxxCustom.lb" style="width:150px">
								<option value="">全部</option>
								<c:forEach items="${yplblist}" var="value">
									<option value="${value.id}">${value.info}</option>
								</c:forEach>
							</select>
						</td>
						<TD class="left">交易状态：</TD>
						<td >
							<select id="ypxxCustom.jyzt" name="ypxxCustom.jyzt" style="width:150px">
								<option value="">全部</option>
								<c:forEach items="${jyztlist}" var="value">
									<option value="${value.dictcode}">${value.info}</option>
								</c:forEach>
							</select>
							
						</td> 

						 <td class="left" height="25">供货商：</td>
				  		<td>
				  		<input type="text" name="usergysCustom.mc" id="usergysCustom.mc" />
						
				  		</td>
						<td class="left" height="25">供货状态：</td>
				  		<td>
				  		<select id="gysypmlCustom.control" name="gysypmlCustom.control" style="width:80px">
								<option value="">全部</option>
								<c:forEach items="${controllist}" var="value">
									<option value="${value.dictcode}">${value.info}</option>
								</c:forEach>
						</select>
						<a id="btn" href="#" onclick="gysypmlquery()" class="easyui-linkbutton" iconCls='icon-search'>查询</a>
				  		</td>
					</TR>
					
				</TBODY>
			</TABLE>
	   
		<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
			<TBODY>
				<TR>
					<TD>
						<table id="gysypmllist"></table>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		 </form>
	</div>


</BODY>
</HTML>

