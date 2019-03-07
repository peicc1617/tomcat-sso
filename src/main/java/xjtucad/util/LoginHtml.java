package xjtucad.util;

public class LoginHtml {
    public  static final String HTML="<html >\n" +
            "<head>\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>创新方法工作平台统一登录</title>\n" +
            "    <meta name=\"description\" content=\"User login page\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">\n" +
            "    <!-- bootstrap & fontawesome -->\n" +
            "    <link rel=\"stylesheet\" href=\"/webresources/ace-master/assets/css/bootstrap.min.css\"  type=\"text/css\">\n" +
            "    <link rel=\"stylesheet\" href=\"/webresources/ace-master/assets/font-awesome/4.5.0/css/font-awesome.min.css\"  type=\"text/css\">\n" +
            "    <!-- text fonts -->\n" +
            "    <link rel=\"stylesheet\" href=\"/webresources/ace-master/assets/css/fonts.googleapis.com.css\"  type=\"text/css\">\n" +
            "    <!-- ace styles -->\n" +
            "    <link rel=\"stylesheet\" href=\"/webresources/ace-master/assets/css/ace.min.css\"  type=\"text/css\">\n" +
            "    <link rel=\"stylesheet\" href=\"/webresources/ace-master/assets/css/ace-rtl.min.css\"  type=\"text/css\">\n" +
            "\n" +
            "    <link rel=\"stylesheet\" href=\"/webresources/ace-master/assets/css/ace-skins.min.css\"  type=\"text/css\">\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"login-layout light-login\">\n" +
            "  <!-- /.main-container -->\n" +
            "    <!-- basic scripts -->\n" +
            "    <div class=\"main-container\">\n" +
            "        <div class=\"main-content\">\n" +
            "            <div class=\"row\">\n" +
            "                <div class=\"col-sm-10 col-sm-offset-1\">\n" +
            "                    <div class=\"login-container\">\n" +
            "\n" +
            "                        <div class=\"center\">\n" +
            "                            <h1>\n" +
            "                                <i class=\"ace-icon fa fa-leaf green\"></i>\n" +
            "                                <span class=\"red\">创新方法平台</span>\n" +
            "                                <span class=\"white\" id=\"id-text2\">用户登录</span>\n" +
            "                            </h1>\n" +
            "                            <h4 class=\"blue\" id=\"id-company-text\">© 西安交通大学CAD/CAM研究室</h4>\n" +
            "                        </div>\n" +
            "                        <div class=\"space-6\"></div>\n" +
            "                        <div class=\"position-relative\">\n" +
            "                            <div id=\"login-box\" class=\"login-box widget-box no-border visible\">\n" +
            "                                <div class=\"widget-body\">\n" +
            "                                    <div class=\"widget-main\">\n" +
            "                                        <h4 class=\"header blue lighter bigger\">\n" +
            "                                            <i class=\"ace-icon fa fa-coffee green\"></i>\n" +
            "                                            请输入账号信息\n" +
            "                                        </h4>\n" +
            "                                        %s\n" +
            "                                        <div class=\"space-6\"></div>\n" +
            "                                        <form id=\"loginForm\" method=\"post\" action=\"%s/user/login\">\n" +
            "                                            <fieldset>\n" +
            "                                                <label class=\"block clearfix\">\n" +
            "                                                    <span class=\"block input-icon input-icon-right\">\n" +
            "                                                        <input id=\"username\" name=\"username\" type=\"text\" class=\"form-control\" placeholder=\"用户名\">\n" +
            "                                                        <i class=\"ace-icon fa fa-user\"></i>\n" +
            "                                                    </span>\n" +
            "                                                </label>\n" +
            "                                                <label class=\"block clearfix\">\n" +
            "                                                    <span class=\"block input-icon input-icon-right\">\n" +
            "                                                        <input id=\"password\" name=\"password\" type=\"password\" class=\"form-control\" placeholder=\"密码\">\n" +
            "                                                        <i class=\"ace-icon fa fa-lock\"></i>\n" +
            "                                                    </span>\n" +
            "                                                </label>\n" +
            "                                                <div style=\"display: none\">\n" +
            "                                                    <label class=\"block clearfix \">\n" +
            "                                                        <span class=\"block input-icon input-icon-right\">\n" +
            "                                                            <input id=\"serviceURL\" name=\"serviceURL\" type=\"text\" class=\"form-control\" value=\"%s\">\n" +
            "                                                        </span>\n" +
            "                                                    </label>\n" +
            "                                                </div>\n" +
            "                                                <div class=\"space\"></div>\n" +
            "\n" +
            "                                                <div class=\"clearfix\" style=\"text-align: center\">\n" +
            "                                                    <button type=\"submit\" class=\"width-35 btn btn-sm btn-primary\">\n" +
            "                                                        <i class=\"ace-icon fa fa-key\"></i>\n" +
            "                                                        <span class=\"bigger-110\">登录</span>\n" +
            "                                                    </button>\n" +
            "                                                </div>\n" +
            "                                            </fieldset>\n" +
            "                                        </form>\n" +
            "                                    </div>\n" +
            "                                    <!-- /.widget-main -->\n" +
            "                                </div>\n" +
            "                                <!-- /.widget-body -->\n" +
            "                            </div>\n" +
            "                            <div id=\"userBox\" class=\"login-box widget-box no-border \">\n" +
            "                                    <div class=\"widget-body\">\n" +
            "                                        <div class=\"widget-main\">\n" +
            "                                            <h4 class=\"header blue lighter bigger\">\n" +
            "                                                <i class=\"ace-icon fa fa-coffee green\"></i>\n" +
            "                                                当前已登录账号\n" +
            "                                            </h4>\n" +
            "            \n" +
            "                                            <div class=\"space-6\"></div>\n" +
            "                                            <div class=\"scroll-content\" style=\"max-height: 200px;\">\n" +
            "                                                <div class=\"profile-activity clearfix\">\n" +
            "                                                    <div>\n" +
            "                                                        <img class=\"pull-left\" alt=\"Alex Doe's avatar\" src=\"/webresources/ace-master/assets/images/avatars/avatar4.png\">\n" +
            "                                                        <label>用户名：</label>\n" +
            "                                                        <a class=\"user\" id=\"usernamebox\" href=\"#\">111</a>\n" +
            "                                                        <div class=\"time\">\n" +
            "                                                            <i class=\"ace-icon fa fa-clock-o bigger-110\"></i>\n" +
            "                                                            已登录\n" +
            "                                                        </div>\n" +
            "                                                    </div>\n" +
            "            \n" +
            "                                                </div>\n" +
            "            \n" +
            "                                            </div>\n" +
            "            \n" +
            "                                        </div>\n" +
            "                                        <!-- /.widget-main -->\n" +
            "            \n" +
            "                                        <div class=\"toolbar clearfix\">\n" +
            "                                            <div>\n" +
            "                                                <a onclick=\"logout()\" class=\"forgot-password-link\">\n" +
            "                                                    <i class=\"ace-icon fa fa-arrow-left\"></i>\n" +
            "                                                    退出当前用户\n" +
            "                                                </a>\n" +
            "                                            </div>\n" +
            "                                            <div>\n" +
            "                                                <a id=\"serviceURL2\" href=\"%s\" class=\"user-signup-link\">\n" +
            "                                                    使用当前用户继续访问\n" +
            "                                                    <i class=\"ace-icon fa fa-arrow-right\"></i>\n" +
            "                                                </a>\n" +
            "                                            </div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <!-- /.widget-body -->\n" +
            "                                </div>\n" +
            "                        </div>\n" +
            "                        <!-- /.position-relative -->\n" +
            "                    </div>\n" +
            "\n" +
            "                   \n" +
            "                </div>\n" +
            "                <!-- /.col -->\n" +
            "            </div>\n" +
            "            <!-- /.row -->\n" +
            "        </div>\n" +
            "        <!-- /.main-content -->\n" +
            "    </div>" +
            "    <script src=\"/webresources/ace-master/assets/js/jquery-2.1.4.min.js\"></script>\n" +
            "    <script> $(function () {\n" +
            "            if (!haseToken()) {\n" +
            "                getToken();\n" +
            "            } else {\n" +
            "                getUserInfo();\n" +
            "\n" +
            "            }\n" +
            "        })\n" +
            "        function haseToken() {\n" +
            "            var cookies = document.cookie.split(';');\n" +
            "            var is = false;\n" +
            "            cookies.forEach(cookie => {\n" +
            "                if (cookie.split('=')[0] === \"AU_TOKEN\") {\n" +
            "                    is = true;\n" +
            "                }\n" +
            "            })\n" +
            "            return is;\n" +
            "        }\n" +
            "        function getToken() {\n" +
            "            $.ajax({\n" +
            "                url: '%s/user/tokenSync',\n" +
            "                type: 'get',\n" +
            "                async: false,\n" +
            "                dataType: \"jsonp\", //指定服务器返回的数据类型\n" +
            "                success: function (data) {\n" +
            "                    if (data.state) {\n" +
            "                        console.log(\"当前用户已登陆\")\n" +
            "                        //如果有token说明已登陆。将token写入cookie\n" +
            "                        document.cookie = 'AU_TOKEN=' + data.content + ';path=/;' + document.cookie;\n" +
            "                        getUserInfo();\n" +
            "                    } else {\n" +
            "                        //如果没有tokne说明未登录，直接跳转到登录页面\n" +
            "                        console.log(\"当前用户未登录\")\n" +
            "                    }\n" +
            "                }\n" +
            "            })\n" +
            "        }\n" +
            "        function getUserInfo() {\n" +
            "            $.ajax({\n" +
            "                url: '%s/user/login',\n" +
            "                type: 'get',\n" +
            "                success: function (data) {\n" +
            "                    if (data.state !== undefined && !data.state) {\n" +
            "                        //如果返回空，说明未登录\n" +
            "                        $(\"#login-box\").addClass(\"visible\");\n" +
            "                        $(\"#userBox\").removeClass(\"visible\");\n" +
            "                    } else {\n" +
            "                        //如果返回字符串，说明返回的是用户名\n" +
            "                        $(\"#usernamebox\").html(data.content);\n" +
            "                        $(\"#userBox\").addClass(\"visible\");\n" +
            "                        $(\"#login-box\").removeClass(\"visible\");\n" +
            "                        $(\"#forgot-box\").removeClass(\"visible\");\n" +
            "                        $(\"#signup-box\").removeClass(\"visible\");\n" +
            "                    }\n" +
            "                }\n" +
            "            })\n" +
            "        }\n" +
            "        function logout() {\n" +
            "            $.ajax({\n" +
            "                url: '%s/user/logout',\n" +
            "                type: 'get',\n" +
            "                success: function (data) {\n" +
            "                    location.reload();\n" +
            "                }\n" +
            "            })\n" +
            "        }" +
            "</script>" +
            "</body>\n" +
            "\n" +
            "</html>";

    public final static String ERROR = "<div class=\"alert alert-danger\">\n" +
            "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">\n" +
            "<i class=\"ace-icon fa fa-times\"></i>\n" +
            "</button>\n" +
            "<strong>\n" +
            "<i class=\"ace-icon fa fa-times\"></i>\n" +
            "登录异常\n" +
            "</strong>\n" +
            "%s" +
            "<br>\n" +
            "</div>";
}
