<body>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/header.jspf"%>
	<div class="container">
	  <h2>Welcome ${name}</h2>
     <h3>Your Todos</h3>
     			<table class="table">
     				<thead>
     					<tr>
     						<th>Description</th>
     						<th>Target Date</th>
     						<th>Is Done?</th>
     					</tr>
     				</thead>
     				<tbody>
     					<c:forEach items="${todos}" var="todo">
     						<tr>
     							<td>${todo.description}</td>
     							<td>${todo.targetDate}</td>
     							<td>${todo.complete}</td>
     							<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
     							<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
     						</tr>
     					</c:forEach>
     				</tbody>
     			</table>

     			<a href="add-todo" class="btn btn-success">Add Todo</a>
     		</div>
	</body>

</html>