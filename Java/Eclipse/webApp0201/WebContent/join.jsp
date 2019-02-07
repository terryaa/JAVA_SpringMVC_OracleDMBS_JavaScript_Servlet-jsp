<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
    <title>Chapter_5</title>
    <!-- ���������� �ٷ��� ���� �ڵ��Դϴ�. �η� A���� ���캸�� �÷������Դϴ�. -->
    <!-- �� ������ ���ͳ� �ͽ��÷η����� HTML5 �±׸� �ν��ϰ� �մϴ�. -->
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- �ʱ�ȭ -->
    <link href="http://fonts.googleapis.com/css?family=Henny+Penny" rel="stylesheet" type="text/css" />
    <!-- �ʱ�ȭ -->
    <style>
        * { margin: 0; padding: 0; }
        body { font-family: 'Times New Roman', serif; }
        li { list-style: none; }
        a { text-decoration: none; }
        img { border: 0; }
    </style>
    <!-- ��� -->
    <style>
        #main_header {
            /* �߾� ����*/
            width: 960px; margin: 0 auto;

            /* ���� ��ǥ */
            height: 160px;
            position: relative;
        }
        #main_header > #title {
            position: absolute;
            left: 20px; top: 30px;
        }
        #main_header > #main_gnb {
            position: absolute;
            right: 0; top: 0;
        }
        #main_header > #main_lnb {
            position: absolute;
            right: 0; bottom: 10px;
        }
    </style>
    <!-- Ÿ��Ʋ -->
    <style>
        #title {
            font-family: 'Henny Penny', cursive; 
        }
    </style>
    <!-- �޴�(1) -->
    <style>
        #main_gnb > ul { overflow: hidden; }
        #main_gnb > ul > li { float: left; }
        #main_gnb > ul > li > a {
            display: block;
            padding: 2px 10px;
            border: 1px solid black;
        }
        #main_gnb > ul > li > a:hover {
            background: black;
            color: white;
        }
        #main_gnb > ul > li:first-child > a { border-radius: 10px 0 0 10px; }
        #main_gnb > ul > li:last-child > a  { border-radius: 0 10px 10px 0; }
    </style>
    <!-- �޴�(2) -->
    <style>
        #main_lnb > ul { overflow: hidden; }
        #main_lnb > ul > li { float: left; }
        #main_lnb > ul > li > a {
            display: block;
            padding: 10px 20px;
            border: 1px solid black;
        }
        #main_lnb > ul > li > a:hover {
            background: black;
            color: white;
        }
        #main_lnb > ul > li:first-child > a { border-radius: 10px 0 0 10px; }
        #main_lnb > ul > li:last-child > a  { border-radius: 0 10px 10px 0; }
    </style>
    <!-- ������ -->
    <style>
        #content {
            /* �߾� ���� */
            width: 960px; margin: 0 auto;

            /* ���� ���̾ƿ� ���� */
            overflow: hidden;
        }
        #content > #main_section {
            width: 750px;
            float: left;
        }
        #content > #main_aside {
            width: 200px;
            float: right;
        }
    </style>
    <!-- ���� -->
    <style>
        #main_section > article.main_article {
            margin-bottom: 10px;
            padding: 20px;
            border: 1px solid black;
        }
    </style>
    <!-- ���̵� -->
    <style>
        /* ù ��° �� */
        input:nth-of-type(1) { display: block; }
        input:nth-of-type(1) ~ div:nth-of-type(1) { display: block; }
        input:nth-of-type(1):checked ~ div:nth-of-type(1) { display: block; }

        /* �� ��° �� */
        input:nth-of-type(2) { display: none; }
        input:nth-of-type(2) ~ div:nth-of-type(2) { display: none; }
        input:nth-of-type(2):checked ~ div:nth-of-type(2) { display: block; }

        /* �� ��� ���� */
        section.buttons { overflow: hidden; }
        section.buttons > label { 
            /* ���� ���� */
            display: block; float: right;

            /* ũ�� �� ���� ��ġ ����*/
            width: 100px; height: 30px;
            line-height: 30px;
            text-align: center;

            /* �׵θ� ���� */
            box-sizing: border-box;
            border: 1px solid black;

            /* ���� ����*/
            background: black;
            color: white;
        }
        input:nth-of-type(1):checked ~ section.buttons >  label:nth-of-type(1) {
            background: white;
            color: black;
        }
        input:nth-of-type(2):checked ~ section.buttons >  label:nth-of-type(2) {
            background: white;
            color: black;
        }
    </style>
    <!-- ��� -->
    <style>
        .item {
            overflow: hidden;
            padding: 10px;
            border: 1px solid black;
            border-top: none;
        }
        .thumbnail {
            float: left;
        }
        .description {
            float: left;
            margin-left: 10px;
        }
        .description > strong {
            display: block;
            width: 120px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
    <!-- Ǫ�� -->
    <style>
        #main_footer {
            /* �߾� ���� */
            width: 960px; margin: 0 auto;
            margin-bottom: 10px;

            /* �׵θ� */
            box-sizing: border-box;
            padding: 10px;
            border: 1px solid black;

            /* ���� ���� */
            text-align: center;
        }
    </style>
</head>
<body>
    <header id="main_header">
        <div id="title">
            <h1>Web Application for Big Data</h1>
            <h2>Join(ȸ�� ����)</h2>
        </div>
        <nav id="main_gnb">
            <ul>
                <li><a href="main.jsp">Web</a></li>
                <li><a href="#">Mobile</a></li>
                <li><a href="join.jsp">Join</a></li>
                <li><a href="#">Simulation</a></li>
                <li><a href="#">Data</a></li>
            </ul>
        </nav>
        <nav id="main_lnb">
            <ul>
                <li><a href="#">HTML5</a></li>
                <li><a href="#">CSS3</a></li>
                <li><a href="#">JavaScript</a></li>
                <li><a href="#">jQuery</a></li>
                <li><a href="#">Node.js</a></li>
            </ul>
        </nav>
    </header>
    <div id="content">
        <section id="main_section">
            <article class="main_article">
                	<h1>ȸ������ </h1>
                <div>
                	<fieldset style="border:1px dotted;">
                		<form action="addMember" method="post">
                		<table style="margin:auto"; width:80%;">
                			<tr>
                				<th style="color:red; height:40px">���̵�</th>
                				<td>
                				<input type="text" name="id" id="id"
                				style="height:30px"; font-size:13px">
                				</td>
                			</tr>
                			<tr>
                				<th>��й�ȣ</th>
                				<td>
                				<input type="password" name="pwd" id="pwd">
                				</td>
                			</tr>
                			<tr>
                				<th>���̵�</th>
                				<td>
                				<input type="name" name="name" id="name">
                				</td>
                			</tr>
                			<tr>
                			<td colspan="2" style="text-align:right">
                				<input type="submit" value="����">
                			</td>
                		</table>
                		</form>
                	</fieldset>
                </div>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in magna libero. Sed nec pharetra nunc. Proin eget magna id ipsum eleifend cursus sit amet nec lectus. Nunc quis lacus magna. Aliquam blandit, sapien ut viverra fermentum, elit tortor ornare nisi, in luctus sem massa pulvinar turpis. Cras tincidunt dictum urna ut ultricies. Nullam diam nibh, pellentesque non laoreet ut, bibendum nec mauris. Maecenas pulvinar porttitor laoreet. Vivamus bibendum purus nisl, eget aliquam lectus. Maecenas justo libero, euismod sit amet suscipit eu, vulputate eget neque. Aliquam quam est, blandit nec iaculis non, suscipit vel nunc. Proin et odio aliquam erat pharetra accumsan et quis neque. Vivamus interdum accumsan leo eu adipiscing. Integer accumsan elit non turpis faucibus porttitor. Aliquam scelerisque nisi et turpis pretium at ultricies turpis pharetra.</p>
            </article>
            <article class="main_article">
                <h1>Main Article</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in magna libero. Sed nec pharetra nunc. Proin eget magna id ipsum eleifend cursus sit amet nec lectus. Nunc quis lacus magna. Aliquam blandit, sapien ut viverra fermentum, elit tortor ornare nisi, in luctus sem massa pulvinar turpis. Cras tincidunt dictum urna ut ultricies. Nullam diam nibh, pellentesque non laoreet ut, bibendum nec mauris. Maecenas pulvinar porttitor laoreet. Vivamus bibendum purus nisl, eget aliquam lectus. Maecenas justo libero, euismod sit amet suscipit eu, vulputate eget neque. Aliquam quam est, blandit nec iaculis non, suscipit vel nunc. Proin et odio aliquam erat pharetra accumsan et quis neque. Vivamus interdum accumsan leo eu adipiscing. Integer accumsan elit non turpis faucibus porttitor. Aliquam scelerisque nisi et turpis pretium at ultricies turpis pharetra.</p>
            </article>
            <article class="main_article">
                <h1>Main Article</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in magna libero. Sed nec pharetra nunc. Proin eget magna id ipsum eleifend cursus sit amet nec lectus. Nunc quis lacus magna. Aliquam blandit, sapien ut viverra fermentum, elit tortor ornare nisi, in luctus sem massa pulvinar turpis. Cras tincidunt dictum urna ut ultricies. Nullam diam nibh, pellentesque non laoreet ut, bibendum nec mauris. Maecenas pulvinar porttitor laoreet. Vivamus bibendum purus nisl, eget aliquam lectus. Maecenas justo libero, euismod sit amet suscipit eu, vulputate eget neque. Aliquam quam est, blandit nec iaculis non, suscipit vel nunc. Proin et odio aliquam erat pharetra accumsan et quis neque. Vivamus interdum accumsan leo eu adipiscing. Integer accumsan elit non turpis faucibus porttitor. Aliquam scelerisque nisi et turpis pretium at ultricies turpis pharetra.</p>
            </article>
        </section>
        <aside id="main_aside">
            <input id="first" type="radio" name="tab" checked="checked" />
            <input id="second" type="radio" name="tab" />
            <section class="buttons">
                <label for="first">First</label>
                <label for="second">Second</label>
            </section>
            <div class="tab_item">
                <ul>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>HTML5 Canvas</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>HTML5 Audio</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>HTML5 Video</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>HTML5 Semantic Web</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                </ul>
            </div>
            <div class="tab_item">
                <ul>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>CSS3 Transition</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>CSS3 Animation</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>CSS3 Border</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                    <li class="item"><a href="#">
                        <div class="thumbnail">
                            <img src="http://placehold.it/45x45" />
                        </div>
                        <div class="description">
                            <strong>CSS3 Box</strong><p>2012-03-15</p>
                        </div>
                    </a></li>
                </ul>
            </div>
        </aside>
    </div>
    <footer id="main_footer">
        <h3>HTML5 + CSS3 Basic</h3>
        <address>Website Layout Basic</address>
    </footer>
</body>
</html>