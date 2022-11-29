<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>New todo</title>
	</head>
	<body>
	<div class="container">

		Add new todo.
		<form:form method="post" modelAttribute="todo">
        			Description: <form:input type="text" path="description" required="required"/>
                    <form:errors path="description" cssClass="text-warning"/>
        			TargetDate: <form:input type="date" path="targetDate" required="required"/>
        			<form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="complete"/>
        			<input type="submit">
        </form:form>
       </div>
	</body>

</html>