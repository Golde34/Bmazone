<%-- 
    Document   : addProductSeller
    Created on : Sep 28, 2021, 2:50:50 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Add Product - Seller Dashboard </title>
        <link rel="stylesheet"  href="https://fonts.googleapis.com/css?family=Roboto:400,700"/>
        <link rel="stylesheet" href="../css/seller/font-awesome.min.css" />
        <link rel="stylesheet" href="../css/seller/jquery-ui.min.css" type="text/css" />
        <link rel="stylesheet" href="../css/seller/bootstrap.min.css" />
        <link rel="stylesheet" href="../css/seller/templatemo-style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css"> 
        -->
    </head>

    <body>
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Add Product</h2>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-6 col-lg-6 col-md-12">
                                <form action="" class="tm-edit-product-form">
                                    <div class="form-group mb-3">
                                        <label
                                            for="name"
                                            >Product Name
                                        </label>
                                        <input
                                            id="name"
                                            name="name"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="description"
                                            >Description</label
                                        >
                                        <textarea
                                            class="form-control validate"
                                            rows="3"
                                            required
                                            ></textarea>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="category"
                                            >Category</label
                                        >
                                        <select
                                            class="custom-select tm-select-accounts"
                                            id="category"
                                            >
                                            <option selected>Select category</option>
                                            <option value="1">New Arrival</option>
                                            <option value="2">Most Popular</option>
                                            <option value="3">Trending</option>
                                        </select>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="expire_date"
                                                >Release Date
                                            </label>
                                            <input
                                                id="release_date"
                                                name="expire_date"
                                                type="text"
                                                class="form-control validate"
                                                data-large-mode="true"
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="stock"
                                                >Units In Stock
                                            </label>
                                            <input
                                                id="stock"
                                                name="stock"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                    </div>

                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                <div class="tm-product-img-dummy mx-auto">
                                    <i
                                        class="fas fa-cloud-upload-alt tm-upload-icon"
                                        onclick="document.getElementById('fileInput').click();"
                                        ></i>
                                </div>
                                <div class="custom-file mt-3 mb-3">
                                    <input id="fileInput" type="file" style="display:none;" />
                                    <input
                                        type="button"
                                        class="btn btn-primary btn-block mx-auto"
                                        value="UPLOAD PRODUCT IMAGE"
                                        onclick="document.getElementById('fileInput').click();"
                                        />
                                </div>
                            </div>
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block text-uppercase">Add Product Now</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <footer class="tm-footer row tm-mt-small">
        <div class="col-12 font-weight-light">
            <p class="text-center text-white mb-0 px-4 small">
                &copy; <b>2021</b> Bmazon. 
            </p>
        </div>
    </footer> 

    <script src="../js/seller/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="../js/seller/jquery-ui.min.js"></script>
    <!-- https://jqueryui.com/download/ -->
    <script src="../js/seller/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script>
                                            $(function () {
                                                $("#release_date").datepicker();
                                            });
    </script>
</html>
