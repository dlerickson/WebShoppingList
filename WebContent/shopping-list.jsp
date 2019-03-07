<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping List</title>

<script>
	
	 function Selected() {

	 var helpMsg = "Hey! Silly! Go ahead and clicky click a button.";
	 var radios = document.getElementsByTagName('input');
	 var value;

	 for (var i = 0; i < radios.length; i++) {
	 if (radios[i].type === 'radio' && radios[i].checked) {
	 return true;
	 } else {
	 alert(helpMsg);
	 }
	 }
	 } 
	//trying something different below
	/*
	function selected() {
		var helpMsg = "Hey! Silly! Go ahead and clicky click a button.";
		var allFormElements = window.document.getElementById("formID").elements;
		var showAlert = ''

		for (i = 0; i < allFormElements.length; i++) {
			if (allFormElements[i].type == 'radio') {

				var thisRadio = allFormElements[i].name;
				var thisChecked = 'No';
				var allRadioOptions = document.getElementsByName(thisRadio);

				for (x = 0; x < allRadioOptions.length; x++) {
					if (allRadioOptions[x].checked && thisChecked == 'No') {
						thisChecked = 'Yes';
						break;
					}
				}

				var alreadySearched = showAlert.indexOf(thisRadio);

				if (thisChecked == 'No' && alreadySearched == -1) {
					showAlert = helpMsg;
				}
			}
		}

		if (showAlert != '') {
			alert(showAlert);
			return false;
		} else {
			return true;
		}
	}
	 
	 */
</script>
<style type="text/css">
body {
	font: 1em sans-serif;
	padding: 0;
	margin: 0;
}

form {
	max-width: 200px;
}

input {
	-webkit-appearance: none;
	width: 100%;
	border: thin solid #333;
	margin: 0;
	font-family: inherit;
	font-size: 90%;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}
s
</style>

</head>
<body>

	<form id="formId" method="post"
		action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}" required></td>
					<td>${currentitem.store}</td>
					<td>${currentitem.item}</td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" onclick="return selected();" value="edit" name="doThisToItem"> <input
			type="submit" onclick="return selected();" value="delete" name="doThisToItem">

	</form>
	<br>

	<a href="index.html">Add to your never ending list here...</a>

</body>
</html>