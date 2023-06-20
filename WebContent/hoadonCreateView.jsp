<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Quản lý hàng hóa - Cửa hàng vật tư, phân bón nông nghiệp</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
  			<header>
    			<div class="header1">
    				<a href="#"><img src="./download14.png" alt="logo"> </a>
  				</div>
  				<div class="header2">
    				<ul>
      					<li><a href="Danh-sach-nha-cung-cap">Nhà cung cấp</a></li>
				        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
				        <li><a href="Danh-sach-phieu-nhap">Phiếu nhập</a></li>
				        <li><a href="Danh-sach-phieu-xuat">Phiếu xuất</a></li>
				        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
				        <li><a href="Danh-sach-nhan-vien">Nhân viên</a></li>
    				</ul>   
  				</div>
  			</header>
  			<nav>
    			<div class="menu">
      				<ul>
        				<li><a href="#">Nha cung cap</a></li>
        				<li><a href="#">Loai hang hoa</a></li>
        				<li><a href="#">Hang hoa</a></li>
        				<li><a href="#">Chi tiet hoa don</a></li>
        				<li><a href="#">Hoa don</a></li>
        				<li><a href="#">Khach hang</a></li>
     				</ul>
    			</div>
    			<div class="search">
      				<input type="search" placeholder="Search">
      				<button>TÌm kiếm</button>
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
        			<h1>THÊM MỚI HÓA ĐƠN</h1>
        		</div>
        		<div class="form">
        			<form method="POST" action="${pageContext.request.contextPath}/Them-moi-hoa-don">
        				
          					<ul>                   
          						<li><p>Mã hóa đơn</p></li>
          						<li><input type="text" name="maHD" value="${hoadon.maHD}"/> </li>                        
          						<li><p>Mã khách hàng</p></li>
					          	<li><input type="text" name="maKH" value="${hoadon.maKH}"/> </li>                          
					          	<li><p>Thành tiền </p></li>
					          	<li><input type="text" name="thanhTien" value="${hoadon.thanhTien}"/> </li>      					                 
					          	<li><p>Ngày lập hóa đơn</p></li>
					          	<li><input type="text" name="ngayLapHD" value="${hoadon.ngayLapHD}"/> </li>   
					        </ul>      
          					<ul style=" margin-top: 10px;">
						          <li style="float: left;">
						          <input type="submit" value="Luu" style="height:38px 
						          ;width: 200px;background-color:rgb(8, 101, 59);color: aliceblue; ">
						          </li>
						          <li style="float: left; line-height:38px;margin-left: 50px;
						           background-color: rgb(8, 101, 59);padding:0px 70px 0px 70px ;">
						          <a href="Danh-sach-hoa-don" >Quay lại</a>
						          </li>
          					</ul>                              		    
          				</form>
        			</div>    
  				</div>
			</div>
  		<footer>
    		<div class="fLeft">
	      		<p>Cửa Hàng Vật Tư Nông Nghiệp</p>
	      		<p>Địa chỉ: 123 abc, phường X, quận Y, tp.Z<br />
	      		Điện thoại: 012.3456789</p>
	      		<p>Email: <a href="mailto:support@hocwebchuan.com">support@vattunongnghiep.com</a></p>
	      		<!-- / class fLeft --></div>
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
</html>