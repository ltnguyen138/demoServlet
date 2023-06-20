<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
   		<title>Quản lý hàng hóa - Cửa hàng vật tư, phân bón nông nghiệp</title>
    	<link rel="stylesheet" href="phieunhapstyle.css">
    	
	</head>
	<body>
		<div class="container">
  			<header>
    			<div class="header1">
    				<a href="#"><img src="./download14.png" alt="logo"> </a>
  				</div>
  				<div class="header2">
    				<ul>
				      <a href="#"><img src="./facebook.png" alt="logo" style="width: 60px;height: 20px;"> </a>
				      <a href="#"><img src="./instagram.png" alt="logo" style="width: 60px;height: 20px;"> </a>
				      <a href="#"><img src="./youtube.png" alt="logo" style="width: 60px;height: 20px;"> </a>
				      <a href="#"><img src="./twitter.png" alt="logo" style="width: 60px;height: 20px;"> </a>
    				</ul>  
  				</div>
  			</header>
  			<nav>
    			<div class="menu">
      				<ul>
				       <li><a href="Danh-sach-nha-cung-cap">Nhà cung cấp</a></li>
				        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
				        <li><a href="Danh-sach-phieu-nhap">Phiếu nhập</a></li>
				        <li><a href="Danh-sach-phieu-xuat">Phiếu xuất</a></li>
				        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
				        <li><a href="Danh-sach-nhan-vien">Nhân viên</a></li>
		        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
      				</ul>
    			</div>
   				<div class="search">
      				<form method="GET" action="${pageContext.request.contextPath}/Danh-sach-phieu-nhap">
      				<input type="text" placeholder="Search" name="search">
      				<input type="submit" value="Tìm kiếm" >
      				</form>
    			</div>
  			</nav>
  		<div id="main-content">
  		<div class="dangxuat">
          <ul>
          <li><a href="logout">Đăng xuất</a></li>  
  			  <li><p>${name},</p></li>
          
          </ul>
  			</div>
        	<div class="tieude">
        		<h1>DANH SÁCH PHIẾU NHẬP HÀNG</h1>
        	</div>
        	<div class="list">            
				<div class="themmoi">
					<a  href="Them-moi-phieu-nhap" >Thêm mới</a>
				</div>
				<table class="table">				
					<tr>
						<th>Mã phiếu nhập</th>
						<th>Mã nhà cung cấp</th>
						<th>Mã nhân viên</th>
						<th>Ngày lập phiếu</th>
						<th>Thành tiền</th>
					</tr>									
					<c:forEach items="${phieunhapList}" var="phieunhapList" >
					<tr>
						<td>${phieunhapList.maphieunhap}</td>
						<td>${phieunhapList.mancc}</td>
						<td>${phieunhapList.mannv}</td>
						<td>${phieunhapList.ngaylapphieu}</td>
						<td>${phieunhapList.thanhtien}</td>
						
						<td><a href="Chi-tiet-phieu-nhap?mpn=${phieunhapList.maphieunhap}">Chi tiết</a> </td>
					</tr>                     
					</c:forEach>			
				
				</table>
        	</div>     
  		</div>
	</div>
	<footer>
    	<div class="fLeft">
		     <p>Cửa Hàng Vật Tư Nông nghiệp</p>
		     <p>Địa chỉ: 123 abc, phường X, quận Y, tp.Z<br />
		     Điện thoại: 012.3456789</p>
		     <p>Email: <a href="mailto:support@hocwebchuan.com">support@vattunongnghiep.com</a></p>
		</div>
		<div class="fRight">
        	<h3>Danh mục</h3>
        	<ul>
	            <li><a href="Danh-sach-nha-cung-cap">Nhà cung cấp</a></li>
		        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
		        <li><a href="Danh-sach-phieu-nhap">Phiếu nhập</a></li>
		        <li><a href="Danh-sach-phieu-xuat">Phiếu xuất</a></li>
		        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
		        <li><a href="Danh-sach-nhan-vien">Nhân viên</a></li>
        	</ul>
       </div>   
	</footer>
</body>
</html>