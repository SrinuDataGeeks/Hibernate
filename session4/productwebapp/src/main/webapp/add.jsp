<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="cssforsave.css" rel="stylesheet" >
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container register-form">
			<form action="./add" method="post" >
			
            <div class="form">
                <div class="note">
                    <p>Product Add.</p>
                </div>

                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Prodcut ID"   value="${product.productId}" name="productId"/>
                                <strong><font color="red">${idExits}</font></strong>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Product Name" value="${product.productName}" name="productName"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Product Price" value="${product.productPrice}" name="productPrice"/>
                            </div>
                            
                        </div>
                    </div>
                    <button type="submit" class="btnSubmit">Add</button>
                </div>
            </div>
            </form>
        </div>