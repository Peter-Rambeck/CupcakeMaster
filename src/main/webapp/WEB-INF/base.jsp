<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>

    <title>${requestScope.Title}</title>
</head>

<body class="">
<jsp:include page="/WEB-INF/widgets/navbar.jsp" flush="true"/>

<main role="main" class="container">
    <jsp:include page="${requestScope.content}" flush="true"/>
</main>

<footer class="footer mt-auto py-3">
    <div class="container">
        <span class="text-muted">Cupcake (version ${requestScope.version})</span>
    </div>
</footer>


<!-- Option 2: jQuery, Popper.js, and Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



</body>
</html>
