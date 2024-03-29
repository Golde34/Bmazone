package APIs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                + "<h3 style=\"text-align: left;\">Ch&uacute;ng t&ocirc;i đ&atilde; nhận được y&ecirc;u cầu từ&nbsp;bạn. Ch&uacute;ng t&ocirc;i khuy&ecirc;n bạn h&atilde;y đổi mật khẩu ngay khi c&oacute; thể để tr&aacute;nh qu&ecirc;n lần nữa.</h3>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td style=\"text-align: center;\" colspan=\"2\">\n"
                + "<h2>&nbsp;&nbsp;Nhấn vào đây để thay đổi mật khẩu:&nbsp;<span style=\"text-decoration: underline; color: #3366ff;\">" + msg + "</span></h2>\n"
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

    public static String tableRegis(String username, String code) {
        String colorMsg = "<div class=\"webkit\">\n"
                + "          <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"wrapper\" bgcolor=\"#FFFFFF\">\n"
                + "            <tbody><tr>\n"
                + "              <td valign=\"top\" bgcolor=\"#FFFFFF\" width=\"100%\">\n"
                + "                <table width=\"100%\" role=\"content-container\" class=\"outer\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
                + "                  <tbody><tr>\n"
                + "                    <td width=\"100%\">\n"
                + "                      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
                + "                        <tbody><tr>\n"
                + "                          <td>\n"
                + "                                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:100%; max-width:600px;\" align=\"center\">\n"
                + "                                      <tbody><tr>\n"
                + "                                        <td role=\"modules-container\" style=\"padding:0px 0px 0px 0px; color:#000000; text-align:left;\" bgcolor=\"#FFFFFF\" width=\"100%\" align=\"left\"><table class=\"module preheader preheader-hide\" role=\"module\" data-type=\"preheader\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"display: none !important; mso-hide: all; visibility: hidden; opacity: 0; color: transparent; height: 0; width: 0;\">\n"
                + "    \n"
                + "	</table>\n"
                + "	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:30px 20px 30px 20px;\" bgcolor=\"#f6f6f6\">\n"
                + "    <tbody>\n"
                + "      <tr role=\"module-content\">\n"
                + "        <td height=\"100%\" valign=\"top\">\n"
                + "          <table class=\"column\" width=\"540\" style=\"width:540px; border-spacing:0; border-collapse:collapse; margin:0px 10px 0px 10px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\">\n"
                + "            <tbody>\n"
                + "              <tr>\n"
                + "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"center\">\n"
                + "          <img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px;\" width=\"29\" alt=\"\" data-proportionally-constrained=\"true\" data-responsive=\"false\" src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8y61YaM6RhZBGYJ8t0FmKKN5xjNCztHxhFg&usqp=CAU\" height=\"27\">\n"
                + "        </td>\n"
                + "  </table>\n"
                + "  <br>\n"
                + "  <table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"27716fe9-ee64-4a64-94f9-a4f28bc172a0\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "        <td style=\"padding:0px 0px 30px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
                + "        </td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table>\n"
                + "  <table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"948e3f3f-5214-4721-a90e-625a47b1c957\" data-mc-module-version=\"2019-10-22\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "        <td style=\"padding:50px 30px 18px 30px; line-height:36px; text-align:inherit; background-color:#ffffff;\" height=\"100%\" valign=\"top\" bgcolor=\"#ffffff\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: center\"><span style=\"font-size: 43px\">Thanks for signing up, "+username+"!&nbsp;</span></div><div></div></div></td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"a10dcb57-ad22-4f4d-b765-1d427dfddb4e\" data-mc-module-version=\"2019-10-22\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "        <td style=\"padding:18px 30px 18px 30px; line-height:22px; text-align:inherit; background-color:#ffffff;\" height=\"100%\" valign=\"top\" bgcolor=\"#ffffff\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: center\"><span style=\"font-size: 18px\">Please verify your email using the code below</span></div>\n"
                + "<div style=\"font-family: inherit; text-align: center\"><span style=\"color: #ffbe00; font-size: 18px\"><strong>Thank you!&nbsp;</strong></span></div><div></div></div></td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"7770fdab-634a-4f62-a277-1c66b2646d8d\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "        <td style=\"padding:0px 0px 20px 0px;\" role=\"module-content\" bgcolor=\"#ffffff\">\n"
                + "        </td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"module\" data-role=\"module-button\" data-type=\"button\" role=\"module\" style=\"table-layout:fixed;\" width=\"100%\" data-muid=\"d050540f-4672-4f31-80d9-b395dc08abe1\">\n"
                + "      <tbody>\n"
                + "        <tr>\n"
                + "          <td align=\"center\" bgcolor=\"#ffffff\" class=\"outer-td\" style=\"padding:0px 0px 0px 0px;\">\n"
                + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"wrapper-mobile\" style=\"text-align:center;\">\n"
                + "              <tbody>\n"
                + "                <tr>\n"
                + "                <td align=\"center\" bgcolor=\"#ffbe00\" class=\"inner-td\" style=\"border-radius:6px; font-size:16px; text-align:center; background-color:inherit;\">\n"
                + "                  <p href=\"\" style=\"background-color:#ffbe00; border:1px solid #ffbe00; border-color:#ffbe00; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 40px 12px 40px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">"+code+"</p>\n"
                + "                </td>\n"
                + "                </tr>\n"
                + "              </tbody>\n"
                + "            </table>\n"
                + "          </td>\n"
                + "        </tr>\n"
                + "      </tbody>\n"
                + "    </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"7770fdab-634a-4f62-a277-1c66b2646d8d.1\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "        <td style=\"padding:0px 0px 50px 0px;\" role=\"module-content\" bgcolor=\"#ffffff\">\n"
                + "        </td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table>\n"
                + "  <table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c37cc5b7-79f4-4ac8-b825-9645974c984e\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table></td>\n"
                + "              </tr>\n"
                + "            </tbody>\n"
                + "          </table>\n"
                + "          \n"
                + "        </td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table>\n"
                + "    </table></td>\n"
                + "                                      </tr>\n"
                + "                                    </tbody>\n"
                + "									</table>\n"
                + "                          </td>\n"
                + "                        </tr>\n"
                + "                      </tbody></table>\n"
                + "                    </td>\n"
                + "                  </tr>\n"
                + "                </tbody></table>\n"
                + "              </td>\n"
                + "            </tr>\n"
                + "          </tbody></table>\n"
                + "        </div>\n";
        return colorMsg;
    }
}
