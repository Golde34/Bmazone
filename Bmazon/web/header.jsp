<%@page import="entity.Gallery"%>
<%@page import="entity.User"%>
<%@page import="model.DBConnection"%>
<%@page import="model.DAOGallery"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 9 ]> <html lang="vi" class="ie9 loading-site no-js"> <![endif]-->
<!--[if IE 8 ]> <html lang="vi" class="ie8 loading-site no-js"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="vi" class="loading-site no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />

        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

        <link rel="profile" href="https://gmpg.org/xfn/11" />
        <link rel="pingback" href="http://mauweb.monamedia.net/lazada/xmlrpc.php" />

        <script>(function(html){html.className = html.className.replace(/\bno-js\b/, 'js')})(document.documentElement);</script>
        <title>BMAZON</title>
        <link rel='dns-prefetch' href='//mauweb.monamedia.net' />
        <link rel='dns-prefetch' href='//s.w.org' />
        <link rel="alternate" type="application/rss+xml" title="Dòng thông tin Lazada &raquo;" href="http://mauweb.monamedia.net/lazada/feed/" />
        <link rel="alternate" type="application/rss+xml" title="Dòng phản hồi Lazada &raquo;" href="http://mauweb.monamedia.net/lazada/comments/feed/" />
        <script type="text/javascript">
            window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.3\/72x72\/", "ext":".png", "svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.3\/svg\/", "svgExt":".svg", "source":{"concatemoji":"http:\/\/mauweb.monamedia.net\/lazada\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.8.14"}};
            !function(a, b, c){function d(a){var b, c, d, e, f = String.fromCharCode; if (!k || !k.fillText)return!1; switch (k.clearRect(0, 0, j.width, j.height), k.textBaseline = "top", k.font = "600 32px Arial", a){case"flag":return k.fillText(f(55356, 56826, 55356, 56819), 0, 0), b = j.toDataURL(), k.clearRect(0, 0, j.width, j.height), k.fillText(f(55356, 56826, 8203, 55356, 56819), 0, 0), c = j.toDataURL(), b !== c && (k.clearRect(0, 0, j.width, j.height), k.fillText(f(55356, 57332, 56128, 56423, 56128, 56418, 56128, 56421, 56128, 56430, 56128, 56423, 56128, 56447), 0, 0), b = j.toDataURL(), k.clearRect(0, 0, j.width, j.height), k.fillText(f(55356, 57332, 8203, 56128, 56423, 8203, 56128, 56418, 8203, 56128, 56421, 8203, 56128, 56430, 8203, 56128, 56423, 8203, 56128, 56447), 0, 0), c = j.toDataURL(), b !== c); case"emoji4":return k.fillText(f(55358, 56794, 8205, 9794, 65039), 0, 0), d = j.toDataURL(), k.clearRect(0, 0, j.width, j.height), k.fillText(f(55358, 56794, 8203, 9794, 65039), 0, 0), e = j.toDataURL(), d !== e}return!1}function e(a){var c = b.createElement("script"); c.src = a, c.defer = c.type = "text/javascript", b.getElementsByTagName("head")[0].appendChild(c)}var f, g, h, i, j = b.createElement("canvas"), k = j.getContext && j.getContext("2d"); for (i = Array("flag", "emoji4"), c.supports = {everything:!0, everythingExceptFlag:!0}, h = 0; h < i.length; h++)c.supports[i[h]] = d(i[h]), c.supports.everything = c.supports.everything && c.supports[i[h]], "flag" !== i[h] && (c.supports.everythingExceptFlag = c.supports.everythingExceptFlag && c.supports[i[h]]); c.supports.everythingExceptFlag = c.supports.everythingExceptFlag && !c.supports.flag, c.DOMReady = !1, c.readyCallback = function(){c.DOMReady = !0}, c.supports.everything || (g = function(){c.readyCallback()}, b.addEventListener?(b.addEventListener("DOMContentLoaded", g, !1), a.addEventListener("load", g, !1)):(a.attachEvent("onload", g), b.attachEvent("onreadystatechange", function(){"complete" === b.readyState && c.readyCallback()})), f = c.source || {}, f.concatemoji?e(f.concatemoji):f.wpemoji && f.twemoji && (e(f.twemoji), e(f.wpemoji)))}(window, document, window._wpemojiSettings);
        </script>
        <style type="text/css">
            img.wp-smiley,
            img.emoji {
                display: inline !important;
                border: none !important;
                box-shadow: none !important;
                height: 1em !important;
                width: 1em !important;
                margin: 0 .07em !important;
                vertical-align: -0.1em !important;
                background: none !important;
                padding: 0 !important;
            }
        </style>
        <link rel='stylesheet' id='contact-form-7-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=4.9.1' type='text/css' media='all' />
        <link rel='stylesheet' id='menu-image-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/menu-image/menu-image.css?ver=1.1' type='text/css' media='all' />
        <link rel='stylesheet' id='woof-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/css/front.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='chosen-drop-down-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/chosen/chosen.min.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_by_text_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/by_text/css/by_text.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_color_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/color/css/html_types/color.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_label_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/label/css/html_types/label.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_select_hierarchy_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_hierarchy/css/html_types/select_hierarchy.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_select_radio_check_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_radio_check/css/html_types/select_radio_check.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-icons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/fl-icons.css?ver=3.3' type='text/css' media='all' />
        <link rel='stylesheet' id='easy-social-share-buttons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/assets/css/default-retina/easy-social-share-buttons.css?ver=3.7.3' type='text/css' media='all' />
        <link rel='stylesheet' id='essb-cct-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/lib/modules/click-to-tweet/assets/css/styles.css?ver=3.7.3' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-main-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome.css?ver=3.4.0' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-shop-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome-shop.css?ver=3.4.0' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome-child/style.css?ver=3.4.0' type='text/css' media='all' />
        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>
        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
        <link rel='https://api.w.org/' href='http://mauweb.monamedia.net/lazada/wp-json/' />
        <link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://mauweb.monamedia.net/lazada/xmlrpc.php?rsd" />
        <link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://mauweb.monamedia.net/lazada/wp-includes/wlwmanifest.xml" /> 
        <meta name="generator" content="WordPress 4.8.14" />
        <meta name="generator" content="WooCommerce 3.2.3" />
        <link rel="canonical" href="http://mauweb.monamedia.net/lazada/" />
        <link rel='shortlink' href='http://mauweb.monamedia.net/lazada/' />
        <link rel="alternate" type="application/json+oembed" href="http://mauweb.monamedia.net/lazada/wp-json/oembed/1.0/embed?url=http%3A%2F%2Fmauweb.monamedia.net%2Flazada%2F" />
        <link rel="alternate" type="text/xml+oembed" href="http://mauweb.monamedia.net/lazada/wp-json/oembed/1.0/embed?url=http%3A%2F%2Fmauweb.monamedia.net%2Flazada%2F&#038;format=xml" />
        <style>.bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} .bg-loaded{opacity: 1;}</style><!--[if IE]><link rel="stylesheet" type="text/css" href="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css"><script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js"></script><![endif]-->    <script type="text/javascript">
            WebFontConfig = {
            google: { families: [ "Roboto:regular,regular", "Roboto:regular,regular", "Roboto:regular,regular", "Roboto:regular,regular", ] }
            };
            (function() {
            var wf = document.createElement('script');
            wf.src = 'https://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
            wf.type = 'text/javascript';
            wf.async = 'true';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(wf, s);
            })();</script>
        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
        <style type="text/css">.essb_links_list li.essb_totalcount_item .essb_t_l_big .essb_t_nb:after, .essb_links_list li.essb_totalcount_item .essb_t_r_big .essb_t_nb:after { color: #777777;content: "shares";display: block;font-size: 11px;font-weight: normal;text-align: center;text-transform: uppercase;margin-top: -5px; } .essb_links_list li.essb_totalcount_item .essb_t_l_big, .essb_links_list li.essb_totalcount_item .essb_t_r_big { text-align: center; }.essb_displayed_sidebar .essb_links_list li.essb_totalcount_item .essb_t_l_big .essb_t_nb:after, .essb_displayed_sidebar .essb_links_list li.essb_totalcount_item .essb_t_r_big .essb_t_nb:after { margin-top: 0px; } .essb_displayed_sidebar_right .essb_links_list li.essb_totalcount_item .essb_t_l_big .essb_t_nb:after, .essb_displayed_sidebar_right .essb_links_list li.essb_totalcount_item .essb_t_r_big .essb_t_nb:after { margin-top: 0px; } .essb_totalcount_item_before, .essb_totalcount_item_after { display: block !important; }.essb_totalcount_item_before .essb_totalcount, .essb_totalcount_item_after .essb_totalcount { border: 0px !important; }.essb_counter_insidebeforename { margin-right: 5px; font-weight: bold; }.essb_width_columns_1 li { width: 100%; }.essb_width_columns_1 li a { width: 92%; }.essb_width_columns_2 li { width: 49%; }.essb_width_columns_2 li a { width: 86%; }.essb_width_columns_3 li { width: 32%; }.essb_width_columns_3 li a { width: 80%; }.essb_width_columns_4 li { width: 24%; }.essb_width_columns_4 li a { width: 70%; }.essb_width_columns_5 li { width: 19.5%; }.essb_width_columns_5 li a { width: 60%; }.essb_width_columns_6 li { width: 16%; }.essb_width_columns_6 li a { width: 55%; }.essb_links li.essb_totalcount_item_before, .essb_width_columns_1 li.essb_totalcount_item_after { width: 100%; text-align: left; }.essb_network_align_center a { text-align: center; }.essb_network_align_right .essb_network_name { float: right;}</style>
        <script type="text/javascript">var essb_settings = {"ajax_url":"http:\/\/mauweb.monamedia.net\/lazada\/wp-admin\/admin-ajax.php", "essb3_nonce":"2096ea4430", "essb3_plugin_url":"http:\/\/mauweb.monamedia.net\/lazada\/wp-content\/plugins\/easy-social-share-buttons3", "essb3_facebook_total":true, "essb3_admin_ajax":false, "essb3_internal_counter":false, "essb3_stats":false, "essb3_ga":false, "essb3_ga_mode":"simple", "essb3_counter_button_min":0, "essb3_counter_total_min":0, "blog_url":"http:\/\/mauweb.monamedia.net\/lazada\/", "ajax_type":"wp", "essb3_postfloat_stay":false, "essb3_no_counter_mailprint":false, "essb3_single_ajax":false, "twitter_counter":"self", "post_id":16};</script><style id="custom-css" type="text/css">:root {--primary-color: #FF531D;}/* Site Width */.header-main{height: 75px}#logo img{max-height: 75px}#logo{width:124px;}.header-bottom{min-height: 10px}.header-top{min-height: 25px}.transparent .header-main{height: 265px}.transparent #logo img{max-height: 265px}.has-transparent + .page-title:first-of-type,.has-transparent + #main > .page-title,.has-transparent + #main > div > .page-title,.has-transparent + #main .page-header-wrapper:first-of-type .page-title{padding-top: 345px;}.transparent .header-wrapper{background-color: #FFFFFF!important;}.transparent .top-divider{display: none;}.header.show-on-scroll,.stuck .header-main{height:70px!important}.stuck #logo img{max-height: 70px!important}.search-form{ width: 72%;}.header-bg-color, .header-wrapper {background-color: #183544}.header-bottom {background-color: #183544}@media (max-width: 549px) {.header-main{height: 70px}#logo img{max-height: 70px}}.nav-dropdown{font-size:100%}.header-top{background-color:#11252F!important;}/* Color */.accordion-title.active, .has-icon-bg .icon .icon-inner,.logo a, .primary.is-underline, .primary.is-link, .badge-outline .badge-inner, .nav-outline > li.active> a,.nav-outline >li.active > a, .cart-icon strong,[data-color='primary'], .is-outline.primary{color: #FF531D;}/* Color !important */[data-text-color="primary"]{color: #FF531D!important;}/* Background */.scroll-to-bullets a,.featured-title, .label-new.menu-item > a:after, .nav-pagination > li > .current,.nav-pagination > li > span:hover,.nav-pagination > li > a:hover,.has-hover:hover .badge-outline .badge-inner,button[type="submit"], .button.wc-forward:not(.checkout):not(.checkout-button), .button.submit-button, .button.primary:not(.is-outline),.featured-table .title,.is-outline:hover, .has-icon:hover .icon-label,.nav-dropdown-bold .nav-column li > a:hover, .nav-dropdown.nav-dropdown-bold > li > a:hover, .nav-dropdown-bold.dark .nav-column li > a:hover, .nav-dropdown.nav-dropdown-bold.dark > li > a:hover, .is-outline:hover, .tagcloud a:hover,.grid-tools a, input[type='submit']:not(.is-form), .box-badge:hover .box-text, input.button.alt,.nav-box > li > a:hover,.nav-box > li.active > a,.nav-pills > li.active > a ,.current-dropdown .cart-icon strong, .cart-icon:hover strong, .nav-line-bottom > li > a:before, .nav-line-grow > li > a:before, .nav-line > li > a:before,.banner, .header-top, .slider-nav-circle .flickity-prev-next-button:hover svg, .slider-nav-circle .flickity-prev-next-button:hover .arrow, .primary.is-outline:hover, .button.primary:not(.is-outline), input[type='submit'].primary, input[type='submit'].primary, input[type='reset'].button, input[type='button'].primary, .badge-inner{background-color: #FF531D;}/* Border */.nav-vertical.nav-tabs > li.active > a,.scroll-to-bullets a.active,.nav-pagination > li > .current,.nav-pagination > li > span:hover,.nav-pagination > li > a:hover,.has-hover:hover .badge-outline .badge-inner,.accordion-title.active,.featured-table,.is-outline:hover, .tagcloud a:hover,blockquote, .has-border, .cart-icon strong:after,.cart-icon strong,.blockUI:before, .processing:before,.loading-spin, .slider-nav-circle .flickity-prev-next-button:hover svg, .slider-nav-circle .flickity-prev-next-button:hover .arrow, .primary.is-outline:hover{border-color: #FF531D}.nav-tabs > li.active > a{border-top-color: #FF531D}/* Fill */.slider .flickity-prev-next-button:hover svg,.slider .flickity-prev-next-button:hover .arrow{fill: #FF531D;}/* Background Color */[data-icon-label]:after, .secondary.is-underline:hover,.secondary.is-outline:hover,.icon-label,.button.secondary:not(.is-outline),.button.alt:not(.is-outline), .badge-inner.on-sale, .button.checkout, .single_add_to_cart_button{ background-color:#FF531D; }/* Color */.secondary.is-underline,.secondary.is-link, .secondary.is-outline,.stars a.active, .star-rating:before, .woocommerce-page .star-rating:before,.star-rating span:before, .color-secondary{color: #FF531D}/* Color !important */[data-text-color="secondary"]{color: #FF531D!important;}/* Border */.secondary.is-outline:hover{border-color:#FF531D}body{font-family:"Roboto", sans-serif}body{font-weight: 0}body{color: #3A3A3A}.nav > li > a {font-family:"Roboto", sans-serif;}.nav > li > a {font-weight: 0;}h1,h2,h3,h4,h5,h6,.heading-font, .off-canvas-center .nav-sidebar.nav-vertical > li > a{font-family: "Roboto", sans-serif;}h1,h2,h3,h4,h5,h6,.heading-font,.banner h1,.banner h2{font-weight: 0;}h1,h2,h3,h4,h5,h6,.heading-font{color: #3A3A3A;}.section-title span{text-transform: none;}h3.widget-title{text-transform: none;}button,.button{text-transform: none;}.nav > li > a, .links > li > a{text-transform: none;}.alt-font{font-family: "Roboto", sans-serif;}.alt-font{font-weight: 0!important;}.header:not(.transparent) .header-nav.nav > li > a {color: #FFFFFF;}a{color: rgba(0,0,0,0.54);}a:hover{color: #FF531D;}.tagcloud a:hover{border-color: #FF531D;background-color: #FF531D;}.widget a{color: #353535;}.widget a:hover{color: #FF531D;}.widget .tagcloud a:hover{border-color: #FF531D; background-color: #FF531D;}@media screen and (min-width: 550px){.products .box-vertical .box-image{min-width: 300px!important;width: 300px!important;}}.header-main .social-icons,.header-main .cart-icon strong,.header-main .menu-title,.header-main .header-button > .button.is-outline,.header-main .nav > li > a > i:not(.icon-angle-down){color: #FFFFFF!important;}.header-main .header-button > .button.is-outline,.header-main .cart-icon strong:after,.header-main .cart-icon strong{border-color: #FFFFFF!important;}.header-main .header-button > .button:not(.is-outline){background-color: #FFFFFF!important;}.header-main .current-dropdown .cart-icon strong,.header-main .header-button > .button:hover,.header-main .header-button > .button:hover i,.header-main .header-button > .button:hover span{color:#FFF!important;}.header-main .menu-title:hover,.header-main .social-icons a:hover,.header-main .header-button > .button.is-outline:hover,.header-main .nav > li > a:hover > i:not(.icon-angle-down){color: #FFFFFF!important;}.header-main .current-dropdown .cart-icon strong,.header-main .header-button > .button:hover{background-color: #FFFFFF!important;}.header-main .current-dropdown .cart-icon strong:after,.header-main .current-dropdown .cart-icon strong,.header-main .header-button > .button:hover{border-color: #FFFFFF!important;}.absolute-footer, html{background-color: #F5F5F5}.label-new.menu-item > a:after{content:"New";}.label-hot.menu-item > a:after{content:"Hot";}.label-sale.menu-item > a:after{content:"Sale";}.label-popular.menu-item > a:after{content:"Popular";}</style>		<style type="text/css" id="wp-custom-css">
            /*
Bạn có thể thêm CSS ở đây.

Nhấp chuột vào biểu tượng trợ giúp phía trên để tìm hiểu thêm.
            */


            /*Khoảng cách dòng*/
            body, p {
                line-height: 160%!important;
                font-size: 14px;
            }

            /*chỉnh kích thước container*/
            .container{
                padding-left: 0px;
                padding-right: 0px;
                max-width: 1200px;
            }

            .row.row-collapse {
                max-width: 1200px;
            }
            .row.row-large {
                max-width: 1200px;
            }
            .full-width .ubermenu-nav, .container, .row {
                max-width: 1200px;
            }

            /*----------header-----------*/
            /*style cho menu top bar trái*/
            .topbarlink > a{
                color: #a8b2b7;
                font-size: 12px;
                text-transform: uppercase;
                margin-right: 25px;
            }
            .topbarlink > a:hover{
                color: #fff;
            }

            /*style tài khoản ở topbar*/
            #top-bar .header-account-title
            {
                color: #a8b2b7;
                font-size: 12px;
                text-transform: uppercase;
                margin-right: 25px;
            }
            #top-bar .header-account-title:hover
            {
                color: #fff;
            }

            /*style language*/
            #top-bar .nav-small .nav>li>a, 
            #top-bar .nav.nav-small>li>a {
                vertical-align: top;
                padding-top: 5px;
                padding-bottom: 5px;
                font-weight: normal;
                text-transform: uppercase;
            }

            /*border khung search*/
            li.html .row, li.html form, li.html select, li.html input {
                height: 38px;
                background-color: #fff;
            }
            .searchform .button.icon {
                margin: 0px;
                height: 38px;
                width: 38px;

            }
            .searchform .button.icon i {
                font-size: 1.3em;
                color: #fff;
            }
            .searchform{
                background-color: #fff;
            }

            /*style background hồng xiên cho header*/
            .header-main {
                background-image: linear-gradient(135deg, transparent, transparent calc(50% + 250px), #c60a4e calc(50% + 250px), #d30b4d 90% ) !important;
                border-bottom: 1px solid #11252F;
            }

            /*style header_bottom menu (thay .header:not(.transparent) bằng .header-bottom)*/
            .header-bottom .header-nav.nav > li > a{
                padding-left: 10px;
                padding-right: 10px;
            }
            .header-bottom .header-nav.nav > li > a:hover {
                color: #000 !important;
                background-color: #fff;
                padding-left: 10px;
                padding-right: 10px;
            }
            .header-bottom .header-nav.nav > li:last-child > a {
                color: #ff531d;
            }
            .header-bottom .header-nav.nav > li:last-child > a:hover {
                color: #000;
            }
            /*----------end header-----------*/


            /*----------content-----------*/
            /*remove button add to cart*/
            .add-to-cart-button {
                display: none;
            }

            /*chỉnh khoảng cách dòng của giá*/
            .price {
                line-height: 160%;
            }

            /*căn đều chiều cao các sản phẩm đều nhau trong row*/
            .has-shadow>.col>.col-inner {
                background-color: #FFF;
                height: 100%;
            }
            /*chỉnh độ cao sản phẩm trong slide*/
            .sec_flash_sale .box-text.text-center,
            .sec_top_deal .box-text.text-center,
            .sec_dien_thoai .box-text.text-center,
            .sec_oto_xemay .box-text.text-center,
            .sec_nhacua_noithat .box-text.text-center,
            .sec_bachhoa .box-text.text-center,
            .sec_top_sale .box-text.text-center{
                padding-left: 10px;
                padding-right: 10px;
                height: 100px;
            }

            /*chỉnh nhãn Giảm giá*/
            .badge-inner {
                line-height: 1.2;
                font-size: 12px;
            }

            /*----style tab banner------*/
            .sec_tab_banner .nav-tabs+.tab-panels {
                border: 0px solid #ddd;
                background-color: #fff;
                padding: 0px;
                margin-top: 5px;
            }
            .sec_tab_banner .nav-tabs>li>a {
                border-top: 2px solid #ddd;
                border-left: 1px solid #ddd;
                border-right: 1px solid #ddd;
                background-color: #cdd6da;
                padding-left: 15px;
                padding-right: 15px;
                width: 195px;
                margin-right: 4px;
            }
            .sec_tab_banner .nav-tabs>li:first-child>a {
                background: #f36f36;
                color: #fff;
            }
            .sec_tab_banner .nav-tabs>li>a:hover {
                background: #596d78;
                color: #fff;
            }
            .sec_tab_banner .nav-tabs>li:last-child>a {
                border-top: 2px solid #ddd;
                border-left: 1px solid #ddd;
                border-right: 1px solid #ddd;
                background-color: rgba(0,0,0,0.04);
                padding-left: 15px;
                padding-right: 15px;
                width: 395px;
                margin-right: 0px;
                margin-left: 198px;
                position: right;
                color: #fff;
                background-image: linear-gradient(263deg,#f5ac24,#f57224);
            }
            /*-------end style tab banner------*/

            /*-------style tab bán hàng------*/
            .sec_tab_ban_hang .container .section, .row .sec_tab_ban_hang{
                padding-left: 0px;
                padding-right: 0px;
            }
            .sec_tab_ban_hang .nav-tabs+.tab-panels {
                border: 0px solid #ddd;
                background-color: #fff;
                padding: 30px;
                margin-top: 0px;
            }
            .sec_tab_ban_hang .nav-tabs > li > a {
                width: 298px;
                font-size: 16px;
                line-height: 20px;
                font-weight: 400;
                color: #383838;
                background: #dadada;
                text-align: center;
                float: left;
                padding: 20px 10px;
                border-bottom: 4px solid #c4c2c2;
            }
            .sec_tab_ban_hang .nav-tabs > li.active > a {
                color: #fff;
                background: #f37022;
                border-bottom: 4px solid #c5c3c3;
                width: 298px;
            }
            /*-------end style tab bán hàng------*/

            /*style xu_huong_tim_kiem*/
            .xu_huong_tim_kiem p.product-cat {
                margin-top: .1em;
                margin-bottom: .1em;
                font-size: 110%;
                font-style: bold;
            }
            .xu_huong_tim_kiem p.product-title{
                display: none;
            }
            .xu_huong_tim_kiem .price-wrapper{
                display: none;
            }
            .xu_huong_tim_kiem .badge-container{
                display: none;
            }

            /*style section danh mục*/
            .sec_danh_muc .box-image img {
                max-width: 100%;
                width: 100%;
                -webkit-transform: translateZ(0);
                transform: translateZ(0);
                margin: 0 auto;
                padding: 10px;
            }

            /*chỉnh khoảng cách trong khung thêm vào giỏ*/
            .cart{
                margin-bottom: 1.3em;
                margin-top: 1.3em;
            }

            .row_tab_ban_hang{
                border: 1px solid #eee;
                margin-top: 10px;
            }
            .row_tab_ban_hang .has-icon-bg .icon .icon-inner {
                color: #446084;
                position: absolute;
                height: 100%;
                width: 100%;
                top: 0;
                border: 2px solid currentColor;
                border-radius: 100%;
                transition: all .3s;
                background: rgb(156, 167, 59);
            }
            /*----------end content-----------*/


            /*----------footer-----------*/
            /*---style block footer 01---*/
            .block_footer_01{
                font-size: 12px;
                font-weight: 200;
                line-height: 140%!important;
            }
            .block_footer_01 p{
                font-size: 12px;
                font-weight: 200;
            }
            .block_footer_01 li {
                margin-bottom: 0px;
                display: table-header-group;
            }

            .block_footer_01 .wpcf7 p {
                padding: 0;
                margin: 0;
                display: flex;
            }


            .block_footer_01 #email_nhan_tin{
                width: 370px;
                height: 40px;
                background-color: #102632;
                border: 0px
            }

            .block_footer_01 .wpcf7 span.wpcf7-list-item{
                margin: 0.9em 1.2em 0 0.1em;
            }
            /*---end style block footer 01---*/

            /*---style block footer 03---*/
            .block_footer_03{
                font-size: 12px;
                font-weight: 200;
            }
            .block_footer_03 p{
                font-size: 12px;
                font-weight: 200;
                text-align: justify;
            }

            .block_footer_03 ul.menu>li,
            .block_footer_03 >.widget>ul>li {
                list-style: none;
                margin-bottom: .3em;
                text-align: left;
                margin: 0;
                display: inline-block;
                border-right: 1px solid rgba(0, 0, 0, 0.54);
                border-top: 0px solid #ececec;
                padding: 0px 5px 0px 0px;
                font-size: 12px;
                height: 16px;

            }
            .block_footer_03 ul.menu>li>a, .block_footer_03 ul.menu>li>span:first-child, 
            .sec_danh_muc >.widget>ul>li>a, .sec_danh_muc >.widget>ul>li>span:first-child {
                display: inline-block;
                padding: 0px;
                -webkit-flex: 1;
                -ms-flex: 1;
                flex: 1;
            }
            .block_footer_03 ul ul, 
            .block_footer_03 ul ol, 
            .block_footer_03 ol ol, 
            .block_footer_03 ol ul {
                margin: 10px 0px;
            }
            body {font-family: "Lato", sans-serif}
            .mySlides {display: none}
            /*---end style block footer 03---*/

            /*----------end footer-----------*/

        </style>
        <style type="text/css">
        </style>
        <script type="text/javascript">
            if (typeof woof_lang_custom == 'undefined') {
            var woof_lang_custom = {}; //!!important
            }
            woof_lang_custom.woof_text = "By text";
            var woof_text_autocomplete = 0;
            var woof_text_autocomplete_items = 10;
            woof_text_autocomplete = 1;
            woof_text_autocomplete_items = 10;
            var woof_post_links_in_autocomplete = 0;
            woof_post_links_in_autocomplete = 0;
            var how_to_open_links = 0;
            how_to_open_links = 0;
        </script>
        <style type="text/css">
        </style>
        <script type="text/javascript">
            var woof_is_permalink = 1;
            var woof_shop_page = "";
            var woof_really_curr_tax = {};
            var woof_current_page_link = location.protocol + '//' + location.host + location.pathname;
            //***lets remove pagination from woof_current_page_link
            woof_current_page_link = woof_current_page_link.replace(/\page\/[0-9]+/, "");
            woof_current_page_link = "http://mauweb.monamedia.net/lazada/cua-hang/";
            var woof_link = 'http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/';
        </script>

        <script>

            var woof_ajaxurl = "http://mauweb.monamedia.net/lazada/wp-admin/admin-ajax.php";
            var woof_lang = {
            'orderby': "orderby",
                    'date': "date",
                    'perpage': "per page",
                    'pricerange': "price range",
                    'menu_order': "menu order",
                    'popularity': "popularity",
                    'rating': "rating",
                    'price': "price low to high",
                    'price-desc': "price high to low"
            };
            if (typeof woof_lang_custom == 'undefined') {
            var woof_lang_custom = {}; //!!important
            }

//***

            var woof_is_mobile = 0;
            var woof_show_price_search_button = 0;
            var woof_show_price_search_type = 0;
            woof_show_price_search_button = 1;
            var woof_show_price_search_type = 3;
            var swoof_search_slug = "swoof";
            var icheck_skin = {};
            icheck_skin = 'none';
            var is_woof_use_chosen = 1;
            var woof_current_values = '[]';
//+++
            var woof_lang_loading = "Loading ...";
            var woof_lang_show_products_filter = "show products filter";
            var woof_lang_hide_products_filter = "hide products filter";
            var woof_lang_pricerange = "price range";
//+++

            var woof_use_beauty_scroll = 0;
//+++
            var woof_autosubmit = 1;
            var woof_ajaxurl = "http://mauweb.monamedia.net/lazada/wp-admin/admin-ajax.php";
            var woof_submit_link = "";
            var woof_is_ajax = 0;
            var woof_ajax_redraw = 0;
            var woof_ajax_page_num = 1;
            var woof_ajax_first_done = false;
            var woof_checkboxes_slide_flag = true;
//toggles
            var woof_toggle_type = "text";
            var woof_toggle_closed_text = "-";
            var woof_toggle_opened_text = "+";
            var woof_toggle_closed_image = "http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/img/plus3.png";
            var woof_toggle_opened_image = "http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/img/minus3.png";
//indexes which can be displayed in red buttons panel
            var woof_accept_array = ["min_price", "orderby", "perpage", "woof_text", "product_visibility", "product_cat", "product_tag"];
//***
//for extensions

            var woof_ext_init_functions = null;
            woof_ext_init_functions = '{"by_text":"woof_init_text","color":"woof_init_colors","label":"woof_init_labels","select_hierarchy":"woof_init_select_hierarchy","select_radio_check":"woof_init_select_radio_check"}';
            var woof_overlay_skin = "default";
            jQuery(function () {
            woof_current_values = jQuery.parseJSON(woof_current_values);
            if (woof_current_values.length == 0) {
            woof_current_values = {};
            }

            });
            function woof_js_after_ajax_done() {
            jQuery(document).trigger('woof_ajax_done');
            }
        </script>
    </head>

    <body class="home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow">

        <a class="skip-link screen-reader-text" href="#main">Skip to content</a>

        <div id="wrapper">


            <header id="header" class="header has-sticky sticky-jump">
                <div class="header-wrapper">
                    <div id="top-bar" class="header-top hide-for-sticky nav-dark">
                        <div class="flex-row container">
                            <div class="flex-col hide-for-medium flex-left">
                                <ul class="nav nav-left medium-nav-center nav-small  nav-">
                                </ul>
                            </div><!-- flex-col left -->

                            <div class="flex-col hide-for-medium flex-center">
                                <ul class="nav nav-center nav-small  nav-">
                                </ul>
                            </div><!-- center -->

                            <div class="flex-col hide-for-medium flex-right">
                                <ul class="nav top-bar-nav nav-right nav-small  nav-">
                                    <li class="html custom html_topbar_right"><p class="topbarlink"><a href="http://mauweb.monamedia.net/lazada/cong-tac-cung-mona/" style="color:#37cfdd">Be one of us</a></p></li>
                                    <li class="html custom html_top_right_text"><p class="topbarlink"><a href="#">Customer Service</a></p></li>
                                    <li class="html custom html_nav_position_text_top"><p class="topbarlink"><a href="#">Check Order</a></p></li>
                                        <%User x = (User) request.getSession().getAttribute("currUser");%>
                                        <%if (x == null) {%>


                                    <li class="account-item has-icon ">

                                        <a href="jsp/login.jsp"class="nav-top-link nav-top-not-logged-in ">
                                            <span>
                                                Login     / Register  </span>
                                        </a><!-- .account-login-link -->

                                    </li>
                                    <%} else {%>
                                    <li class=" menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown"><a><span> Hello <%=x.getFullname()%></span></a>
                                        <ul class='nav-dropdown nav-dropdown-simple'>
                                            <%if (x.getSystemRole() == 1) {%>
                                            <li  ><a href="AdminControllerMap" class="menu-image-title-after"><span >Admin Dashboard</span></a></li>
                                            <%}%>
                                            <li  ><a href="UserControllerMap?service=info" class="menu-image-title-after"><span >User profile</span></a></li>
                                            <li  ><a href="UserControllerMap?service=logout" class="menu-image-title-after"><span >Lougout</span></a></li>

                                        </ul>
                                    </li>
                                    <%}%>
                                </ul>
                            </div><!-- .flex-col right -->



                        </div><!-- .flex-row -->
                    </div><!-- #header-top -->
                    <div id="masthead" class="header-main nav-dark">
                        <div class="header-inner flex-row container logo-left medium-logo-center" role="navigation">

                            <!-- Logo -->
                            <div id="logo" class="flex-col logo">
                                <!-- Header logo -->
                                <a href="http://mauweb.monamedia.net/lazada/" title="BMAZON" rel="home">
                                    <img width="124" height="75" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/logo-ecommerce-1.svg" class="header_logo header-logo" alt="Lazada"/><img  width="124" height="75" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/logo-ecommerce-1.svg" class="header-logo-dark" alt="Lazada"/></a>
                            </div>




                            <!-- Left Elements -->
                            <div class="flex-col hide-for-medium flex-left
                                 flex-grow">
                                <ul class="header-nav header-nav-main nav nav-left  nav-uppercase" >
                                    <li class="header-search-form search-form html relative has-icon">
                                        <div class="header-search-form-wrapper">
                                            <div class="searchform-wrapper ux-search-box relative form- is-normal"><form method="get" class="searchform" action="http://mauweb.monamedia.net/lazada/" role="search">
                                                    <div class="flex-row relative">
                                                        <div class="flex-col flex-grow">
                                                            <input type="search" class="search-field mb-0" name="s" value="" placeholder="Find Product" />
                                                            <input type="hidden" name="post_type" value="product" />
                                                        </div><!-- .flex-col -->
                                                        <div class="flex-col">
                                                            <button type="submit" class="ux-search-submit submit-button secondary button icon mb-0">
                                                                <i class="icon-search" ></i>				</button>
                                                        </div><!-- .flex-col -->
                                                    </div><!-- .flex-row -->
                                                    <div class="live-search-results text-left z-top"></div>
                                                </form>
                                            </div>	</div>
                                    </li><li class="cart-item has-icon
                                             has-dropdown">

                                        <a href="http://mauweb.monamedia.net/lazada/gio-hang/" title="Cart" class="header-cart-link is-small">



                                            <i class="icon-shopping-cart"
                                               data-icon-label="0">
                                            </i>
                                        </a>

                                        <ul class="nav-dropdown nav-dropdown-simple">
                                            <li class="html widget_shopping_cart">
                                                <div class="widget_shopping_cart_content">


                                                    <p class="woocommerce-mini-cart__empty-message">The cart is empty</p>


                                                </div>
                                            </li>
                                        </ul><!-- .nav-dropdown -->

                                    </li>
                                </ul>
                            </div>

                            <!-- Right Elements -->
                            <div class="flex-col hide-for-medium flex-right">
                                <ul class="header-nav header-nav-main nav nav-right  nav-uppercase">
                                    <li class="html custom html_nav_position_text"><img class="header_promotion" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/or-header.png" alt="promotion" height="40" width="170"></li>            </ul>
                            </div>

                            <!-- Mobile Right Elements -->
                            <div class="flex-col show-for-medium flex-right">
                                <ul class="mobile-nav nav nav-right ">
                                    <li class="cart-item has-icon">


                                        <a href="http://mauweb.monamedia.net/lazada/gio-hang/" class="header-cart-link off-canvas-toggle nav-top-link is-small" data-open="#cart-popup" data-class="off-canvas-cart" title="Giỏ hàng" data-pos="right">

                                            <i class="icon-shopping-cart"
                                               data-icon-label="0">
                                            </i>
                                        </a>


                                        <!-- Cart Sidebar Popup -->
                                        <div id="cart-popup" class="mfp-hide widget_shopping_cart">
                                            <div class="cart-popup-inner inner-padding">
                                                <div class="cart-popup-title text-center">
                                                    <h4 class="uppercase">Cart</h4>
                                                    <div class="is-divider"></div>
                                                </div>
                                                <div class="widget_shopping_cart_content">


                                                    <p class="woocommerce-mini-cart__empty-message">The cart is empty</p>


                                                </div>
                                                <div class="cart-sidebar-content relative"></div>  </div>
                                        </div>

                                    </li>
                                </ul>
                            </div>

                        </div><!-- .header-inner -->


                    </div>
                    <link rel='stylesheet' id='easy-autocomplete-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/easy-autocomplete/easy-autocomplete.min.css?ver=4.8.14' type='text/css' media='all' />
                    <link rel='stylesheet' id='easy-autocomplete-theme-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/easy-autocomplete/easy-autocomplete.themes.min.css?ver=4.8.14' type='text/css' media='all' />
                    <link rel='stylesheet' id='flatsome-countdown-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/inc/shortcodes/ux_countdown/ux-countdown.css?ver=4.8.14' type='text/css' media='all' />
                    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type='text/javascript'>
            /* <![CDATA[ */
            var wpcf7 = {"apiSettings":{"root":"http:\/\/mauweb.monamedia.net\/lazada\/wp-json\/contact-form-7\/v1", "namespace":"contact-form-7\/v1"}, "recaptcha":{"messages":{"empty":"H\u00e3y x\u00e1c nh\u1eadn r\u1eb1ng b\u1ea1n kh\u00f4ng ph\u1ea3i l\u00e0 robot."}}, "cached":"1"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/contact-form-7/includes/js/scripts.js?ver=4.9.1'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var wc_add_to_cart_params = {"ajax_url":"\/lazada\/wp-admin\/admin-ajax.php", "wc_ajax_url":"http:\/\/mauweb.monamedia.net\/lazada\/?wc-ajax=%%endpoint%%", "i18n_view_cart":"Xem gi\u1ecf h\u00e0ng", "cart_url":"http:\/\/mauweb.monamedia.net\/lazada\/gio-hang\/", "is_cart":"", "cart_redirect_after_add":"no"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce/assets/js/frontend/add-to-cart.min.js?ver=3.2.3'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce/assets/js/jquery-blockui/jquery.blockUI.min.js?ver=2.70'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce/assets/js/js-cookie/js.cookie.min.js?ver=2.1.4'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var woocommerce_params = {"ajax_url":"\/lazada\/wp-admin\/admin-ajax.php", "wc_ajax_url":"http:\/\/mauweb.monamedia.net\/lazada\/?wc-ajax=%%endpoint%%"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce/assets/js/frontend/woocommerce.min.js?ver=3.2.3'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var wc_cart_fragments_params = {"ajax_url":"\/lazada\/wp-admin\/admin-ajax.php", "wc_ajax_url":"http:\/\/mauweb.monamedia.net\/lazada\/?wc-ajax=%%endpoint%%", "fragment_name":"wc_fragments_aadc42a95f99a075b9b5f134e1d4f81b"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce/assets/js/frontend/cart-fragments.min.js?ver=3.2.3'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/inc/extensions/flatsome-live-search/flatsome-live-search.js?ver=3.4.0'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/hoverIntent.min.js?ver=1.8.1'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var flatsomeVars = {"ajaxurl":"http:\/\/mauweb.monamedia.net\/lazada\/wp-admin\/admin-ajax.php", "rtl":"", "sticky_height":"70"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/js/flatsome.js?ver=3.4.0'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/js/woocommerce.js?ver=3.4.0'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/wp-embed.min.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/easy-autocomplete/jquery.easy-autocomplete.min.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/front.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/html_types/radio.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/html_types/checkbox.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/html_types/select.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/html_types/mselect.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/by_text/js/by_text.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/color/js/html_types/color.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/label/js/html_types/label.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_hierarchy/js/html_types/select_hierarchy.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_radio_check/js/html_types/select_radio_check.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/chosen/chosen.jquery.min.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/inc/shortcodes/ux_countdown/countdown-script-min.js?ver=4.8.14'></script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/inc/shortcodes/ux_countdown/ux-countdown.js?ver=3.2.6'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var _zxcvbnSettings = {"src":"http:\/\/mauweb.monamedia.net\/lazada\/wp-includes\/js\/zxcvbn.min.js"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/zxcvbn-async.min.js?ver=1.0'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var pwsL10n = {"unknown":"M\u1eadt kh\u1ea9u m\u1ea1nh kh\u00f4ng x\u00e1c \u0111\u1ecbnh", "short":"R\u1ea5t y\u1ebfu", "bad":"Y\u1ebfu", "good":"Trung b\u00ecnh", "strong":"M\u1ea1nh", "mismatch":"M\u1eadt kh\u1ea9u kh\u00f4ng kh\u1edbp"};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-admin/js/password-strength-meter.min.js?ver=4.8.14'></script>
                    <script type='text/javascript'>
            /* <![CDATA[ */
            var wc_password_strength_meter_params = {"min_password_strength":"3", "i18n_password_error":"Vui l\u00f2ng nh\u1eadp m\u1eadt kh\u1ea9u kh\u00f3 h\u01a1n.", "i18n_password_hint":"G\u1ee3i \u00fd: M\u1eadt kh\u1ea9u ph\u1ea3i c\u00f3 \u00edt nh\u1ea5t 12 k\u00fd t\u1ef1. \u0110\u1ec3 n\u00e2ng cao \u0111\u1ed9 b\u1ea3o m\u1eadt, s\u1eed d\u1ee5ng ch\u1eef in hoa, in th\u01b0\u1eddng, ch\u1eef s\u1ed1 v\u00e0 c\u00e1c k\u00fd t\u1ef1 \u0111\u1eb7c bi\u1ec7t nh\u01b0 ! \" ? $ % ^ & )."};
            /* ]]> */
                    </script>
                    <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce/assets/js/frontend/password-strength-meter.min.js?ver=3.2.3'></script>
                    <style type="text/css"></style><script type="text/javascript">var essb_clicked_lovethis = false; var essb_love_you_message_thanks = "Thank you for loving this."; var essb_love_you_message_loved = "You already love this today."; var essb_lovethis = function(oInstance) { if (essb_clicked_lovethis) { alert(essb_love_you_message_loved); return; } var element = jQuery('.essb_' + oInstance); if (!element.length) { return; } var instance_post_id = jQuery(element).attr("data-essb-postid") || ""; var cookie_set = essb_get_lovecookie("essb_love_" + instance_post_id); if (cookie_set) { alert(essb_love_you_message_loved); return; } if (typeof (essb_settings) != "undefined") { jQuery.post(essb_settings.ajax_url, { 'action': 'essb_love_action', 'post_id': instance_post_id, 'service': 'love', 'nonce': essb_settings.essb3_nonce }, function (data) { if (data) { alert(essb_love_you_message_thanks); }}, 'json'); } essb_tracking_only('', 'love', oInstance, true); }; var essb_get_lovecookie = function(name) { var value = "; " + document.cookie; var parts = value.split("; " + name + "="); if (parts.length == 2) return parts.pop().split(";").shift(); }; var essb_window = function(oUrl, oService, oInstance) { var element = jQuery('.essb_' + oInstance); var instance_post_id = jQuery(element).attr("data-essb-postid") || ""; var instance_position = jQuery(element).attr("data-essb-position") || ""; var wnd; var w = 800; var h = 500; if (oService == "twitter") { w = 500; h = 300; } var left = (screen.width / 2) - (w / 2); var top = (screen.height / 2) - (h / 2); if (oService == "twitter") { wnd = window.open(oUrl, "essb_share_window", "height=300,width=500,resizable=1,scrollbars=yes,top=" + top + ",left=" + left); } else { wnd = window.open(oUrl, "essb_share_window", "height=500,width=800,resizable=1,scrollbars=yes,top=" + top + ",left=" + left); } if (typeof (essb_settings) != "undefined") { if (essb_settings.essb3_stats) { if (typeof (essb_handle_stats) != "undefined") { essb_handle_stats(oService, instance_post_id, oInstance); } } if (essb_settings.essb3_ga) { essb_ga_tracking(oService, oUrl, instance_position); } } essb_self_postcount(oService, instance_post_id); var pollTimer = window.setInterval(function() { if (wnd.closed !== false) { window.clearInterval(pollTimer); essb_smart_onclose_events(oService, instance_post_id); } }, 200); }; var essb_self_postcount = function(oService, oCountID) { if (typeof (essb_settings) != "undefined") { oCountID = String(oCountID); jQuery.post(essb_settings.ajax_url, { 'action': 'essb_self_postcount', 'post_id': oCountID, 'service': oService, 'nonce': essb_settings.essb3_nonce }, function (data) { if (data) { }}, 'json'); } }; var essb_smart_onclose_events = function(oService, oPostID) { if (typeof (essbasc_popup_show) == 'function') { essbasc_popup_show(); } if (typeof essb_acs_code == 'function') { essb_acs_code(oService, oPostID); } }; var essb_tracking_only = function(oUrl, oService, oInstance, oAfterShare) { var element = jQuery('.essb_' + oInstance); if (oUrl == "") { oUrl = document.URL; } var instance_post_id = jQuery(element).attr("data-essb-postid") || ""; var instance_position = jQuery(element).attr("data-essb-position") || ""; if (typeof (essb_settings) != "undefined") { if (essb_settings.essb3_stats) { if (typeof (essb_handle_stats) != "undefined") { essb_handle_stats(oService, instance_post_id, oInstance); } } if (essb_settings.essb3_ga) { essb_ga_tracking(oService, oUrl, instance_position); } } essb_self_postcount(oService, instance_post_id); if (oAfterShare) { essb_smart_onclose_events(oService, instance_post_id); } }; var essb_pinterest_picker = function(oInstance) { essb_tracking_only('', 'pinterest', oInstance); var e = document.createElement('script'); e.setAttribute('type', 'text/javascript'); e.setAttribute('charset', 'UTF-8'); e.setAttribute('src', '//assets.pinterest.com/js/pinmarklet.js?r=' + Math.random() * 99999999); document.body.appendChild(e); };</script>
                    <style type="text/css">










                        .woof_edit_view{
                            display: none;
                        }

                    </style>
                </div>
            </header>



    </body>
</html>