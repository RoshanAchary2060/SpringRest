<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<h1 style="color: red; text-align: center">Edit Tourist Page</h1>

<frm:form modelAttribute="tst">
	<table border="0" align="center" bgcolor="cyan">
		<tr>
			<td>Tourist Id ::</td>
			<td><frm:input readonly="true" path="tid"></frm:input></td>
		</tr>
		<tr>
			<td>Tourist Name ::</td>
			<td><frm:input path="name"></frm:input></td>
		</tr>
		<tr>
			<td>City ::</td>
			<td><frm:input path="city"></frm:input></td>
		</tr>
		<tr>
			<td>Budget ::</td>
			<td><frm:input path="budget"></frm:input></td>
		</tr>
		<tr>
			<td>Package Type ::</td>
			<td><frm:input path="packageType"></frm:input></td>
		</tr>
		<tr>
			<td><input type="submit" value="Edit" />
		</tr>
	</table>
</frm:form>
</html>