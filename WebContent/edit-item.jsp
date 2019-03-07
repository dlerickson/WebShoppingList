<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Items</title>

<script>
	function validateForm() {

		var textStore = document.getElementById('textStore');
		var textItem = document.getElementById('textItem');
		var helpMsg = "Edit. Don't delete. Goose!";

		if (textStore.value.length == 0 || textItem.value.length == 0) {
			alert(helpMsg);
			if (textStore.value.length == 0) {
				textStore.focus();
			} else {
				textItem.focus();
			}
			return false;
		}
		return true;
	}
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

p * {
	display: block;
	margin: 1em;
}

input[type=text] {
	-webkit-appearance: none;
	width: 100%;
	border: thin solid #333;
	margin: 0;
	font-family: inherit;
	font-size: 90%;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

/* this is for the those pesky invalid fields */
input:invalid {
	border-color: #900;
	background-color: #FDD;
}

input:focus:invalid {
	outline: none;
}

</style>
</head>
<body>

<form onsubmit='return validateForm()' action = "editItemServlet" method="post">
	<p>
	<label for="store">Store: <input type ="text" id="textStore" name = "store" value="${itemToEdit.store}">
	</label></p>
	<p>
	<label for="item">Item: <input type = "text" id="textItem" name = "item" value= "${itemToEdit.item}">
	</label></p>
	<p>
	<input type = "hidden" name = "id" value="${itemToEdit.id}">
	</p>
	<p>
	<input type = "submit" value="Save Edited Item">
	</p>
</form>

</body>
</html>