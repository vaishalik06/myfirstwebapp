
	<body>
	<%@ include file="common/navigation.jspf"%>
	<%@ include file="common/header.jspf"%>
	<div class="container">

		<h2> Enter Todo Details</h2>
		<form:form method="post" modelAttribute="todo">
        		<fieldset class="mb-3">
                	<form:label path="description">Description</form:label>
                	<form:input type="text" path="description" required="required"/>
                	<form:errors path="description" cssClass="text-warning"/>
                </fieldset>
                <fieldset class="mb-3">
                	<form:label path="targetDate">Target Date</form:label>
                	<form:input type="date" path="targetDate" required="required"/>
                	<form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>
        			<form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="complete"/>
        			<input type="submit" class="btn btn-success"/>
        </form:form>
       </div>
	</body>

</html>