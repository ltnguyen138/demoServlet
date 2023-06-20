<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
   		<title>Quản lý hàng hóa - Cửa hàng vật tư, phân bón nông nghiệp</title>
    	<link rel="stylesheet" href="style1.css">
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
      				</ul>
    			</div>
   				<div class="search">
      				<input type="search" placeholder="Search">
      				<button>Tìm kiếm</button>
    			</div>
  			</nav>
  		<div id="main-content">
  		<div class="dangxuat">
          <ul>
          <li><a href="logout">Đăng xuất</a></li>  
  			  <li><p>Admin,</p></li>
          
          </ul>
  			</div>
        	<div class="tieude">
        		<h1>DANH SÁCH HÓA ĐƠN</h1>
        	</div>
        	<div class="list">            
				<div class="themmoi">
					<a  href="Them-moi-hoa-don" >Thêm mới</a>
				</div>
				<table class="table">				
					<tr>
						<th>Mã hóa đơn</th>
						<th>Mã khách hàng</th>
						<th>Thành tiền</th>
						<th>Ngày lạp hóa đơn</th>
					</tr>									
					<c:forEach items="${hoadonList}" var="hoadon" >
					<tr>
						<td>${hoadon.maHD}</td>
						<td>${hoadon.maKH}</td>
						<td>${hoadon.thanhTien}</td>
						<td>${hoadon.ngayLapHD}</td>
						<td><a href="Cap-nhat-hoa-don?MaHD=${hoadon.maHD}">Sửa</a> </td>
						<td><a href="Xoa-hoa-don?MaHD=${hoadon.maHD}">Xóa</a> </td>
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
		        <li><a href="Danh-sach-loai-hang-hoa">Loại hàng hóa</a></li>
		        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
		        <li><a href="Danh-sach-chi-tiet-hoa-don">Chi tiết hóa đơn</a></li>
		        <li><a href="Danh-sach-hoa-don">Hóa đơn</a></li>
		        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
        	</ul>
       </div>   
	</footer>
</body>
</html>