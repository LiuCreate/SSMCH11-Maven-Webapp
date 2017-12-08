<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>供应商管理页面 >> 供应商添加页面</span>
	</div>
	<div class="providerAdd">
	<fm:form action="${pageContext.request.contextPath }/user/addProvider.do" method="post" modelAttribute="provider" enctype="multipart/form-data">
  			<table>
  				<tr>
  					<td>供应商编码：</td>
  					<td><fm:input path="proCode"/> </td>
  					<td><fm:errors path="proCode"  /></td>
  				</tr>
  				<tr>
  					<td>供应商名称：</td>
  					<td><fm:input path="proName"/> </td>
  					<td><fm:errors path="proName"  /></td>
  				</tr>
  				<tr>
  					<td>联系人：</td>
  					<td><fm:input path="proContact"/> </td>
  					<td><fm:errors path="proContact"  /></td>
  				</tr>
  				
  				<tr>
  					<td>联系电话：</td>
  					<td><fm:input path="proPhone"/> </td>
  					<td><fm:errors path="proPhone"  /></td>
  				</tr>
  				<tr>
  					<td>联系地址：</td>
  					<td><fm:input path="proAddress"/> </td>
  					<td><fm:errors path="proAddress"  /></td>
  				</tr>
  				<tr>
  					<td>传真：</td>
  					<td><fm:input path="proFax"/> </td>
  					<td><fm:errors path="proFax"  /></td>
  				</tr>
  				<tr>
  					<td>描述：</td>
  					<td><fm:input path="proDesc"/> </td>
  					<td><fm:errors path="proDesc"  /></td>
  				</tr>
  				<tr>
  					<td>营业执照：</td>
  					<td>
  						<input type="file" name="photos" /><br />
  						<input type="file" name="photos" />
  					</td>
  					<td>${errors }</td>
  				</tr>
  				<tr>
  					<td colspan="3">
  						<input type="submit" value="保存">
  					</td>
  				</tr>
  			</table>
  		</fm:form>
	</div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/provideradd.js"></script>
