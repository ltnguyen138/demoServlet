<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">NCC</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">List of NCC</h3>
			<hr>
			<a href="Them-moi-khach-hang" >Create User</a>
			<br>
			<table class="table table-bordered">
				
					<tr>
						<th>Ma khach hang</th>
						<th>Ten khach hang</th>
						<th>Email khach hang</th>
						<th>Sdt khach hang</th>
					</tr>
				
				
					
					<c:forEach items="${khachhangList}" var="khachhang" >

						<tr>
							<td>${khachhang.maKH}</td>
							<td>${khachhang.tenKH}</td>
							<td>${khachhang.emailKH}</td>
							<td>${khachhang.sdtKH}</td>
							<td><a href="Cap-nhat-khach-hang?MaKH=${khachhang.maKH}">edit</a> </td>
							<td><a href="Xoa-khach-hang?MaKH=${khachhang.maKH}">delete</a> </td>
						</tr>
					</c:forEach>
					<!-- } -->
				
			</table>
		</div>
	</div>
</body>