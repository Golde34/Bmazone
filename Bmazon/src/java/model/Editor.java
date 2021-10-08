/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AD
 */
public class Editor {

    public static String addTable(String msg) {
        String colorMsg = "<table style=\"height: 108px;\" border=\"1\" width=\"487\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td style=\"text-align: center;\" colspan=\"2\">\n"
                + "<h1><span style=\"color: #ff0000;\">Ch&uacute;c mừng bạn đ&atilde; c&oacute; mật khẩu mới</span></h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td style=\"text-align: center;\" colspan=\"2\">\n"
                + "<h3 style=\"text-align: left;\">Ch&uacute;ng t&ocirc;i đ&atilde; thay đổi mật khẩu của bạn c&aacute;ch đ&acirc;y v&agrave;i ph&uacute;t. Ch&uacute;ng t&ocirc;i đ&atilde; nhận được y&ecirc;u cầu từ&nbsp;bạn.</h3>\n"
                + "<h3 style=\"text-align: left;\">Ch&uacute;ng t&ocirc;i khuy&ecirc;n bạn h&atilde;y đổi mật khẩu ngay khi c&oacute; thể để tr&aacute;nh qu&ecirc;n lần nữa. Trong trường hợp c&oacute; dấu hiệu spam ch&uacute;ng t&ocirc;i sẽ kh&oacute;a t&agrave;i khoản của bạn&nbsp;</h3>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td style=\"text-align: center;\" colspan=\"2\">\n"
                + "<h2>&nbsp;&nbsp;Mật khẩu mới của bạn l&agrave;:&nbsp;<span style=\"text-decoration: underline; color: #3366ff;\">" + msg + "</span></h2>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td style=\"text-align: center;\" colspan=\"2\">\n"
                + "<h2><span style=\"color: #ff0000;\">Cảm ơn bạn đ&atilde; xem thư n&agrave;y!</span><img src=\"https://lh4.googleusercontent.com/proxy/tfkQ53gpD3wFwSVgTY6FcCH2MVBhyJp-rKUsY0w4S0MoHGW9cPj6AP1hJMq5cVSRE9IUO8UfLxBG2YvW6Q=s0-d\" alt=\"giai-ma.com\" width=\"460\" height=\"306\" /></h2>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>";
        return colorMsg;
    }
}
