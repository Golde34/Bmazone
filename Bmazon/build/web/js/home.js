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