<%@ page pageEncoding="utf-8"%>
<link rel="stylesheet" href="${contextPath}/assets/src/css/header.css">
<script src="http://cdn.bootcss.com/jquery/1.12.3/jquery.min.js"></script>
<script src="${contextPath}/assets/dep/layer/layer.js"></script>
<style type="text/css">
.center {
	text-align: center;
}

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	text-align: center;
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Microsoft YaHei", "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.show {
	position: relative;
	height: 20px;
	text-align: center;
	line-height: 20px;
	height: 20px;
}

.show a {
	
}

.hidden {
	position: absolute;
	top: 20px;
	left: 0;
	background: #eee;
}

.hidden a {
	display: inline-block;
}
</style>
<body>
	<div id="header" class="header navbar navbar-fixed-top"
		style="height: 50px">
		<div class="navbar-header-image"
			style="float: left; margin-left: 50px; margin-right: 20px">
			<img alt="" src="${contextPath}/assets/src/image/head.png"
				style="width: 50px; height: 50px">
		</div>
		<div class="navbar-header"
			style="float: left; height: 50px; margin: 10px">
			<iframe allowtransparency="true" frameborder="0" width="180"
				height="36" scrolling="no"
				src="//tianqi.2345.com/plugin/widget/index.htm?s=3&z=2&t=0&v=0&d=1&bd=0&k=000000&f=&q=1&e=1&a=1&c=58457&w=180&h=36&align=center"></iframe>
		</div>
		<div style="float: left; margin: 20px">
			<a
				href="https://www.baidu.com/s?word=${date}&tn=sitehao123_11_pg&ie=utf-8">${date}&nbsp;${weekDay}</a>
		</div>
		<div style="float: left; margin-top: 20px; margin-right: 20px">
			<a
				href="https://www.baidu.com/s?word=${lunar}&tn=sitehao123_11_pg&ie=utf-8">${lunar}</a>
		</div>
		<div style="float: left; margin-top: 20px; margin-right: 20px">
			<a href="http://www.hao123.com/xingzuonew.html">星座运势</a>
		</div>
		<div class="navbar-header" style="float: right">
			<ul class="nav navbar-nav navbar-right">
				<div style="float: right" class="show">
					<a id="a-login" href="#" class="add"><li><img
							style="width: 20px; height: 20px; margin-right: -5px"
							src="${contextPath}/assets/src/image/head-user.png" /></li>
						<li class="user-nick-name"><c:choose>
								<c:when test="${doorUser.nickName != null}">
                            ${doorUser.nickName}
                        </c:when>
								<c:otherwise>登录</c:otherwise>
							</c:choose></li></a>
					<div class="hidden" id="downmenu1"
						style="display: none; width: 100%">
						<ul>
							<li><a href="#" id="logout">退出</a></li>
						</ul>
					</div>
				</div>
				<li><a href="#">网盘</a></li>
				<li><a href="#">邮箱</a></li>
				<li><a href="#">手机版</a></li>
				<li><a href="#">换肤</a></li>
			</ul>
		</div>
	</div>

	<div
		style="width: 100%; height: 1px; background-color: #D5D5D5; margin-top: 5px"></div>

	<div id="layer-div" style="display: none">
		<div id="wrapper" class="login-page">
			<div id="login_form" class="form">
				<input type="text" placeholder="用户名" id="user_name" /> <input
					type="password" placeholder="密码" id="password" />
				<div class="tips" style="color: red;"></div>
				<button class="login">登 录</button>
				<p class="message">
					还没有账户? <a href="#">立刻创建</a>
				</p>
			</div>
		</div>
	</div>
</body>
<script>
    $(function(){
	　　$("#a-login").click(function(){
		if(!'${doorUser}'){
			layer.open({
	            title : "登录",
	            type : 1,
	            skin : 'layui-layer-rim', //加上边框
	            area : [ '420px', '300px' ], //宽高
	            content : $("#layer-div").html(),
	            success: function(layero, index){
                    $(document).on("click",".login",function(){
                    	var userName = $(layero).find('#user_name').val();
                        var password = $(layero).find('#password').val();
                        $.ajax({
                            url: '/door/login',
                            type: 'post',
                            dataType: 'json',
                            data: {
                                'userName':userName,
                                'password':password
                            },
                            success: function(resp) {
                                if(resp.success){
                                	layer.close(index);
                                	parent.location.reload();
                                }else{
                                    $(".tips").html(resp.message);
                                }
                            }
                        });
                    })
                }
	            
	        });
	    } 
      });
	
	$('.show').on("mouseover",function(){
		if('${doorUser}'){
			  $("#downmenu1").css("display","block");
		}
	});
	
	$('.show').on("mouseout",function(){
        $("#downmenu1").css("display","none");
    });
	
	$("#logout").on("click",function(){
		 $.ajax({
             url: '/door/logout',
             type: 'post',
             dataType: 'json',
             data: {
             },
             success: function(resp) {
                 window.location.reload();
             }
         });
	});
    });

</script>
