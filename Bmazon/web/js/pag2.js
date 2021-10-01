$(function () {
    var pageSize = 20; // Hiển thị 6 sản phẩm trên 1 trang
    showPage = function (page) {
        $(".product-type-simple").hide();
        $(".product-type-simple").each(function (n) {
            if (n < pageSize * page && n >= pageSize * (page - 1))
                $(this).show();
        });
    }
    showPage(1);

    ///** Cần truyền giá trị vào đây **///
    var totalRows = document.getElementById("totalnumber").value;
    console.log(totalRows);// Tổng số sản phẩm hiển thị
    var btnPage = 3; // Số nút bấm hiển thị di chuyển trang
    var iTotalPages = Math.ceil(totalRows / pageSize);

    var obj = $('#pagination').twbsPagination({
        totalPages: iTotalPages,
        visiblePages: btnPage,
        onPageClick: function (event, page) {
            console.info(page);
            showPage(page);
            document.getElementById("a").innerHTML = "Trang " + page;
        }
    });
    console.info(obj.data());

});
function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}