<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ashok.it.User" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./CSS/style.css">
    <script src="./Bootstrap/js/bootstrap.bundle.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nova+Slim&display=swap" rel="stylesheet">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <link rel="icon" type="favicon" href="./MEDIA/favicon-foodie.png">
    <title>order.com</title>
</head>

<body>
    <!-- nav starts -->
    <nav class="nav-con navbar navbar-expand-lg bg-danger sticky-top">
        <div class="container">
            <a class="logo navbar-brand text-light " href="../index.html">f<span class="text-warning">oo</span>die</a>
            <ul class="menu-bar navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="home nav-link active " aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../HTML/About.html" target="_blank">AboutUs</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-danger" href="../index.html" role="button">Logout</a>
                </li>
                <form class="d-flex nav-search" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                </form>
        </div>
    </nav>
    <!-- nav end -->
    <!-- order section -->
    <%
    	
    	session = request.getSession(false);
    	User user = new User();
    %>
    <section class="container order-box-con">

        <div class="order-box">
            <h1 class="text-success order-title">Conform Your Order !</h1>
            <div class="row">
            
            <c:forEach items="${list}" var="user">
                <h3 class="col-xl-5 order-inputs">Name : ${user.name}</h3>
                <h3 class="col-xl-5 order-inputs">Mobile No : ${user.mobilenumber}</h3>
                <h3 class="col-xl-5 order-inputs">Product : ${user.item} </h3>
                <h3 class="col-xl-5 order-inputs">Quantity : ${user.qty}</h3>
                <h3 class="col-xl-5 order-inputs">Price : ${user.price}</h3>
                <h3 class="col-xl-5 order-inputs">Final Price(+&#x20B9;40) : ${user.totalPrice}</h3>
                <h3 class="col-xl-5 order-inputs">Order No : 232837</h3>
                <h3 class="col-xl-5 order-inputs">City : ${user.city}</h3>
                </c:forEach>
                <div class="input-user-order">
                    <input class="input-tag col-xl-5 order-inputs" type="text"
                        placeholder="House No,Building Name (Required)*" required>
                    <input class="input-tag col-xl-5 order-inputs" type="text"
                        placeholder="Road name,Area, Colony (Required)*" required>
                    <input class="input-tag col-xl-5 order-inputs" type="text" placeholder="Pincode (Required)*"
                        required>
                    <div class="col-xl-5 order-inputs input-radio-order">
                        <input type="radio" id="online" name="pay" value="online" checked>
                        <label for="online">Online Payment</label>
                        <input type="radio" id="cash" name="pay" value="cash">
                        <label for="cash">Cash</label>
                    </div>
                </div>

            </div>
           
             <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        Conform
    </button>
           
        </div>
        <!--end order section -->
<!-- Modal -->
    <div class="modal fade " id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-success" id="staticBackdropLabel">Order Placed Successfully</h5>
            
                </div>
                <div class="modal-body">
               
                 <img src="./MEDIA/delivery-img.png">
              
                 <h6>Your Order Will Deliver With in 30Minutes </h6>
                 <h6>Thank You.</h6>
                </div>
                <div class="modal-footer">
                    <a href="menu.html" class="btn btn-danger login-btn"> close</a>

                </div>
            </div>
        </div>
    </div>

<!-- end modal -->

    </section>
  
</body>

</html>