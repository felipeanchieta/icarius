<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bibliotecas UFABC</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/icarius-style.css" rel="stylesheet">
  <link href="css/ufabc-style.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <script src="js/html5shiv.min.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<%--<jsp:include page="fragments/icarius-nav.jsp"></jsp:include>--%>

<section>
  <div class="container">
    <div class="row">
      <div class="col-md-12 center-block">
        <img class="img-responsive" src="img/icarius-main-logo.png" alt="Logotipo Icarius">
      </div>
    </div>

    <form class="form-horizontal" action="search" method="get" role="form">
      <div class="form-group">
        <input type="text" class="form-control" name="keywords" id="search-box" autofocus>
        <button type="submit" class="btn btn-default btn-search">Pesquisar</button>
      </div>
    </form>

  </div>
</section>

<%--<jsp:include page="fragments/icarius-footer.jsp"></jsp:include>--%>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/icarius-js.js"></script>
</body>
</html>
